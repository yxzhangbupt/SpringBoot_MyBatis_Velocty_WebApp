package com.qiyi.video.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qiyi.video.dao.UserDao;
import com.qiyi.video.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	// 注入SqlSessionFactory
	
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public Collection<User> getUserList() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> selectList = sqlSession.selectList("test.findUserList", "");
		sqlSession.commit();
		sqlSession.close();
		return selectList;
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		return "Success";
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.commit();
		sqlSession.close();
		return user;
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
		return "Success";
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("test.deleteById", id);
		sqlSession.commit();
		sqlSession.close();
		return "Success";
	}

}
