package com.mypj.service.impl;

import com.mypj.Dao.PlaceDao;
import com.mypj.entity.Place;
import com.mypj.entity.Province;
import com.mypj.service.PlaceService;
import com.mypj.service.ProvinceService;
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

    @Autowired
    private ProvinceService provinceService;

    @Override
    public List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId) {

        int start = (page-1)*rows;
        return placeDao.findByProvinceIdPage(start,rows,provinceId);
    }

    @Override
    public Integer findByProvinceIdCounts(String id) {
        return placeDao.findByProvinceIdCounts(id);
    }

    @Override
    public void save(Place place) {
        //保存景点
        placeDao.save(place);
        //查询原始的省份信息
        Province province = provinceService.findOne(place.getProviceid());
        //更新省份信息的景点格式
        province.setPlacecounts(province.getPlacecounts()+1);
        provinceService.update(province);

    }
}
