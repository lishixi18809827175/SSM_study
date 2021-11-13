package com.lishixi.test;

import com.lishixi.mapper.DeptMapper;
import com.lishixi.mapper.EmpMapper;
import com.lishixi.pojo.Dept;
import com.lishixi.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @Auther: lishixi
 * @Date: 2021/11/13 - 11 - 13 - 22:05
 * @Description: com.lishixi.test
 * @version: 1.0
 */
public class Test3 {
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
    public void testAddEmp(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int rows = empMapper.addEmp(new Emp(null, "lishixi", "java", 7521,new Date(), 3000.0, 300.0, 20));
        System.out.println(rows);
        //手动提交事务
        sqlSession.commit();
    }
    @Test
    public void testUpdateEnameByEmpno(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int rows = empMapper.updateEnameByEmpno("赵康卫",7938);
        System.out.println(rows);
        //手动提交事务
        sqlSession.commit();
    }
    @Test
    public  void testDeleteEmpByEmpno(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int rows = empMapper.deleteEmpByEmpno(7938);
        System.out.println(rows);
        //手动提交事务
        sqlSession.commit();
    }
    @After
    public void release(){
        sqlSession.close();
    }

}
