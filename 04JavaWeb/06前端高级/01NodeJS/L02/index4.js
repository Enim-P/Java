let fs = require('fs');

// 使用Promise来优化读取省 市 区 街道 信息

new Promise((resolve)=>{
  fs.readFile('./file/province.txt',(err,data)=>{
    resolve(data.toString())
  })
})
.then(p=>{
  console.log(p);
  if(p=="江苏省"){
    return new Promise((resolve)=>{
      fs.readFile('./file/city.txt',(err,data)=>{
        resolve(data.toString())
      })
    })
  }
})
.then(c=>{
  console.log(c);
  if(c=="南京市"){
    return new Promise((resolve)=>{
      fs.readFile('./file/district.txt',(err,data)=>{
        resolve(data.toString())
      })
    })
  }
})
.then(d=>{
  console.log(d);
  if(d=="雨花台区"){
    return new Promise((resolve)=>{
      fs.readFile('./file/street.txt',(err,data)=>{
        resolve(data.toString())
      })
    })
  }
})
.then(s=>{
  console.log(s);
})