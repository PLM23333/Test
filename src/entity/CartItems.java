package entity;

public class CartItems {
	private int itemId;//购物车子项ID
	private String inTime;//加入购物车的时间
	private Goods goods;//商品信息
	private int num;//加入的数量
	private double total;//总价
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public CartItems(int itemId, String inTime, Goods goods, int num) {
		super();
		this.itemId = itemId;
		this.inTime = inTime;
		this.goods = goods;
		this.num = num;
	}
	public CartItems() {
		super();
	}
	
}
