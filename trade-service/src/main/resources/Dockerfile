# 基础镜像
FROM openjdk:11.0-jre-buster
# 拷贝jar包
COPY trade-service-1.0.0.jar /trade-service.jar
# 入口
ENTRYPOINT ["java", "-jar", "/trade-service.jar"]