// 在生命成员的时候，可以直接使用export关键字导出成员
export function fun1(num1,num2){
  return num1 - num2
}

function fun2(num1,num2){
  return num1 + num2;
}

let car = {
  no:'苏A1001',
  name:'奔驰'
}

export let phone = {
  id:1,
  name:'小米手机'
}

// 加上default关键字，表示默认导出，一个模块中只能有一个默认导出
// 上面的fun1和phone，采用的是分别导出
export default {
  id:1,
  name:'华为电脑'
}


