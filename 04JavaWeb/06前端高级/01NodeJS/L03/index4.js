// 假设index4模块中，需要实现加法运算和转短日期的功能
// 而且当前项目中还没有实现该功能的模块，自己又不想写，该怎么呢？

// 导入第三方模块，直接根据模块的名称导入
let math = require("math");
let moment = require("moment");

let num1 = 1000
let num2 = 2000
console.log(math.add(num1,num2));

let date = new Date();
console.log(moment(date).format("yyyy-MM-DD"));