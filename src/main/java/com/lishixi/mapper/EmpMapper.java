package com.lishixi.mapper;

import com.lishixi.pojo.Emp;

import java.util.List;

/**
 * @Auther: lishixi
 * @Date: 2021/11/13 - 11 - 13 - 12:26
 * @Description: com.lishixi.mapper
 * @version: 1.0
 */
public interface EmpMapper {
    /**
     * 查询员工对象的全部信息
     * @return 返回多个员工对象的List集合
     */
    public List<Emp> findAll();
}
