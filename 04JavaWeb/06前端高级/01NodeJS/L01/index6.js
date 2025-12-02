// 使用require导入其他模块中的成员，它会将指定模块中导出的成员封装到一个指定的对象中
// let index5 = require('./index5')
// console.log(index5);
// 可以直接解构导入的对象
let {sum,sub} = require('./index5');

// 调用加法方法，返回计算结果
let ret = sum(100,200)
console.log(ret);

let ret2 = sub(1000,500);
console.log(ret2);

