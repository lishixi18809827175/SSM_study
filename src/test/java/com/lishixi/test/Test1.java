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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lishixi
 * @Date: 2021/11/13 - 11 - 13 - 12:39
 * @Description: com.lishixi.test
 * @version: 1.0
 */
public class Test1 {

    SqlSession sqlSession = null;
    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
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
  @Test
  public void testFindByEmpno(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
      Emp emp = empMapper.findByEmpno(7936);
      System.out.println(emp);
  }
  @Test
  public void testFindByDeptnoAndSal(){
      EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
      List<Emp> emps  = empMapper.findByDeptAndSal(20, 1500.0);
      for (Emp emp : emps) {
          System.out.println(emps);
      }

  }
    @Test
    public void testFindByDeptnoAndSal2(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(3000.0);
        List<Emp> emps  = empMapper.findByDeptAndSal2(emp);
        emps.forEach(System.out::println);
    }
    @Test
    public void testFindByDeptnoAndSal3(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp();
        emp1.setDeptno(20);
         Emp emp2 = new Emp();
         emp2.setSal(3000.0);
        List<Emp> emps  = empMapper.findByDeptAndSal3(emp1,emp2);
        for (Emp emp : emps) {
            System.out.println(emps);
        }
    }
    @Test
    public void testFindByDeptnoAndSal4(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp();
        emp1.setDeptno(20);
        Emp emp2 = new Emp();
        emp2.setSal(3000.0);
        List<Emp> emps  = empMapper.findByDeptAndSal4(emp1,emp2);
        for (Emp emp : emps) {
            System.out.println(emps);
        }
    }

    @Test
    public void testFindByDeptAndSal5(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("deptno",20);
        map.put("sal",3000);
        List<Emp> emps = empMapper.findByDeptAndSal5(map);
        emps.forEach(System.out::println);
    }
    @Test
    public void testFindByEname(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findByEname("a");
        emps.forEach(System.out::println);
    }

    @After
  public void release(){
        sqlSession.close();
  }

}
