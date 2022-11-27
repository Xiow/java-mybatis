###引入依赖:
mybatis依赖
mysql驱动依赖
### 在resouces目录下面新建mybatis的配置文件(
mybatis学习当中有两类xml文件，一是mybatis的配置文件,
二是:Mapper.xml文件（这类文件是用来编写Sql语句的）
)


###在mybatis的配置文件当中,会创建出来一个重要的对象，
也就是SqlSessionFactory对象，SqlSessionFactory对象
的创建也就是通过mybatis配置文件来进行创建的




mybatis-config.xml(配置数据库信息)


## 
Mapper.xml(语句)
　mybatis-config.xml(配置数据库信息)

### mybatis框架里面重要的三个对象
SqlSessionFactoryBuilder(通过它的builder方法:得到SqlSessionFactory对象)
SqlSessionFactory(通过它获取Sqlsession对象)
SqlSesssion(具体执行Sql语句的一个对象)



<!--    严格意义上来说：如果使用POJO对象来传值的时候,#{}代表什么呢
写的是get方法的方法名：然后将剩下的首字母小写，最后写进去：
<!--例如：getUsername()&ndash;&gt;#{username}-->
<!--    getEmail()&ndash;&gt;#{email}-->

select坑：
在类的属性名和数据库表的字段名不一致时候,使用select查询数据的时候,会产生查询出来的字段对不上的一个问题,
在XXXMapper.xml文件当中使用列的并别进行标识：
select 字段名 AS 类的属性名  进行相互的对应

XXXMapper.xml文件中使用namespace (namespace的使用是：用来区别相同id名的sql语句。在执行sql语句的时候，完整的SQL ID 写法是：namespace的名字+ID的实际名字)
例如:aaaa.selectAll


    <dataSource type="POOLED"> 指定数据源的类型就是使用什么数据库连接池
常用的数据库连接池有druid(阿里),C3p0,dbcp

使用mapper文件的接口,进行CRUD规则:
第一步：建立mapper文件夹,在ParamMeter.class(是个Interface Class文件)在文件写出方法 User GetUserByUsername(String username);

第二步: 
(1)编写MapperXML 文件,编写注意规则：MapperXMl文件名与接口文件名相同：
(2)例如:接口文件(ParaMeterMapper)和SQL映射文件(ParaMeterMapper.xml)文件名相同
(3):在SQL映射文件里面"<mapper namespace="org.example.mapper.ParameterMapper">"一定要指明namespace为mapper接口文件的全文件名

第三步:
在mapper核心配置文件，指定Mapper.XML文件  <mapper resource="ParameterMapper.xml"/>








    　　　　　　　　　　　　　　　　　　　　　