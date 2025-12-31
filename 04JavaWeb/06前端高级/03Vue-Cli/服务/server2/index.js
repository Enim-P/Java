let express = require('express')
let app = express()
app.listen(4444,()=>{
  console.log('服务器成功开启！端口号是4444');
})

// 汽车数组
let cars = [
  {no:'苏A1001',name:'奔驰',color:'白色',price:100},
  {no:'苏A1002',name:'宝马',color:'黑色',price:200},
  {no:'苏A1003',name:'奥迪',color:'红色',price:300},
  {no:'苏A1004',name:'大众',color:'蓝色',price:400}
]

// 定义一个请求地址：http://localhost:6666/cars/list 返回上面的数组
app.get('/cars/list',(req,res)=>{
  res.send(cars)
})