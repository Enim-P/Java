// express库，用于开发Web服务
// 1.导入express（它是一个函数）
let express = require('express')
// 2.执行express函数，返回一个服务对象
let app = express();
// 3.监听一个端口号
app.listen(5200,()=>{
  console.log("服务成功开启！端口号是5200！");
})

let stus = [
  {no:'1001',name:'周杰伦',age:20,sex:'男'},
  {no:'1002',name:'王杰',age:22,sex:'男'},
  {no:'1003',name:'张天宇',age:24,sex:'女'},
  {no:'1004',name:'李梦奇',age:23,sex:'女'}
]

// 4.开发服务方法
app.get("/list",(req,res)=>{
  // 响应一份数据
  res.send(stus)
})
