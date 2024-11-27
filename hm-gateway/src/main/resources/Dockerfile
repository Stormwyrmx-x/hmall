# 基础镜像
FROM openjdk:11.0-jre-buster
# 拷贝jar包
COPY hm-gateway-1.0.0.jar /hm-gateway.jar
# 入口
ENTRYPOINT ["java", "-jar", "/hm-gateway.jar"]