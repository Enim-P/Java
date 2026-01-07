import mitt from "mitt";
// 执行mitt，返回一个事件总线
let $bus = mitt()
// 导出事件总线
export default $bus;