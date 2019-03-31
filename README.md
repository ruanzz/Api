这是一个Api项目

最近在联调接口，想模拟第三方接口，所以就搭建了一个REST服务，最开始是基于SpringBoot，后面觉得太重了，直接把之前项目中使用到Jersey抽出来，只是用Jersey来搭建REST服务，为了后续方便，将这个东西开个仓库记录，后续如有需要可以直接拿来使用

使用Jersey搭建REST服务,只依赖Jersey和GSON包，比较轻量级

项目比较简单，直接启动`ApiApplication`即可。

可以修改访问路径，默认的是http://localhost:8080

```
| --src
   |--main
       |-- java
           |-- com  
               |-- ruanzz
                   |--rest  
                      |-- api REST接口
                      |-- resource 资源实体类
                   |--util  工具类 
                   |-- ApiApplication 启动入口
```


