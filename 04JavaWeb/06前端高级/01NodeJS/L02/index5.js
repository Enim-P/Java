let fs = require('fs');
// 使用Promise封装一个函数，对上一个案例做优化

function myReader(file){
  return new Promise((resolve)=>{
    fs.readFile(file,(err,data)=>{
      resolve(data.toString())
    })
  })
}

myReader('./file/province.txt')
.then(p=>{
  console.log(p);
  if(p=="江苏省"){
    return myReader('./file/city.txt')
  }
})
.then(c=>{
  console.log(c);
  if(c=="南京市"){
    return myReader('./file/district.txt')
  }
})
.then(d=>{
  console.log(d);
  if(d=="雨花台区"){
    return myReader('./file/street.txt')
  }
})
.then(s=>{
  console.log(s);
})