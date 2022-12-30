作者：ChenZhen

博客地址：https://www.chenzhen.space/

版权：本文为博主 ChenZhen 的原创文章，本文版权归作者所有，转载请附上原文出处链接及本声明。

源码地址：https://github.com/chenzhen7/chenzhen-blog

如果对你有帮助，请给一个小小的star⭐



---

# 几个注意的点

1.先运行我给的sql文件创建数据库

2.运行项目之前先在yaml配置文件配置好数据源，这个不用多说了吧，我这边用的是Mysql8.0.11的版本，尽量不要用8以下的版本，不知道会不会有版本兼容的问题。

3.配置好自己的maven仓库，下载好对应的依赖

4.配置yaml中的邮箱地址（username）和授权码（password），具体怎么配置可以看我博客文章 https://www.chenzhen.space/blog/28 。

5.首页图片通过修改t_picture表中的第一条数据的picture_address字段的地址来修改

6.管理员账号密码有加密，从数据库表中看不出来，我提供的数据库中默认的账号是abc，密码是123456

5.Sql文件我放在根目录下不要忘了哦



# ChenZhen的博客

该项目技术栈(后端)：springboot + mybatis-Plus + Thymeleaf .....

在这里先感谢**李仁密**老师的b站视频：【SpringBoot开发一个小而美的个人博客】https://www.bilibili.com/video/BV1nE411r7TF?share_source=copy_web&vd_source=d8832ef814411d4572d6eb1d6763a454

和**onestar**大佬：博客地址：[首页-ONESTARの客栈](https://onestar.newstar.net.cn/)

在他们的基础上做了一些改进和变化，增加和减少了一些功能。

![000e9925e2ff42329d0561b090ff942d](https://user-images.githubusercontent.com/109839704/201456942-ea07a054-9c60-473d-b0b6-af68b57163a6.png)

