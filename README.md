# micro-service
Demo project for micro-service

所有模块均使用 undertow 作为 servlet 容器。
使用 Docker 作为运行容器。

因为 spring-cloud-starter-netflix-eureka-server 已经包含了对 spring-boot-starter-web 的依赖，
所有模块不再单独添加该依赖。

###### 模块说明 ######
0. common : 系统通用模块

1. eureka-server : 注册中心

2. user-service : 用户相关业务服务模块

3. order-service : 订单相关业务服务模块
