package enums;

public class ResponResult {
	private int status;
	private String msg;
	private Object obj;

	public ResponResult(int status, String msg, Object obj) {
		super();
		this.status = status;
		this.msg = msg;
		this.obj = obj;
	}

	public ResponResult() {
		super();
	}

	public ResponResult(Status stu) {
		super();
		this.status = stu.getCode();
		this.msg = stu.getMsg();
	}
	
	public ResponResult(Status stu, Object o) {
		this.status = stu.getCode();
		this.msg = stu.getMsg();
		this.obj = o;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
