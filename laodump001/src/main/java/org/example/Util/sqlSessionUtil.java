package org.example.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.Statement;

public class sqlSessionUtil {
    private sqlSessionUtil(){}
    private  static SqlSessionFactory sqlSessionFactory;
    //类加载时候执行
    //SqlSessionUtil第一次执行的时候,解析mybatis-config.xml文件,创建SqlSesssionFactory对象
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession openSession()  {
    return sqlSessionFactory.openSession();
    }
}
