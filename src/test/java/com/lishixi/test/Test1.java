package com.lishixi.test;
import com.lishixi.mapper.EmpMapper;
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
import java.util.List;

/**
 * @Auther: lishixi
 * @Date: 2021/11/13 - 11 - 13 - 12:39
 * @Description: com.lishixi.test
 * @version: 1.0
 */
public class Test1 {

    SqlSession sqlSession = null;
    @Before
    public void init(){ SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream inputStream = null;

        {
            try {
                inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SqlSessionFactory sqlSessionFactory = ssfb.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
  @Test
  public void testFindAll(){
      EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
       List<Emp> emps = empMapper.findAll();
       emps.forEach(System.out::println);
  }

  @After
  public void release(){
        sqlSession.close();
  }

}
