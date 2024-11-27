# 基础镜像
FROM openjdk:11.0-jre-buster
# 拷贝jar包
COPY cart-service-1.0.0.jar /cart-service.jar
# 入口
ENTRYPOINT ["java", "-jar", "/cart-service.jar"]