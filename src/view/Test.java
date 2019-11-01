package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.CartItems;
import entity.Goods;
import entity.User;
import enums.ResponResult;
import enums.Status;
import service.GoodService;
import service.UserService;
import util.DateUtil;
import service.CartService;

public class Test {

	public static void main(String[] args) throws Exception {
//		CartService cs = new CartService();
		GoodService gs = new GoodService();
		ResponResult sg = gs.showGoods(null);

		List<Goods> obj = (List<Goods>) sg.getObj();
		/*
		 * for(Goods g : obj) { System.out.println(g.getgId()+g.getgName()); }
		 */

		Goods goods = new Goods();
		goods.setgId(3);
		ResponResult showGoods = gs.showGoods(goods);
		Goods obj2 = (Goods) showGoods.getObj();
		System.out.println(showGoods.getStatus());
		// System.out.println(obj2.getgName()+obj2.getgNum());
		// gs.addGoods(new Goods(1, "商品1", 5.6, 500, ""));

		ArrayList goodBox = new ArrayList();
		List<String> str = new ArrayList<>();
		goodBox.add(new Goods(1, "商品1", 5.6, 500, ""));
		int size = goodBox.size();
		for (Object g : goodBox) {
			Goods g1 = (Goods) g;
			System.out.println(g1.getgId());
		}

		System.out.println("************************************************");
		UserService us = new UserService();
		// 查询用户
		User u = new User();
		u.setuId(1);
		ResponResult showUser = us.showUser(u);
		User user2 = (User) showUser.getObj();
		System.out.println(user2.getuId() + " " + user2.getuName());
		// 登录
		Scanner sc = new Scanner(System.in);
		System.out.print("用户名：");
		String acount = sc.next();
		System.out.print("密码：");
		String pwd = sc.next();
	    ResponResult loginStatus = null;
	    int status = -1;
	    do {
	    	loginStatus = us.login(new User(acount, pwd));
	    	status = loginStatus.getStatus();
	    	if(status == 1000) {
	    		break;
	    	}
	    	System.out.println("输入的账号密码不正确，请重新输入\n账号:");
	    	acount = sc.next();
	    	System.out.print("密码:");
	    	pwd = sc.next();
	    }while(true);
	    User userL = (User) loginStatus.getObj();//登陆成功后保存到状态类中的用户信息
	    System.out.println("欢迎:" + userL.getuName());
	    System.out.println("请输入要查找的物品的ID：");
	    int gId = sc.nextInt();
	    ResponResult res = gs.showGoods(new Goods(gId));
	    List<Goods> god = null;
	    if(res.getStatus() == 1000) {
	    	god = (List<Goods>) res.getObj();
	    }else if(res.getStatus() == 1001) {
	    	System.out.println("空指针");
	    }else {
	    	System.out.println("23333");
	    }
	    showGoods(god);
	    String flag = null;
	    do {
	    	addCart(sc, gs);
	    	System.out.println("是否继续添加到购物车?(y/n)");
	    	flag = sc.next();
	    }while(flag.equals("y"));
	}
	
	/*
	 * 显示商品
	 */
	private static void showGoods(List<Goods> goods) {
		System.out.println("商品ID\t商品名称\t商品库存\t商品单价");
		for (Goods g : goods) {
			System.out.println(g.getgId() + "\t" + g.getgName() + "\t" + g.getgNum() + "\t" + g.getgPrice());
		}
	}
	
	/*
	 * 添加商品到购物车
	 */
	private static void addCart(Scanner sc, GoodService cs) throws Exception {
		System.out.print("请选择商品加入购物车(商品ID):");
//	    		CartItems cartItems = new CartItems();
		int goodsId = sc.nextInt();
		Goods newGood = new Goods();
		newGood.setgId(goodsId);
		System.out.print("请输入加入购物车的商品数量:");
		int gNum = sc.nextInt();
//	    		cartItems.setNum(gNum);
		String time = DateUtil.dateToStr(new Date(), "yyyy-MM-dd");
//	    		cartItems.setInTime(time);
		ResponResult addItemToCart = cs.addItemToCart(newGood, gNum, time);
		int status = addItemToCart.getStatus();
		if (status == 1000) {
			System.out.println("加入成功");
			List<CartItems> carts = (List<CartItems>) addItemToCart.getObj();
			showCart(carts);
		} else {
			throw new Exception("加入失败，异常发生在addCart");
		}
	}
	
	/*
	 * 显示购物车里的商品
	 */
	private static void showCart(List<CartItems> item) {
		System.out.println("商品ID\t商品名称\t商品库存\t商品单价\t商品购买数\t商品总价\t加入时间");
		for (CartItems it : item) {
			System.out.println(it.getGoods().getgId() + "\t" + it.getGoods().getgName() + "\t" + it.getGoods().getgNum()
					+ "\t" + it.getGoods().getgPrice() + "\t" + it.getNum() + "\t" + it.getTotal() + "\t"
					+ it.getInTime());
		}
	}
}
