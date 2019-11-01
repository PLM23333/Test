package dao.impl;

import java.util.ArrayList;
import java.util.List;

import entity.CartItems;

public class CartDao {
	private static List<CartItems> goodsCart;
	
	public CartDao() {//新建购物车
		goodsCart = new ArrayList<>();
	}
	
	//将商品加入购物车
	public void insertCart(CartItems item) {
		goodsCart.add(item);
	}
	
	//浏览购物车
	public List<CartItems> selectItemsAll(){
		return goodsCart;
	}
	
	//清空购物车
	public void cleanCart() {
		goodsCart = new ArrayList<>();
	}
	

}
