// 写入文件
let fs = require('fs');
// 导入路径模块
let path = require("path")
// resolve方法会根据当前系统的环境帮我们去拼接路径
// let ret = path.resolve('a','b','c','d')
// console.log(ret);


// writeFile方法，用于写入数据
// 参数1：文件地址，如果不存在会创建新文件
// 参数2：写入的数据
// 参数3：回调函数，回调函数的参数返回错误信息，没发生错误返回null

// 这里使用path.resolve方法拼接一个绝对路径
fs.writeFile(path.resolve(__dirname,'file','b.txt'),"正在学习NodeJS",(err)=>{
  if(err==null){
    console.log("写入成功！");
  }
})

