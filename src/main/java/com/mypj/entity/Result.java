package com.mypj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author mazhicheng
 * @date 2020/6/6 - 14:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result {

    private Boolean states = true;
    private String mag;
    private String userId;
}
