// defineStore函数，用于定义store
import {defineStore} from 'pinia'

// 定义一个store并导出
// defineStore方法的第一个是store名字，第二个参数是一个配置对象
export default defineStore('stu',{
  // state定义状态
  // 注意：这里的state必须是一个函数，由函数返回一个对象
  state(){
    return {
      // 学生数组
      stus:[
        {no:'1001',name:'张三',age:20},
        {no:'1002',name:'李四',age:22},
        {no:'1003',name:'王五',age:24},
        {no:'1004',name:'赵六',age:26}
      ]
    }
  },
  // 定义计算属性
  getters:{
    // 学生的平均年龄
    avgAge(){
      // 计算属性中可以通过this获取当前store
      let total = this.stus.reduce((r,c)=>r+c.age,0)
      return (total/this.stus.length).toFixed(1)
    }
  },
  // 定义方法，注意：同步方法和异步方法都是定义在actions中
  actions:{
    // 添加学生
    addStu(stu){
      if(this.stus.some(s=>s.no==stu.no)){
        return alert('学号不能重复！')
      }
      this.stus.push(stu)
    },
    // 删除学生
    delStu(index){
      // 模拟异步等待500毫秒操作时间
      setTimeout(() => {
        this.stus.splice(index,1)
      }, 500);
    }
  }
})