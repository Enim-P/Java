let fs = require('fs');

console.log("开始....");
// 读取地址信息
fs.readFile("./file/province.txt",(err,data)=>{
  console.log(data.toString());
})

fs.readFile("./file/city.txt",(err,data)=>{
  console.log(data.toString());
})

fs.readFile("./file/district.txt",(err,data)=>{
  console.log(data.toString());
})

fs.readFile("./file/street.txt",(err,data)=>{
  console.log(data.toString());
})
console.log("结束....");


// 通过观察上面代码的输出结果，发现每次输出的结果都是一样的
// 因为读取文件的参数是异步的，
// 在js中程序执行到异步操作时，会继续往下执行，不会等待异步操作执行完毕后再继续往下执行