# 要修改的文件配置

application.yml   主要是mysql配置

##### 备注：
jdbc.properties 是用来自动生成代码的，请不要修改。

# 要点

静态资源文件放在static

jsp放在templates

#成功标志

运行AdminServiceTest 结果成功即可


运行OnlineOrderingSystemApplication，
访问[http://localhost:9090/](http://localhost:9090/)

# 环境

如果用mysql8,url见相关注解
springboot 2.0.2

# 存在的问题

对于WEB存在的问题是，JSP相对于一些模板引擎，性能都比较低。在开发中通常会被替代...
相对于SpringBoot虽然继承并不难但是却SpringBoot并不太喜欢和JSP一起用......为啥呢？
SpringBoot我们之前也说过可以通过打成的JAR包并且里面有自带的网络容器..但是JSP的springBoot就只能是War包...

# 其他

我在application.yml中暴露的端口为9090

Springboot的默认视图支持是Thymeleaf。默认情况下，springboot是不支持jsp的访问的。
如何使用jsp[点我](https://blog.csdn.net/qq_15260315/article/details/80907056) 
(我没有实现兼容jsp)


mybaits二级缓存打算用Redis。


# 总的来说：由组长决定使用 jsp 还是 thymeleaf 