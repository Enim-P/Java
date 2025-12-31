let express = require('express')
let app = express()
app.listen(5555,()=>{
  console.log('服务器成功开启！端口号是5555');
})

// 学生数组
let stus = [
  {no:'1001',name:'张杰',sex:'男',age:20},
  {no:'1002',name:'王明',sex:'男',age:21},
  {no:'1003',name:'李梅',sex:'女',age:22},
  {no:'1004',name:'谢芳',sex:'女',age:23}
]

// 定义一个请求地址：http://localhost:5555/stus/list 返回上面的数组

app.get('/stus/list',(req,res)=>{
  // 允许跨域请求
  // res.setHeader('Access-Control-Allow-Origin','*')
  res.send(stus);
})