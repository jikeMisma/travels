package com.mypj.Dao;

import com.mypj.entity.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/8 - 15:36
 */

@Mapper
public interface PlaceDao extends BaseDao<Place,String> {

    List<Place> findByProvinceIdPage(@Param("start") Integer start,@Param("rows") Integer rows,@Param("provinceId") String provinceId);

    Integer findByProvinceIdCounts(String id);
}
