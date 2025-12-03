let fs = require('fs');
// 使用异步函数，继续优化上一个案例

// 先封装一个读取方法
function myReader(file){
  return new Promise((resolve)=>{
    fs.readFile(file,(err,data)=>{
      resolve(data.toString())
    })
  })
}

// 使用该异步函数读取相关信息
async function asyncReader() {
  // 在异步函数中，通过await获取Promise的返回结果，连最后一层回调也不用写了
  let p = await myReader('./file/province.txt')
  console.log(p);
  if(p!="江苏省") return;
  let c = await myReader('./file/city.txt')
  console.log(c);
  if(c!="南京市") return;
  let d = await myReader('./file/district.txt')
  console.log(d);
  if(d!="雨花台区") return;
  let s = await myReader('./file/street.txt')
  console.log(s);
}

asyncReader()   // 调用异步函数
