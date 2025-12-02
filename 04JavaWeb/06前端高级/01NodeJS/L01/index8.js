// 几个全局变量：
// __filename：返回当前文件的绝对路径
console.log(__filename);
// __dirname：返回当前文件所在目录的绝对路径
console.log(__dirname);
// global：全局对象，相当于浏览器环境中的window对象
console.log(global);
// nodejs环境中是没有window对象的
// console.log(window);