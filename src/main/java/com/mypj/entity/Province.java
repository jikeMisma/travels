package com.mypj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author mazhicheng
 * @date 2020/6/7 - 9:44
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Province {


    //id	name	 tags	placecounts
    private String id;
    private String name;
    private String tags;
    private Integer placecounts;
}
