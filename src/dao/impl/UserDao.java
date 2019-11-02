package dao.impl;

import java.util.ArrayList;
import java.util.List;

import cache.Store;
import entity.User;

public class UserDao {
	private static List<User> userBox;
	
	//新建用户
	public UserDao() {
		userBox = Store.userBox;
		User u1 = new User(1, "a", "123");
		userBox.add(u1);
	}
	
	//添加用户
	public void insertUser(User u) {
		userBox.add(u);
	}
	
	//查看用户
	public static List<User> selectUserAll(){
		return userBox;
	}
	
	//查询单个用户
	public User selectUserById(int uId){
		List<User> us = selectUserAll();
		User user = null;
		for (User u : us) {
			if(u.getuId() == uId) {
				user = u;
				break;
			}
		}
		return user;
	}
	

}
