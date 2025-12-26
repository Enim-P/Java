// 导入Vue
import Vue from "vue";
// 导入Vuex
import Vuex from 'vuex';
// Vue使用Vuex
Vue.use(Vuex)

// 导入子模块
import car from "./modules/car";

// 创建Store对象
let store = new Vuex.Store({
  // 用于定义全局状态
  state:{
    // 数量
    count:5,
    // 学生数组
    stus:[
      {no:'1001',name:'张三',sex:'男',age:20},
      {no:'1002',name:'李四',sex:'女',age:22},
      {no:'1003',name:'王五',sex:'女',age:24},
      {no:'1004',name:'赵六',sex:'男',age:26},
    ],
    a:100,
    b:200,
    c:300
  },
  // 定义计算属性
  getters:{
    // 平均年龄
    avgAge(state){
      let total = state.stus.reduce((r,c)=>r+c.age,0)
      return (total / state.stus.length).toFixed(1)
    }
  },
  // 定义更新状态的方法
  mutations:{
    // 更新状态的方法，有两个参数：状态对象，更新的值
    setCount(state,val){
      state.count = val
    },
    // 添加学生
    addStu(state,val){
      state.stus.push(val)
    },
    // 删除学生
    delStu(state,index){
      state.stus.splice(index,1)
    }
  },
  // mutations用于定义同步方法，actions用于定义异步方法
  // 比如在方法中需要发送ajax请求，就要使用actions定义的方法
  // 根据官方要求，无论是否有异步操作，对状态的更新，都要先走actions，再由actions调用mutations
  actions:{
    // 比如：删除学生之前要先删除学生其他的相关信息
    async delStu(store,index){
      // 这里我们使用定时器模拟异步等待的时间
      setTimeout(() => {
        // 注意actions处理完异步操作之后，还是要调用mutations中的方法做同步更新
        store.commit('delStu',index)
      }, 500);
    },
  },
  // 注册子模块
  modules:{
    car
  }
})

// 导出store对象
export default store;