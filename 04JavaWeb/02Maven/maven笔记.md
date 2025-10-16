### 什么是maven

Maven是apache旗下的一个开源项目，是一款用于管理和构建java项目的**工具**。

> Apache 软件基金会，成立于1999年7月，是目前世界上最大的最受欢迎的开源软件基金会，也是一个专门为支持开源项目而生的非盈利性组织。
>
> 开源项目：https://www.apache.org/index.html#projects-list



### 安装

- 安装步骤：

  1. 解压 apache-maven-3.6.1-bin.zip。

  2. 配置本地仓库：修改 conf/settings.xml 中的 `<localRepository>` 为一个指定目录。

     ```
     <localRepository>E:\develop\apache-maven-3.6.1\mvn_repo</localRepository>
     ```

  3. 配置阿里云私服：修改 conf/settings.xml 中的 <mirrors>标签，为其添加如下子标签：

     ```
     <mirror>
       <id>alimaven</id>
       <name>aliyun maven</name>
       <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
       <mirrorOf>central</mirrorOf>
     </mirror>
     ```

  4. 配置环境变量：MAVEN_HOME 为 maven 的解压目录，并将其bin目录加入PATH环境变量。

- 测试

  ```
  mvn -v
  ```



### IDEA 每次新建工程都要重新配置 Maven 解决方案

DEA 每次新建工程都要重新配置 Maven，是一件相当浪费时间的事情。这是因为在创建一个项目后，在 File -> Settings -> Build,Execution,Deployment -> Build Tools -> Maven下配置了 Maven home path 、 User settings file 和 Local repository，只对当前项目有效，再打开新项目还是默认的配置。而这个问题的解决方法就是进行全局配置。

- 选择 File -> New Projects Setup -> Settingsfor New Projects…

- 选择 Build,Execution,Deployment -> Build Tools -> Maven

  按照正常配置 Maven 的方法配置进行配置就行了

  注：配置完成后不要忘记点击 Apply 或者 OK 把配置应用一下！！！

到这里在 IDEA 中配置 Maven 全局配置就结束了，后面再新建项目就不需要再重新配置 Maven 了