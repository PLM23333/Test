package cache;

import java.util.ArrayList;
import java.util.List;

import entity.CartItems;
import entity.Goods;
import entity.User;

public final class Store {
	public static List<Goods> goodsBox = new ArrayList<>();
	public static List<User> userBox = new ArrayList<>();
	public static List<CartItems> goodsCart = new ArrayList<>();
	private Store(){}
}
