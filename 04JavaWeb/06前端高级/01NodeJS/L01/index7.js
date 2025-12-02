// 在nodejs的导出语句中，最终都是将module.exports对象导出去，
// exports对象指向了module.exports对象
exports.a = "张三";
module.exports.b = "李四";
console.log(module.exports === exports);
console.log(module.exports);
console.log(exports);
console.log("===================");
// 如果采用下面的方式，对整个module.exports重新赋值，那么exports就不在指向module.exports了
module.exports = {
  c:"小明",
  d:"小芳"
}
console.log(module.exports === exports);
console.log(module.exports);
console.log(exports);


