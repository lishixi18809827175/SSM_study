package com.lishixi.mapper;

import com.lishixi.pojo.Emp;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @Auther: lishixi
 * @Date: 2021/11/14 - 11 - 14 - 12:53
 * @Description: com.lishixi.mapper
 * @version: 1.0
 */
public interface EmpMapper2 {
    /**
     * 根据员工任意属性查询员工信息
     * @param emp 要查询的emp对象
     * @return 查询成功返回Emp 对象的List集合
     */
    List<Emp> findEmpByCondition(Emp emp);

    /**
     * 根据员工任意属性查询员工信息
     * @param emp 要查询的emp对象
     * @return 查询成功返回Emp 对象的List集合
     */
    List<Emp> findEmpByCondition2(Emp emp);

    /**
     * 根据员工编号修改员工信息
     * @param emp 员工编号
     * @return 修改成功返回大于0的整数
     */
    int updateEmpByCondition(Emp emp);
    /**
     * 根据员工编号修改员工信息
     * @param emp 员工编号
     * @return 修改成功返回大于0的整数
     */
    int updateEmpByCondition2(Emp emp);

    /**
     * 根据多个员工部门编号查询员工信息
     * @param empnos 要查询的员工部门编号数组名
     * @return 多个Emp对象的list集合
     */
    List<Emp> findEmpByEmpnos(int[] empnos);
    /**
     * 根据多个员工部门编号查询员工信息
     * @param empnos 要查询的员工部门编号数组名
     * @return 多个Emp对象的list集合
     */
    List<Emp> findEmpByEmpnos2(List<Integer> empnos);
}