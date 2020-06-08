package com.mypj.service.impl;

import com.mypj.Dao.PlaceDao;
import com.mypj.entity.Place;
import com.mypj.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/8 - 15:51
 */

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDao placeDao;

    @Override
    public List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId) {

        int start = (page-1)*rows;
        return placeDao.findByProvinceIdPage(start,rows,provinceId);
    }

    @Override
    public Integer findByProvinceIdCounts(String id) {
        return placeDao.findByProvinceIdCounts(id);
    }
}
