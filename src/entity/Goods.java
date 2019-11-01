package entity;

public class Goods {
	private Integer gId;// 商品ID
	private String gName;// 商品名称
	private double gPrice;// 商品单价
	private int gNum;// 商品库存
	private String remark;// 备注

	public Goods(Integer gId, String gName, double gPrice, int gNum, String remark) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gNum = gNum;
		this.remark = remark;
	}
	

	public Goods(Integer gId) {
		super();
		this.gId = gId;
	}


	public Goods() {
		super();
	}

	public Integer getgId() {
		return gId;
	}

	public void setgId(Integer gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public double getgPrice() {
		return gPrice;
	}

	public void setgPrice(double gPrice) {
		this.gPrice = gPrice;
	}

	public int getgNum() {
		return gNum;
	}

	public void setgNum(int gNum) {
		this.gNum = gNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
