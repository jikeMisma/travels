package com.mypj.service.impl;

import com.mypj.Dao.ProvinceDao;
import com.mypj.entity.Province;
import com.mypj.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/7 - 10:03
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {


    @Autowired
    ProvinceDao provinceDao;

    @Override
    public List<Province> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return provinceDao.findByPage(start,rows);
    }

    @Override
    public Integer findTotals() {
        return provinceDao.findTotals();
    }

    @Override
    public void save(Province province) {
        province.setPlacecounts(0);//景点个数为0
        provinceDao.save(province);

    }

    @Override
    public void delete(String id) {
        provinceDao.delete(id);
    }

    @Override
    public Province findOne(String id) {
        return provinceDao.findOne(id);
    }

    @Override
    public void update(Province province) {
        provinceDao.update(province);
    }
}
