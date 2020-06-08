package com.mypj.service;

import com.mypj.entity.Place;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/8 - 15:50
 */
public interface PlaceService {

    List<Place> findByProvinceIdPage(Integer page,  Integer rows,  String provinceId);

    Integer findByProvinceIdCounts(String id);
}
