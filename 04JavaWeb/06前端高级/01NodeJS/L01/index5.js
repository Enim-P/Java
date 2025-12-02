
// 加法
function sum(num1,num2){
  return `${num1}+${num2}=${num1+num2}`;
}

// 减法
function sub(num1,num2){
  return `${num1}-${num2}=${num1-num2}`;
}

// 乘法
function cheng(num1,num2){
  return `${num1}*${num2}=${num1*num2}`;
}

// 除非
function chu(num1,num2){
  return `${num1}/${num2}=${num1/num2}`;
}


/* 
  nodejs的模块化开发：
  在实际开发中，我们不可能把所有的业务都写在一个js中，
  而是根据业务的类型对功能进行划分，分模块去开发，这个时候模块与模块之间的相互调用，
  就需要采用导出和导入的方式来实现。
*/

// 在js的模块化开发中，一个js文件就是一个模块，模块的所有成员默认都是私有的，只能在当前模块中使用
// 如果其他模块要用当前模块中的成员，就需要向往暴露成员

// 导出成员有两种方式：
// 1.使用exports导出
// exports.sum = sum;
// exports.sub = sub;

// 2.使用module.exports导出
// module.exports.sum = sum;
// module.exports.sub = sub;
// 它还可以这样导出
module.exports = {
  sum,
  sub
}
