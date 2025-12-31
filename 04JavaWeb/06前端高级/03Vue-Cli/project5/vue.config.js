const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 暂时先关闭eslint语法检查
  lintOnSave:false,
  // 服务相关配置
  devServer:{
    // 配置端口号
    // port:8081,
    // 配置代理：当前服务器代理的服务器
    // 所有向当前服务器发送来的ajax请求，都是走这个代理服务器
    // 这里是只代理一台服务器的写法
    // proxy:'http://localhost:5555',
    proxy:{
      // 配置第一台服务器
      '/api1':{
        // 代理地址
        target:'http://localhost:5555',
        // 路径重写
        pathRewrite:{
          // /api1是前置，是前端配置多个代理地址的标记，
          // 后端不需要，所以在往后端发送请求需要将该前缀替换成空
          '^/api1':''
        }
      },
      // 配置第二台服务器
      '/api2':{
        target:'http://localhost:4444',
        pathRewrite:{
          '^/api2':''
        }
      }
    }
  }
})
