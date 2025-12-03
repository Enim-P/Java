// 普通函数
function fun1(){
  console.log('普通函数');
  // 在普通函数中，处理Promise结果，通过.then返回
  new Promise((resolve)=>{
    resolve("结果：学生数量50人")
  }).then(res=>{
    console.log(res);
  })
}
fun1()

// 异步函数，在定义时，多了一个async关键字
async function fun2(){
  console.log('异步函数');
  // 在异步函数中，处理Promise结果，可以使用await关键字，直接定义变量接收
  let res = await new Promise((resolve)=>{
    resolve("结果：学生平均成绩86分")
  })
  console.log(res);
}
fun2()