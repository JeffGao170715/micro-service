## 基础镜像
From java
## 维护者信息
MAINTAINER JeffGao "157330205@qq.com"

## 工作路径
WORKDIR /data/eureka/

## 拷贝jar包到容器指定路径
ADD /micro-service/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar eureka.jar


## 暴露的端口号
EXPOSE 9000

## 启动jar包
ENTRYPOINT ["java", "-jar", "my.jar"]