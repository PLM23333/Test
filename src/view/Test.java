package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.IDao;
import dao.impl.GoodsDaoImpl;
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

//		List<Goods> obj = (List<Goods>) sg.getObj();
//		/*
//		 * for(Goods g : obj) { System.out.println(g.getgId()+g.getgName()); }
//		 */
//
//		Goods goods = new Goods();
//		goods.setgId(3);
//		ResponResult showGoods = gs.showGoods(goods);
//		Object obj2 = showGoods.getObj();
//		System.out.println(showGoods.getStatus());
//		// System.out.println(obj2.getgName()+obj2.getgNum());
//		// gs.addGoods(new Goods(1, "商品1", 5.6, 500, ""));
//
//		ArrayList goodBox = new ArrayList();
//		List<String> str = new ArrayList<>();
//		goodBox.add(new Goods(1, "商品1", 5.6, 500, ""));
//		int size = goodBox.size();
//		for (Object g : goodBox) {
//			Goods g1 = (Goods) g;
//			System.out.println(g1.getgId());
//		}

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
//		System.out.print("用户名：");
//		String acount = sc.next();
//		System.out.print("密码：");
//		String pwd = sc.next();
//		ResponResult loginStatus = null;
//		int status = -1;
//		do {
//			loginStatus = us.login(new User(acount, pwd));
//			status = loginStatus.getStatus();
//			if (status == 1000) {
//				break;
//			}
//			System.out.println("输入的账号密码不正确，请重新输入");
//			System.out.print("账号:");
//			acount = sc.next();
//			System.out.print("密码:");
//			pwd = sc.next();
//		} while (true);
//		User userL = (User) loginStatus.getObj();// 登陆成功后保存到状态类中的用户信息
//		System.out.println("欢迎:" + userL.getuName());
		String flag = null;
		List<Goods> god = null;
		ResponResult respStart = gs.showGoods(null);
		god = (List<Goods>) respStart.getObj();
		showGoods(god);
		int index = 11;
		while (index != 0) {
			System.out.println("**************************************");
			System.out.println("1.添加商品\t\t\t2.删除商品\n3.修改商品信息\t\t4.查询单条商品信息\n5.查询全部商品信息\t\t6.添加商品到购物车\n"
					+ "7.从购物车删除商品\t\t8.修改购物车内商品属性\n9.查询购物车单条商品信息\t10.查看购物车所有商品信息\n0.退出");
			System.out.println("选择业务:");
			index = sc.nextInt();
			switch (index) {
			case 1:
				/*
				 * 添加商品
				 */
				do {
					addGoods(sc, gs);
					System.out.println("是否继续添加到购物车?(y/n)");
					flag = sc.next();
				} while (flag.equals("y"));
				break;

			case 2:
				/*
				 * 删除商品
				 */
				do {
					delGoods(sc, gs);
					System.out.println("继续删除?(y/n)");
					flag = sc.next();
				}while (flag.equals("y"));
				break;

			case 3:
				/*
				 * 修改商品信息
				 */
				break;
			case 4:
				/*
				 * 查询单条商品信息
				 */
				god = null;
				System.out.print("请输入要查找的物品的id：");
				int gId = sc.nextInt();
				ResponResult respOne = gs.showGoods(new Goods(gId));
				if (respOne.getStatus() == 1000) {
					god = (List<Goods>) respOne.getObj();
				} else if (respOne.getStatus() == 1001) {
					System.out.println("找不到该商品信息");
				}
				showGoods(god);
				break;

			case 5:
				/*
				 * 查询全部商品信息
				 */
				god = null;
				ResponResult respAll = gs.showGoods(null);
				god = (List<Goods>) respAll.getObj();
				showGoods(god);
				break;

			case 6:
				/*
				 * 添加商品到购物车
				 */
				do {
					addCart(sc, gs);
					System.out.println("是否继续添加到购物车?(y/n)");
					flag = sc.next();
				} while (flag.equals("y"));
				break;

			case 7:
				/*
				 * 从购物车删除商品
				 */
				break;

			case 8:
				/*
				 * 修改购物车内商品属性
				 */
				break;

			case 9:
				/*
				 * 查询购物车单条商品信息
				 */
				break;

			case 10:
				/*
				 * 查看购物车所有商品信息
				 */
				break;

			case 0:
				index = 0;
				System.out.println("886!!!");
				break;

			default:
				index = 0;
				break;
			}
		}
		sc.close();
	}

	/*
	 * 添加商品
	 */
	private static void addGoods(Scanner sc, GoodService gs) {
		System.out.println("输入商品ID：");
		int gId = sc.nextInt();
		System.out.println("输入商品名称：");
		String gName = sc.next();
		System.out.println("输入商品单价：");
		double gPrice = sc.nextDouble();
		System.out.println("输入商品库存数：");
		int gNum = sc.nextInt();
		Goods newGood = new Goods(gId, gName, gPrice, gNum);
		ResponResult addGoodToWareHouse = gs.addGoods(newGood);
		int res = addGoodToWareHouse.getStatus();
		if (res == 1000) {
			System.out.println("加入成功");
		} else {
			System.out.println("添加失败");
		}
	}
	
	/*
	 * 删除商品
	 */
	private static void delGoods(Scanner sc, GoodService gs) {
		System.out.println("输入商品id：");
		int gId = sc.nextInt();
		ResponResult delGoodsRes = gs.delGoods(new Goods(gId));
		int delRes = delGoodsRes.getStatus();
		if(delRes == 1000) {
			System.out.println("删除成功");
		} else {
			System.out.println("失败");
		}
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
