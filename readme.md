## 关于项目
该简单项目后端基于springBoot2.X和myBatis，前端使用Vue，整体上实现了前后端分离。

部分的前端展示页面和css样式等借鉴了部分网络作者的开源项目，在此向其作者表示感谢！

因为博主的能力有限，很多地方都存在不足，计划在之后的时未来的重构计划为：前台选用更加清晰的模板引擎，将页面设计的更加和谐美观，使用Redis中间件做缓存，在主主页加上各种景点的推荐，建景点的视频介绍部分加入系统中。

#### 技术架构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611150447429.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
* 后端：springBoot+mybatis，数据库mysql
* 前端Vue
## 功能介绍
本博客系统基于 SpringBoot 2.x ，支持快速开发，部署，服务器采用tomcat。

数据库采用常见的关系型数据库Mysql，ORM框架采用MyBatis，虽然是简单的management system，但是整体上技术框架采用目前流行的SSM和mvc的设计模式，所以整体上对于刚学习SSM的同学来说是一个不错的学习项目。

本系统支持用的登录注册。
系统整体实现了对于全国各个省份的旅游景点的管理。整体上包括省份信息的增删改查和各个身份下的景点的增删改查。

**代码整体架构预览**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611142752637.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

**系统整体配置**

```yaml
	server.port=8989
	spring.application.name=travels
	
	spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	spring.datasource.url=jdbc:mysql://localhost:3306/travels?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
	spring.datasource.username=root
	spring.datasource.password=277171
	
	mybatis.mapper-locations=classpath:com/mypj/mapper/*.xml
	mybatis.type-aliases-package=com.mypj.entity
	
	logging.level.root=info
	logging.level.com.mypj.Dao=debug
	spring.resources.static-locations=file:${upload.dir}
	
	upload.dir=E:/travles_images


```

## 页面预览
##### 登录
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611142835998.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

##### 省份列表
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611142911861.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
##### 添加省份
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611142929996.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
##### 景点列表
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020061114295737.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
##### 景点信息修改
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611143030706.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
## 数据结构和数据库
因为整体的逻辑结构不是很复杂，所以整体上系统只是维护了用户表user、省份表province、景点表place三张表，因此在数据库逻辑上是比较简单的。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611143856454.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

## 项目分层
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200611143144989.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
项目整体采用了MVC分层的后端设计模式。
**service层：** 整体为后台业务逻辑的实现，整体上前端的增删改查都是在这里调用。
**entity层（model层）：** 用于数据库实体逻辑的存放，实现了数据库字段的定义个get、set方法
**Dao层：** 整体上是个数据库打交道，也就是说在此层实现了真正的数据库操作代码。
**controller层：** 控制层，整体上实现和前端的交互和数据传递。
## 关于开源
目前由于部分代码存在缺陷，所以还未对代码进行开源，等之后有时间将一些常见的bug进行修改解决之后将会对系统进行开源，敬请期待。

