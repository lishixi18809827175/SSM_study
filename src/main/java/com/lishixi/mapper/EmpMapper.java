package com.lishixi.mapper;

import com.lishixi.pojo.Emp;
import jdk.nashorn.internal.ir.EmptyNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: lishixi
 * @Date: 2021/11/13 - 11 - 13 - 12:26
 * @Description: com.lishixi.mapper
 * @version: 1.0
 */
public interface EmpMapper {
    /**
     * 查询员工对象的全部信息
     * @return 返回全部员工封装的对象的List集合
     */
    public List<Emp> findAll();

    /**
     * 根据员工编号查询员工信息
     * @param empno 员工编号
     * @return 返回一个Emp对象
     */
    public Emp findByEmpno(int empno);

    /**
     * 根据员工部门和薪资下限查询员工信息
     * @param deptno 员工部门编号
     * @param sal 员工薪资
     * @return  返回多个Emp对象的list集合
     */
    List<Emp> findByDeptAndSal(@Param("deptno") int deptno,@Param("sal") double sal);

    /**
     *根据员工部门和薪资下限查询员工信息
     * @param emp 将传入的员工编号和薪资封装为一个Emp对象
     * @return 返回多个Emp对象的list集合
     */
    List<Emp> findByDeptAndSal2(Emp emp);

    /**
     * 根据员工部门和薪资下限查询员工信息
     * @param emp1 deptno
     * @param emp2 sal
     * @return 返回多个Emp对象的list集合
     */
    List<Emp> findByDeptAndSal3(Emp emp1,Emp emp2);

    List<Emp> findByDeptAndSal4(@Param("emp1") Emp emp1,@Param("emp2") Emp emp2);


    /**
     * 根据员工部门和薪资下限查询员工信息
     * @param map
     * @return 返回多个Emp对象的list集合
     */
    List <Emp> findByDeptAndSal5(Map<String,Object> map);

    /**
     * 根据员工姓名模糊查询员工信息
     * @param ename 员工姓名
     * @return 多个Emp对象的List集合
     */
    List <Emp> findByEname(String ename);

    /**
     * 向Emp表中增加员工
     * @param emp 新增员工信息的一个对象
     * @return 增加成功返回一个大于0的整数，失败返回null
     */
    int addEmp(Emp emp);

    /**
     * 根据员工编号删除员工信息
     * @param empno 要删除的员工编号
     * @return 删除成功返回一个大于0的整数，失败返回null
     */
    int deleteEmpByEmpno(int empno);

    /**
     * 根据员工编号修改员工姓名
     * @param empno 员工编号
     * @param ename 修改之后员工姓名
     * @return 修改成功返回一个大于0的整数，失败返回null
     */
    int updateEnameByEmpno(@Param("ename") String ename, @Param("empno") Integer empno);
}
