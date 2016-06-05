package com.qiyi.video.service;

import java.util.Collection;

import com.qiyi.video.domain.User;

public interface UserService {
	public  Collection<User> getUserList() throws Exception;
	
	public String addUser(User user)throws Exception;
	
	public User getUser(int id)throws Exception;
	
	public String updateUser(long id,User user)throws Exception;
	
	public String deleteUser(int id)throws Exception;
}
