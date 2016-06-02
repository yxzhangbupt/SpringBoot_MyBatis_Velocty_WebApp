package com.qiyi.video.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.qiyi.video.dao.UserDao;
import com.qiyi.video.domain.User;
import com.qiyi.video.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;

	@Override
	public Collection<User> getUserList() {
		// TODO Auto-generated method stub
		return userdao.getUserList();
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
