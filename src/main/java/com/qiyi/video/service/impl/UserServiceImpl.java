package com.qiyi.video.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.qiyi.video.domain.User;
import com.qiyi.video.mapper.UserMapper;
import com.qiyi.video.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserServiceImpl() throws IOException{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	

	@Override
	public Collection<User> getUserList() throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> userList = mapper.findUserList("");
			return userList;
		} finally{
			session.close();
		}
	}

	@Override
	public String addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.insertUser(user);
			session.commit();
			return "Success";
		} finally{
			session.close();
		}
	}

	@Override
	public User getUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.findUserById(id);
			return user;
		} finally{
			session.close();
		}
	}

	@Override
	public String updateUser(long id, User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.updateUser(user);
			session.commit();
			return "Success";
		} finally{
			session.close();
		}
	}

	@Override
	public String deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.deleteById(id);
			session.commit();
			return "Success";
		} finally{
			session.close();
		}
	}

}
