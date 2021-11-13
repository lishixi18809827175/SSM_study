package com.lishixi.mapper;

import com.lishixi.pojo.Dept;

/**
 * @Auther: lishixi
 * @Date: 2021/11/13 - 11 - 13 - 21:50
 * @Description: com.lishixi.mapper
 * @version: 1.0
 */
public interface DeptMapper {
    /**
     * 增加部门
     * @param dept
     * @return Dept对象
     */
   int  addDept(Dept dept);
}
