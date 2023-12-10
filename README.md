# hmall
黑马商城-微服务

# 服务启动流程
- nacos服务注册，公共配置读取和热更新(bootstrap.yaml)
- 定义网关路由和过滤器，用来登录校验，成功后传递用户信息(hmall-gateway)
- 定义拦截器，读取用户信息到userContext(hmall-common)
- 定义openfeign远程调用，同时添加openfeign拦截器，在请求中添加用户信息(hmall-api)
<img src="https://cdn.jsdelivr.net/gh/Stromwyrm-x/blog-image/img/image-20231209211440937.png" alt="image-20231209211440937" style="zoom:33%;" />
- 