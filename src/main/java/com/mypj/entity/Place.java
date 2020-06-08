package com.mypj.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author mazhicheng
 * @date 2020/6/8 - 15:30
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Place {

    //id	 name	picpath	hottime	hotticket	dimticket	placedis	proviceid
    private String id;
    private String name;
    private String picpath;
    private Date hottime;
    private Double hotticket;
    private Double dimticket;
    private String placedis;
    private String proviceid;


}
