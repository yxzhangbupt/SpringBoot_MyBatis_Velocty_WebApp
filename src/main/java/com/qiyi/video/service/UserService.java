package com.qiyi.video.service;

import java.util.Collection;
import com.qiyi.video.domain.User;

public interface UserService {
	public  Collection<User> getUserList();
	
	public String addUser(User user);
	
	public User getUser(long id);
	
	public String updateUser(long id,User user);
	
	public String deleteUser(long id);
}
