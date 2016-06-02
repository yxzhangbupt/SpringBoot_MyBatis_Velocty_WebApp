package com.qiyi.video.mapper;

import java.util.List;

import com.qiyi.video.domain.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserList(String name)throws Exception;
	
	public void insertUser(User user)throws Exception;
	
	public void deleteById(int id)throws Exception;
	
	public void updateUser(User user)throws Exception;
}
