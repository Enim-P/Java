function fun1(num1,num2){
  return num1 - num2
}

function fun2(num1,num2){
  return num1 + num2;
}

let car = {
  no:'苏A1001',
  name:'奔驰'
}

let phone = {
  id:1,
  name:'小米手机'
}

let pc = {
  id:1,
  name:'华为电脑'
}

// pc采用默认导出
export default pc 

// fun1和phono采用分别导出
export {
  fun1,phone
}