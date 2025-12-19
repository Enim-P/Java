function fun1(num1,num2){
  return num1 - num2
}

function fun2(num1,num2){
  return num1 + num2;
}

// 导出当前模块中的成员
module.exports = {
  fun1,fun2
}