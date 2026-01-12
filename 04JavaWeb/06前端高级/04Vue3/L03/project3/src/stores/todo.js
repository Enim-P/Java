import {defineStore} from 'pinia'

export default defineStore('todo',{
  // 状态
  state:() => {
    return {
      // 待办事项数组
      todoList:[
        {name:'吃早饭',state:false},
        {name:'敲代码',state:true},
        {name:'打游戏',state:false},
        {name:'睡午觉',state:true},
      ]
    }
  },
  // 计算属性
  getters:{
    // 已完成数量
    ywc(){
      return this.todoList.filter(r=>r.state).length
    },
    // 未完成数量
    wwc(){
      return this.todoList.filter(r=>!r.state).length
    }
  },
  // 方法
  actions:{
    // 完成待办事项
    wcTodo(index){
      this.todoList[index].state = true;
    },
    // 删除待办事项
    delTodo(index){
      this.todoList.splice(index,1)
    },
    // 添加待办事项
    addTodo(todo){
      this.todoList.push(todo)
    }
  }
})