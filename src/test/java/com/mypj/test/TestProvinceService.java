package com.mypj.test;

import com.mypj.TravelsApplication;
import com.mypj.entity.Province;
import com.mypj.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/7 - 10:07
 */

@SpringBootTest(classes = TravelsApplication.class)
@RunWith(SpringRunner.class)
public class TestProvinceService {

    @Autowired
    private ProvinceService provinceService;

    @Test
    public void testFindByPage(){
        List<Province> list = provinceService.findByPage(1,5);
        list.forEach(pr->{
            System.out.println(pr);
        });
    }
}
