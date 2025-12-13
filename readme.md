# 版本说明
- SpringCloudAlibaba 2022.0.0.2
- JDK17
- SpringBoot3.0.2
- Maven3.9.4
- IDEA2022.3

# 依赖版本管理
~~~xml

    <properties>
        <java.version>17</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <spring-boot.version>3.0.2</spring-boot.version>
        <spring-cloud-alibaba.version>2022.0.0.0</spring-cloud-alibaba.version>
        <spring-cloud.version>2022.0.0</spring-cloud.version>
    </properties>


    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring-cloud-alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
~~~




# SpringCloud Gateway
## 自定义断言工厂
1. 创建一个自定义类，类名有规定 XXRoutePredicateFactory。这个XX是以后再配置中对应的属性名
2. 继承AbstractRouteFactory抽象类，实现apply方法（在这个方法内些写具体的操作）、shortcutFileOrder方法，在这个方法规定参数名称的顺序，构造方法、具体属性在该类中定义一个内部类
3. 把这个类加入Spring容器管理
4. 修改配置文件

## 自定义网关过滤器工厂
1. 创建一个自定义类，类名有规定 XXGatewayFilterFactory,比如（AddHeaderGatewayFilterFactory）这个AddHeader是以后再配置中对应的属性名
2. 继承AbstractNameValueGatewayFilterFactory抽象类，实现apply方法（在这个方法内些写具体的操作，使用ServerWebExchange参数的mutate改变，添加请求头）
3. 把这个自定义类加入Spring容器管理
4. 修改配置文件：
~~~yaml
spring:
  cloud:
    gateway:
      routes:
        - id: xxx
          uri: xxx
          predicate:
            - Path=/**
          filter:
          - AddHeader=color,blue # 这个 AddHeader对应自定义类名的前缀 XX
~~~















# 分布式事务环境搭建

## 数据库信息

~~~mysql
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL COMMENT '账户名',
  `balance` decimal(10,2) NOT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '商品名称',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `goods_id` int NOT NULL COMMENT '商品id',
  `amount` decimal(10,2) NOT NULL COMMENT '订单 金额',
  `count` int NOT NULL COMMENT '订单数量',
  `account_id` int DEFAULT NULL COMMENT '账户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `count` int NOT NULL COMMENT '库存数量',
  `goods_id` int NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
~~~



## 创建微服务工程

1.  [seata-account-010](seata-account-010) 账户服务
2.  [seata-order-010](seata-order-010)  订单服务
3.  [seata-stock-010](seata-stock-010)  库存服务
4.  [seata-business-010](seata-business-010)  调用入口







