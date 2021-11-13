package com.lishixi.test;

import com.lishixi.mapper.DeptMapper;
import com.lishixi.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: lishixi
 * @Date: 2021/11/13 - 11 - 13 - 22:05
 * @Description: com.lishixi.test
 * @version: 1.0
 */
public class Test2 {
    SqlSession sqlSession = null;
    @Before
    public void init(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = null;

        {
            try {
                inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void testAddDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"JAVA","北京");
        System.out.println(dept.getDeptno());
        deptMapper.addDept(dept);
        //手动提交事务
        sqlSession.commit();
        System.out.println(dept.getDeptno());

    }
    @After
    public void release(){
        sqlSession.close();
    }

}
