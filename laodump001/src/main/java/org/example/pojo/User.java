package org.example.pojo;


import lombok.Data;

@Data
public class User {
    //数据库表的字段名和类字段名相对应(userName这种属性在mysql对应的表字段为user_name)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
