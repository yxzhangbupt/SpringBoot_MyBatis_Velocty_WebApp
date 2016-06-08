package com.meituan.demo.test.dao.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.meituan.demo.dao.mapper.StudentMapper;
import com.meituan.demo.dao.po.Student;
import com.meituan.demo.dao.po.StudentExample;
import com.meituan.demo.dao.po.StudentExample.Criteria;


public class StudentMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	SqlSession session;
	StudentMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		session = sqlSessionFactory.openSession();
		mapper = session.getMapper(StudentMapper.class);
	}

	@Test
	public void testDeleteByPrimaryKey() {
	}

	@Test
	public void testInsert() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = new Student();
			student.setId(1);
			student.setName("张钰鑫");
			student.setSex("1");
			mapper.insert(student);
			session.commit();
		} finally{
			session.close();
		}
	}

	@Test
	public void testSelectByExample() {
		
		try {
			StudentExample studentExample = new StudentExample();
			Criteria criteria = studentExample.createCriteria();
			criteria.andNameEqualTo("张钰鑫");
			criteria.andSexEqualTo("2");
			List<Student> selectByExample = mapper.selectByExample(studentExample);
			session.commit();
		} finally{
			session.close();
		}
	}

	@Test
	public void testSelectByPrimaryKey() {
	}

}
