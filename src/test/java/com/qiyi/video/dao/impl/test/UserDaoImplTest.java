package com.qiyi.video.dao.impl.test;

import java.io.InputStream;
import java.util.Collection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qiyi.video.dao.UserDao;
import com.qiyi.video.dao.impl.UserDaoImpl;
import com.qiyi.video.domain.User;



public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 加载配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

	}

	@Test
	public void testgetUser() throws Exception {

		//构建dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		//调用 dao方法
		User user = userDao.getUser(9);
		
		System.out.println(user);
	}
	
	@Test
	public void testgetUserList() throws Exception {

		//构建dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		//调用 dao方法
		Collection<User> userList = userDao.getUserList();
		
		System.out.println(userList);
	}
	
	@Test
	public void testUpdateUser() throws Exception {

		//构建dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		User user = userDao.getUser(9);
		user.setName("小李");
		user.setEmail("xiaoli@qiyi.com");
		//调用 dao方法
		String addUser = userDao.updateUser(user);
	}
	
	@Test
	public void testAddUser() throws Exception {

		//构建dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		User user = new User();
		user.setName("小王");
		user.setEmail("xiaowang@qiyi.com");
		//调用 dao方法
		String addUser = userDao.addUser(user);
	}
	
	@Test
	public void testDeleteUser() throws Exception {

		//构建dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		//调用 dao方法
		String addUser = userDao.deleteUser(10);
	}
	

	
}
