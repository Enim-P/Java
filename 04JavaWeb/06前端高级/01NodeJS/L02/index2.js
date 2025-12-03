let fs = require('fs');
// 读取省份文件，如果是江苏省，再继续读取城市文件，如果是南京市，在继续读取区县文件
// 如果是雨花台区，再继续读取街道文件，并将所有的信息逐一打印

fs.readFile("./file/province.txt",(err,data)=>{
  let p = data.toString()
  console.log(p);
  if(p=="江苏省"){
    fs.readFile("./file/city.txt",(err,data)=>{
      let c = data.toString()
      console.log(c);
      if(c=="南京市"){
        fs.readFile("./file/district.txt",(err,data)=>{
          let d = data.toString()
          console.log(d);
          if(d=="雨花台区"){
            fs.readFile("./file/street.txt",(err,data)=>{
              let s = data.toString()
              console.log(s);
            })
          }
        })
      }
    })
  }
})

// 很多时候我们在处理异步代码时，需要它按照同步结果进行返回
// 这个时候，我们就需要采用回调函数嵌套的方式书写代码，因为异步结果都是通过回调函数返回
// 如果回调函数嵌套太深的话，代码就难以阅读了，我们称这样的代码为：回调地狱
