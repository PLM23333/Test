package service;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import dao.impl.CartDao;
import dao.impl.GoodsDaoImpl;
import entity.CartItems;
import entity.Goods;
import enums.ResponResult;
import enums.Status;

public class GoodService {
	private IDao<Goods> goodsDao = new GoodsDaoImpl();
	private CartDao cartDao = new CartDao();
	
	/**
	 * 删除商品
	 */
	public ResponResult delGoods(Goods g) {
		ResponResult res = new ResponResult(Status.SUCCESS);
		if(g == null) {
			res = new ResponResult(Status.NULL);
		}
		Integer getgId = g.getgId();
		if(goodsDao.isExist(getgId)) {
			res = new ResponResult(Status.FAIL);
		}else {
			goodsDao.deleteById(g.getgId());
		}
		return res;
	}

	/**
	 * 添加商品
	 */
	public ResponResult addGoods(Goods g) {
		ResponResult res = new ResponResult(Status.SUCCESS);
    	if(g == null) {
    		//throw new NullPointerException("异常发生在GoodService的addGoods方法");
    		res = new ResponResult(Status.NULL);
    	}
    	Integer getgId = g.getgId();
    	if(goodsDao.isExist(getgId)) {
    		res = new ResponResult(Status.FAIL);
    	}else {
    		goodsDao.insert(g);
    	}  	
    	return res;
    }
	
	/**
	 *查看商品
	 */
	public ResponResult showGoods(Goods g) {
		ResponResult res = new ResponResult(Status.SUCCESS);
		Goods good = null;
		Object obj = null;
    	try {
			if(g == null) {
				List<Goods> goodsList = goodsDao.selectAll();
				res.setObj(goodsList);
			}else {
				good = goodsDao.selectById(g.getgId());
				List<Goods> goods = new ArrayList();
				goods.add(good);
				res.setObj(good);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponResult(Status.NULL);
			res.setMsg("在showGoods方法里出现异常");
		}
    	return res;
    }

		//加入购物车
		public ResponResult addItemToCart(Goods g, int num, String time) {
			ResponResult res = new ResponResult(Status.SUCCESS);
			CartItems cartItem = new CartItems();
			Goods newG = goodsDao.selectById(g.getgId());
			cartItem.setGoods(newG);
			cartItem.setInTime(time);
			cartItem.setNum(num);
			cartItem.setTotal(newG.getgPrice() * num);
			cartDao.insertCart(cartItem);
			List<CartItems> cart = cartDao.selectItemsAll();
			res.setObj(cart);
			return res;
		}
		
		//显示购物车信息
		public ResponResult showCart() {
			ResponResult rr = new ResponResult(Status.SUCCESS);
			List<CartItems> items = cartDao.selectItemsAll();
			rr.setObj(items);
			return rr;
		}
		
		//计算购物车总价
		private double getAllTotal() {
			List<CartItems> items = cartDao.selectItemsAll();
			double sum = 0;
			for (CartItems c : items) {
				sum += c.getTotal();
			}
			return sum;
		}
		
		//清空购物车
		public void cleanCart() {
			cartDao.cleanCart();
		}
}
