// 定义一个方法，用于将对象转为URL格式的字符串

function Obj2Url(obj){
  return Object.keys(obj).map(k=>k+'='+obj[k]).join('&')
}

let obj = {
  name:"张三",
  age:20,
  sex:"女"
}

console.log(obj);
let str = Obj2Url(obj)
//name=张三&age=20&sex=女
console.log(str);

