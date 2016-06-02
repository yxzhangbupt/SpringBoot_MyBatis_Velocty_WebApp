package com.qiyi.video.dao;

import java.util.Collection;

import com.qiyi.video.domain.User;

public interface UserDao {
public  Collection<User> getUserList();
	
	public String addUser(User user);
	
	public User getUser(int id);
	
	public String updateUser(User user);
	
	public String deleteUser(int id);
}
