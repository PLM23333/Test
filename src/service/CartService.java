package service;

import java.util.List;

import dao.IDao;
import dao.impl.CartDao;
import dao.impl.GoodsDaoImpl;
import entity.CartItems;
import entity.Goods;
import enums.ResponResult;
import enums.Status;

public class CartService {

	private CartDao cartDao = new CartDao();
	private IDao goodsDao = new GoodsDaoImpl();
	
//	//加入购物车
//	public ResponResult addItemToCart(Goods g, int num, String time) {
//		ResponResult res = new ResponResult(Status.SUCCESS);
//		CartItems cartItem = new CartItems();
//		Goods newG = goodsDao.selectGoodsById(g.getgId());
//		cartItem.setGoods(g);
//		cartItem.setInTime(time);
//		cartItem.setNum(num);
//		cartItem.setTotal(g.getgPrice() * num);
//		cartDao.insertCart(cartItem);
//		List<CartItems> cart = cartDao.selectItemsAll();
//		res.setObj(cart);
//		return res;
//	}
//	
//	//显示购物车信息
//	public ResponResult showCart() {
//		ResponResult rr = new ResponResult(Status.SUCCESS);
//		List<CartItems> items = cartDao.selectItemsAll();
//		rr.setObj(items);
//		return rr;
//	}
//	
//	//计算购物车总价
//	private double getAllTotal() {
//		List<CartItems> items = cartDao.selectItemsAll();
//		double sum = 0;
//		for (CartItems c : items) {
//			sum += c.getTotal();
//		}
//		return sum;
//	}
//	
//	//清空购物车
//	public void cleanCart() {
//		cartDao.cleanCart();
//	}
}
