package com.lishixi.test;

import com.lishixi.mapper.EmpMapper2;
import com.lishixi.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.text.resources.FormatData;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: lishixi
 * @Date: 2021/11/14 - 11 - 14 - 14:25
 * @Description: com.lishixi.test
 * @version: 1.0
 */
public class Test4 {
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

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void testFindEmpByCondition(){
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
       //emp.setEname("SMITH");
        emp.setEname("A");
        List<Emp> emps = mapper.findEmpByCondition(emp);
        emps.forEach(System.out::println);

    }
    @Test
    public void testFindEmpByCondition2(){
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        //emp.setEname("SMITH");
        //emp.setEname("A");
        emp.setEmpno(7936);
        List<Emp> emps = mapper.findEmpByCondition(emp);
        emps.forEach(System.out::println);

    }

    @Test
    public void testUpdateEmpByCondition() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7939);
        emp.setEname("李世希");
        emp.setJob("java架构师");
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-15"));
        int rows = mapper.updateEmpByCondition(emp);
        System.out.println(rows);
        sqlSession.commit();
    }

    @Test
    public void testUpdateEmpByCondition2() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7939);
        emp.setEname("lishixi");
        emp.setJob("java架构师");
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-15"));
        int rows = mapper.updateEmpByCondition(emp);
        System.out.println(rows);
        sqlSession.commit();
    }
    @Test
    public void testFindByempnos() throws ParseException {
       EmpMapper2 empMapper2 = sqlSession.getMapper(EmpMapper2.class);
        int[] empnos = {7521, 7521, 7936, 7934};
        List<Emp> emps = empMapper2.findEmpByEmpnos(empnos);
        for (Emp emp : emps) {
            System.out.println(emps);
        }
    }
    @Test
    public void testFindByempnos2() throws ParseException {
        EmpMapper2 empMapper2 = sqlSession.getMapper(EmpMapper2.class);
        List<Integer>empnos = new ArrayList<>();
        Collections.addAll(empnos,7521, 7521, 7936, 7934);
        List<Emp> emps = empMapper2.findEmpByEmpnos2(empnos);
        for (Emp emp : emps) {
            System.out.println(emps);
        }
    }
    @After
    public void release(){
        sqlSession.close();
    }


}
