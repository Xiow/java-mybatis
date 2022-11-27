package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.example.pojo.Student;

public interface StudentMapper {

    //使用sql注解进行CURD
    @Insert("insert into student values(null,#{name},#{age},#{age})")
    int insertStudent(Student student);

}
