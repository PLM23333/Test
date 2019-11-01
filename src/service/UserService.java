package service;

import java.util.List;

import dao.impl.UserDao;
import entity.User;
import enums.ResponResult;
import enums.Status;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public ResponResult addUser(User u) {
		userDao.insertUser(u);
		return new ResponResult(Status.SUCCESS);
	}
	
	public ResponResult showUser(User u) {
		ResponResult res = new ResponResult(Status.SUCCESS);
		User user = null;
		if(u == null) {
			List<User> userList = userDao.selectUserAll();
			res.setObj(userList);
		}else {
			user = userDao.selectUserById(u.getuId());
			res.setObj(user);
		}
		return res;
	}
	
	public ResponResult login(User u) {
		ResponResult res = new ResponResult(Status.SUCCESS);
		List<User> userList = UserDao.selectUserAll();
		for(User us : userList) {
			if(us.getuName().equals(u.getuName()) && us.getPwd().equals(u.getPwd())) {
				res = new ResponResult(Status.SUCCESS);
				res.setObj(u);
			}else {
				res = new ResponResult(Status.FAIL);
			}
		}
		return res;
	}
	
	
	
}
