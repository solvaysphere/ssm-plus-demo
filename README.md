# ssm-plus-demo
Spring5整合Mybatis-Plus

```xml
<!-- Mybatis-plus:
  特别说明：引入 MyBatis-Plus 之后请不要再次引入 MyBatis 以及 MyBatis-Spring，以避免因版本差异导致的问题。
  -->
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>mybatis-plus</artifactId>
  <version>3.3.2</version>
</dependency>
```

### 版本说明
1. Spring: 5.2.6.RELEASE
2. Mybatis-Plus: 3.3.2
3. Mysql: 8.0.16
4. druid: 1.0.24

### Mybatis-Plus代码生成器配置
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.3.2</version>
</dependency>

<!-- 模板引擎 -->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.2</version>
</dependency>

 <!--如果配置Swagger2，需要引入依赖-->
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
​
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger2</artifactId>
   <version>2.9.2</version>
</dependency>

```
加入 slf4j ,查看日志输出信息
```xml
<!-- 日志依赖包 -->
<dependency>
  <groupId>log4j</groupId>
  <artifactId>log4j</artifactId>
  <version>1.2.17</version>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-api</artifactId>
  <version>1.7.30</version>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
  <version>1.7.30</version>
</dependency>
```
[代码生成器示例代码](https://baomidou.gitee.io/mybatis-plus-doc/#/generate-code)

### 插件扩展
分页插件 ： com.baomidou.mybatisplus.plugins.PaginationInterceptor
执行分析插件： com.baomidou.mybatisplus.plugins.SqlExplainInterceptor
性能分析插件： com.baomidou.mybatisplus.plugins.PerformanceInterceptor
乐观锁插件: com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor
```xml
<!--整合Mybatis-Plus配置-->
<bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <!--<property name="mapperLocations" value="classpath:/mappers/*.xml" />-->
    <!-- Mybatis Plus全局配置 -->
    <property name="globalConfig" ref="globalConfig"></property>
    <!-- Mybatis Plus插件配置 -->
    <property name="plugins">
        <array>
            <!-- 分页插件配置 -->
            <bean id="paginationInterceptor"
                  class="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor">
                <property name="countSqlParser" ref="countSqlParser" />
            </bean>
        </array>
    </property>
</bean>

<bean id="countSqlParser"
      class="com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize">
    <property name="optimizeJoin" value="true"/>
</bean>

<bean id="globalConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig">
    <property name="dbConfig" ref="dbConfig" />
</bean>

<bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig">
    <property name="logicDeleteValue" value="-1" />
    <property name="logicNotDeleteValue" value="1" />
</bean>

<!--Mapper接口包的扫描器-->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com.solvay.ssm.dao" />
</bean>
```
### [Mybatis-Plus逻辑删除配置](https://mybatis.plus/guide/logic-delete.html)
```xml
<bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig">
    <property name="logicDeleteValue" value="-1" />
    <property name="logicNotDeleteValue" value="1" />
</bean>
```
实体类字段上加上@TableLogic注解
```java
@TableLogic
private Integer deleted;
```