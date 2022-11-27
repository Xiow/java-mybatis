package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    User GetUserByUsername(String username);
    //参数为map
    int InsertUserByMap(Map<String,Object> map);

    //保存User信息，通过pojo类(非简单类型)
    int InsertUserByPojo(User user);

    //根据name和age进行查询(如果是多个参数的话:mybatis会自动创建一个Map集合,Map集合存储参数:
    // map.put("arg0",name)
    //map.put("arg0",age)
    //map.put("param1",name)
    //map.put("param2",age)
    // }
    List<User> SelectUserByNameAndAge(String name, int age);

    //通过Param注解来解决arg和param的不易解读的问题
    List<User> SelectUserByNameAndAgeByParam(@Param("name") String name, @Param("age")int age);

    //返回User类型
    User SelectById(int id);

    //模糊查询 :模糊查询的结果可能有多个也可能单一（期望的返回结果是一条，实际返回多条数据结果，导致结果出错)
    User SelectByBrandLike(String name);

    //实现分页查询
    List<User> selectByPage(@Param("startIndex")int startIndex,@Param("pageSize") int pageSize);

}
