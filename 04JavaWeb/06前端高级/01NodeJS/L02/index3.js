
// ES6推出了一个全新的对象Promise，专门用于处理回调嵌套问题
// 当我们的代码出现了用回调函数嵌套另一个回调函数的情况，就可以使用Promise对象去优化

// 在创建Promise对象的时，要通过它的构造函数，传入一个回调函数
// 传入的回调函数有两个参数：resolve,reject
// resolve用来返回成功的结果，reject用来返回错误的结果
let p = new Promise((resolve,reject)=>{
  resolve("成功")
  //reject("失败")
})

// Promise对象，通过then方法，拿到成功的结果，通过catch方法，拿到失败的结果
p.then(res=>{
  console.log(res);
}).catch(err=>{
  console.log(err);
})

// 如果不处理失败的情况，Promise的回调函数可以只传一个参数
new Promise((resolve)=>{
  resolve("张三")
})
.then(res=>{
  console.log(res);
  // then方法内部返回出现的Promise的执行结果，可以通过下一个then方法接受
  // 这就是Promise链式调用
  return new Promise((resolve)=>{
    resolve("李四")
  })
})
.then(res=>{
  console.log(res);
  return new Promise((resolve)=>{
    resolve("王五")
  })
})
.then(res=>{
  console.log(res);
})
