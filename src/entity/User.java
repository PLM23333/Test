package entity;

public class User {
	private int uId;
	private String uName;
	private String pwd;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(int uId, String uName, String pwd) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.pwd = pwd;
	}
	public User() {
		super();
	}
	public User(String uName, String pwd) {
		super();
		this.uName = uName;
		this.pwd = pwd;
	}
	
}
