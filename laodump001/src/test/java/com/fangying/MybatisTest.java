package com.fangying;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Util.sqlSessionUtil;
import org.example.mapper.ParameterMapper;
import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.example.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {


    @Test
    public void TestinsertStudentByAnotations(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student=new Student();
        student.setName("xw");
        student.setAge(9999);
        student.setEmail("xw@qq.com");
        int i = mapper.insertStudent(student);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void TestselectByPage(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int pageSize=3;
        int pageNum=2;
        int startIndex=(pageNum-1)*pageSize;
        List<User> users = mapper.selectByPage(startIndex, 3);

        users.forEach(user -> System.out.println(user));

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void TestSelectByBrandLike(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.SelectByBrandLike("大表哥");
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void TestSelectById(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.SelectById(9);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void SelectUserByNameAndAgeByParam(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users = mapper.SelectUserByNameAndAgeByParam("老北京", 999);
        users.forEach(user -> System.out.println(user));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void SelectUserByNameAndAge(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users = mapper.SelectUserByNameAndAge("老北京", 999);
        users.forEach(user -> System.out.println(user));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void  TestInsertUserByPojo(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=new User();
        user.setName("天府新青年");
        user.setAge(99);
        user.setEmail("tf@163.com");
        int c = mapper.InsertUserByPojo(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(c);
    }


    @Test
    public void  TestInsertUserByMap(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map=new HashMap<>();
        map.put("name","衰微");
        map.put("age",98765);
        map.put("email","98874@gmail.com");
        int c = mapper.InsertUserByMap(map);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(c);
    }



    @Test
    public  void testMapperClass(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.GetUserByUsername("大表哥");
        System.out.println(user);
    }

    @Test
    public void  testSelectAll(){
        SqlSession sqlSession = sqlSessionUtil.openSession();

        List<Object> User  = sqlSession.selectList("org.mybatis.example.BlogMapper.selectAll");
        System.out.println(User);
        sqlSession.commit();
        sqlSession.close();
    }




    @Test
    public void  testSelectByid(){
        SqlSession sqlSession = sqlSessionUtil.openSession();

        Object User  = sqlSession.selectOne("selectById", 2);
        System.out.println(User);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public  void updateUserById(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        User user   =new User();
        user.setId(2);
        user.setName("大表哥");
        user.setAge(321);
        user.setEmail("fengtiaan@gmail.com");
        sqlSession.update("updateById",user);
        sqlSession.commit();
        sqlSession.close();
    }




    @Test
    public  void deleteUserById(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        sqlSession.delete("deleteUserById",1);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public  void testInsertByPOJO(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        User user=new User();
        user.setName("东三省");
        user.setAge(1999);
        user.setEmail("liaoning@gmail.com");
        sqlSession.insert("insertUser2",user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void  ByCURD(){
        SqlSession sqlSession = sqlSessionUtil.openSession();
        Map<String,Object> map=new HashMap<>();
        map.put("k1","天津卫");
        map.put("k2",666);
        map.put("k3","666@sina.com");
        sqlSession.insert("insertUser1",map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void  TestSqlsessionByUtil() {
        SqlSession sqlSession = sqlSessionUtil.openSession();
        int insertUser = sqlSession.insert("insertUser");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void testMYbatis() throws  Exception {
    SqlSession sqlSession=null;
    //获取SqlSessionFactoryBuilder对象
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    //获取SqlSessionFactory对象
    InputStream inputStream = null;
    try {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //执行SQL语句(执行的sql语句使用id来做标识)
        int insertUser = sqlSession.insert("insertUser");
        //mybatis默认不会提交事务，需要我们手动提交commit()
        sqlSession.commit();
        System.out.println("插入了几句："+insertUser);
    } catch (IOException e) {
        if (sqlSession==null){
            sqlSession.rollback();
        }
        throw new RuntimeException(e);

    }finally {
        //关闭会话
        if (sqlSession==null){
            sqlSession.close();
        }
    }
}


}
