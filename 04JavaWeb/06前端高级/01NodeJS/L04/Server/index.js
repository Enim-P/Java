//1.导入express
let express = require('express')
//2.创建服务对象
let app = express()
//3.监听一个端口号
app.listen(5200,()=>{
  console.log("服务成功启动，端口号5200");
})
//设置允许接收json格式的数据
app.use(express.json())
//设置允许接收url格式的数据
app.use(express.urlencoded({extended:false}))

// 学生集合
let stus = [
  {id:1,name:'张三',age:20,sex:'男'},
  {id:2,name:'李四',age:22,sex:'女'},
  {id:3,name:'王五',age:24,sex:'女'},
  {id:4,name:'赵六',age:26,sex:'男'}
]

// 定义一个中间件，所有的请求会先走中间，统一处理允许请求跨域
app.use((req,res,next)=>{
  // 允许前端跨域请求
  res.setHeader("Access-Control-Allow-Origin","*")
  // 允许前端发送请求头信息
  res.setHeader("Access-Control-Allow-Headers","*")
  // 默认情况下，express只放开了get和post请求方式
  // 这里放开所有的请求方式
  res.setHeader("Access-Control-Allow-Methods","*")
  // 继续向下执行
  next()   
})

// get请求方法
app.get("/list",(req,res)=>{
  // req：请求对象
  // res：响应对象
  res.send(stus);
})

app.get("/one",(req,res)=>{
  // 获取请求参数
  let id = req.query.id;
  let stu = stus.find(s=>s.id==id);
  res.send(stu)
})

// post请求方法
app.post("/add",(req,res)=>{
  let stu = req.body;
  if(stu){
    if(!stus.some(s=>s.id==stu.id)){
      stus.push(stu)
      res.send({
        code:1,
        message:"添加成功"
      });
    }else{
      res.send({
        code:0,
        message:"添加失败！编号重复！"
      });
    }
  }else{
    res.send({
      code:0,
      message:"添加失败"
    });
  }
})

// put请求方法
app.put("/update",(req,res)=>{
  // 拿到请求体
  let stu = req.body;
  // 查找该学生对象在数组中的位置
  let index = stus.findIndex(s=>s.id==stu.id)
  // 替换数组中的学生对象
  stus.splice(index,1,stu);
  res.send({
    code:1,
    message:"修改成功"
  });
})

// delete请求方法
app.delete("/delete",(req,res)=>{
  // 拿到请求参数
  let id = req.query.id;
  let index = stus.findIndex(s=>s.id==id);
  stus.splice(index,1);
  res.send({
    code:1,
    message:"删除成功"
  });
})