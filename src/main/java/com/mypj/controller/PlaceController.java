package com.mypj.controller;

import com.mypj.entity.Place;
import com.mypj.entity.Result;
import com.mypj.service.PlaceService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Value("${upload.dir}")
    private String realPath;

    /**
     * 查询景点信息
     */
    @PostMapping("update")
    public  Result update(MultipartFile pic,Place place) {
        Result result = new Result();
        try{
            //文件上传
            String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
            String newFilename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+extension;
            //base64
            place.setPicpath(Base64Utils.encodeToString(pic.getBytes()));
            pic.transferTo(new File(realPath,newFilename));

            //修改景点信息
            placeService.update(place);
            result.setMag("修改景点信息成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setStates(false).setMag(e.getMessage());
        }

        return  result;
    }

    /**
     * 查询景点信息
     * @param id
     * @return
     */
    @GetMapping("findOne")
    public Place findOne(String id){
        return placeService.findOne(id);
    }

    /**
     * 景点删除方法
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(String id){
        Result result = new Result();
        try{
            placeService.delete(id);
            result.setMag("删除景点信息成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setStates(false).setMag(e.getMessage());
        }
        return result;
    }


    /**
     * 保存景点信息
     * @param file
     * @return
     */
    @PostMapping("save")
    public Result save(MultipartFile file, Place place) throws IOException {

//        System.out.println(file.getOriginalFilename());
//        System.out.println(place);
        Result result = new Result();
        try{

            //文件上传
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String newFilename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+extension;
            //base64
            place.setPicpath(Base64Utils.encodeToString(file.getBytes()));
            file.transferTo(new File(realPath,newFilename));
            //place对象的保存
            placeService.save(place);
            result.setMag("保存景点信息成功！");
        }catch (Exception e){
            result.setStates(false).setMag(e.getMessage());
        }



        return result;
    }
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
