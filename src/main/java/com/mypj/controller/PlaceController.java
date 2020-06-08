package com.mypj.controller;

import com.mypj.entity.Place;
import com.mypj.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mazhicheng
 * @date 2020/6/8 - 16:05
 */

@RestController
@CrossOrigin
@RequestMapping("place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;
    /**
     * 根据省份id查询景点方法
     */

    @GetMapping("findAllPlace")
    public Map<String,Object> findAllPlace(Integer page,Integer rows,String provinceId){

        HashMap<String,Object> result = new HashMap<>();
        page = page==null?1:page;
        rows = rows==null?3:rows;
        //景点集合
        List<Place> places = placeService.findByProvinceIdPage(page,rows,provinceId);
        //处理分页
        Integer counts = placeService.findByProvinceIdCounts(provinceId);
        //计算总页数
        Integer totalPage = counts%rows==0?counts/rows:counts/rows+1;
        result.put("places",places);
        result.put("page",page);
        result.put("counts",counts);
        result.put("totalPage",totalPage);
        return result;


    }
}
