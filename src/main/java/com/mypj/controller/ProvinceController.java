package com.mypj.controller;

import com.mypj.entity.Province;
import com.mypj.entity.Result;
import com.mypj.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mazhicheng
 * @date 2020/6/7 - 10:22
 */

@RestController
@CrossOrigin
@RequestMapping("/province")
public class ProvinceController {


    @Autowired
    private ProvinceService provinceService;

    /**
     * 修改省份信息
     */
    @PostMapping("update")
    public Result update(@RequestBody Province province){
        Result result =new Result();
        try{
            provinceService.update(province);
            result.setMag("修改省份信息成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setStates(false).setMag(e.getMessage());
        }

        return result;
    }

    /**
     * 查询一个省份的信息进行修改
     */
    @GetMapping("findOne")
    public Province findOne(String id){
        return provinceService.findOne(id);

    }

    /**
     * 删除省份
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Result delete(String id){
        Result result = new Result();
        try{
            provinceService.delete(id);
            result.setMag("删除省份信息成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setStates(false).setMag("删除省份信息失败！");
        }

        return result;
    }



    /**
     * 保存省份信息
     * @param province
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Province province){
        Result result = new Result();
        try{
            provinceService.save(province);
            result.setMag("保存省份信息成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setStates(false).setMag("保存省份信息失败！");
        }

        return result;
    }

    /**
     * 查询所有
     * @param page
     * @param rows
     * @return
     */

    @GetMapping("/findByPage")
    public Map<String,Object> findByPage(Integer page,Integer rows){
        //赋初始值
        page = page==null?1:page;
        rows = rows==null?4:rows;
        HashMap<String,Object> map = new HashMap<>();

        //分页处理
        List<Province> provinces = provinceService.findByPage(page,rows);
        //计算总页数
        Integer totals = provinceService.findTotals();
        Integer totalsPage = totals%rows==0?totals/rows:totals/rows+1;
        map.put("provinces",provinces);
        map.put("totals",totals);
        map.put("totalsPage",totalsPage);
        map.put("page",page);
        return map;
    }
}
