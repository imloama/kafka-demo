kafka zookeeper 示例
===

1. 启动zookeeper

> * 执行zkServer.cmd命令，注意修改conf/zoo.cfg文件

2. 启动kafka：

> * 下载kafka：http://kafka.apache.org
> * 解压后，修改config/server.properties配置
> * bin/windows/kafka-server-start.bat config/server.properties

3. 运行代码：

> * 采用mvn结构
> * kafka-demo-sample是示例项目，先运行ProducerMain，再运行ConsumerMain

