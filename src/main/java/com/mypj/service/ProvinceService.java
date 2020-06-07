package com.mypj.service;

import com.mypj.entity.Province;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/7 - 10:01
 */
public interface ProvinceService {


    /**
     *
     * @param page 当前页
     * @param rows 每页显示的记录数
     * @return
     */
    List<Province> findByPage(Integer page, Integer rows);

    //查询总条数
    Integer findTotals();

    //保存省份的方法
    void save(Province province);

    //删除省份的方法
    void delete(String id);
}
