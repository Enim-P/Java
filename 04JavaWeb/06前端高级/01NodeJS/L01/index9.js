// 导入文件系统模块，导入系统模块，直接根据系统模块的名称导入
let fs = require('fs')

// readFile方法，读取文件
// 参数1：读取文件的路径
// 参数2：回调函数，回调函数的一个参数返回错误信息，第二个参数返回读取的数据
fs.readFile("./file/a.txt",(err,data)=>{
  // 读取数据时，如果没有发生错误，err返回null
  console.log(err);
  // 读取的数据使用Buffer列表，其实就是字节码列表
  console.log(data);
  // 通过toString方法，将Buffer列表数据转为字符串数据
  console.log(data.toString());
})




