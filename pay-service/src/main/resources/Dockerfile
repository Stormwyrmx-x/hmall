# 基础镜像
FROM openjdk:11.0-jre-buster
# 拷贝jar包
COPY pay-service-1.0.0.jar /pay-service.jar
# 入口
ENTRYPOINT ["java", "-jar", "/pay-service.jar"]