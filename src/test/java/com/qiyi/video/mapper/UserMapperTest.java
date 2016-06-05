package com.qiyi.video.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qiyi.video.domain.User;

public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.findUserById(1);
			System.out.println(user);
		} finally{
			session.close();
		}
	}

	@Test
	public void testFindUserList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> userList = mapper.findUserList("");
			System.out.println(userList);
		} finally{
			session.close();
		}
	}

	@Test
	public void testInsertUser() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setName("小黄");
			user.setEmail("xiaohaung@qiyi.com");
			mapper.insertUser(user);
			session.commit();
		} finally{
			session.close();
		}
	}

	@Test
	public void testDeleteById() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.deleteById(14);
			session.commit();
		} finally{
			session.close();
		}
	}

	@Test
	public void testUpdateUser() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.findUserById(9);
			user.setName("小李子");
			mapper.updateUser(user);
			session.commit();
		} finally{
			session.close();
		}
	}

}
