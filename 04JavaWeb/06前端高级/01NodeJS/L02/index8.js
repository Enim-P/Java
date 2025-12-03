let fs = require('fs');

function myReader(file){
  return new Promise((resolve)=>{
    fs.readFile(file,(err,data)=>{
      resolve(data.toString())
    })
  })
}

// 返回4个Promise对象
let p1 = myReader("./file/province.txt")
let p2 = myReader("./file/city.txt")
let p3 = myReader("./file/district.txt")
let p4 = myReader("./file/street.txt")

// 同时执行多个Promise对象，并且按顺序返回结果
Promise.all([p1,p2,p3,p4])
.then(res=>{
  console.log(res);
})
