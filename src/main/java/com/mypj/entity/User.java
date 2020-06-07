package com.mypj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author mazhicheng
 * @date 2020/6/5 - 21:27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    //id	username	 password	email
    private String id;
    private String username;
    private String password;
    private String email;

}
