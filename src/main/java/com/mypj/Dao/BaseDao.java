package com.mypj.Dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/7 - 9:47
 */
public interface BaseDao<T,K> {

    void save(T t);

    void update(T t);

    void delete(K k);

    List<T> findAll();

    T findOne(K k);

    //分页
    List<T> findByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    Integer findTotals();

}
