let {sum} = require('./index1')
let {toMiniDate} = require('./index2')

let num1 = 1000
let num2 = 2000
let ret = sum(num1,num2)
console.log(ret);

let date = new Date();
let ret2 = toMiniDate(date)
console.log(ret2);

// index3模块中需要实现一个加法运算 和 转短日期的功能
// 正好当前项目的其他模块中已经实现了这两个功能
// 所以我们只需要导入其他模块中的方法就可以解决当前模块的需要