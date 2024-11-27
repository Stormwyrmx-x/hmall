# 基础镜像
FROM openjdk:11.0-jre-buster
# 拷贝jar包
COPY user-service-1.0.0.jar /user-service.jar
# 入口
ENTRYPOINT ["java", "-jar", "/user-service.jar"]