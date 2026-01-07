// createStore函数，用于创建store
import {createStore} from 'vuex'

// 导入子模块
import car from './modules/car'

// 创建一个store
let store = createStore({
  // 状态
  state:{
    stus:[
      {no:'1001',name:'张三',age:20},
      {no:'1002',name:'李四',age:22},
      {no:'1003',name:'王五',age:24},
      {no:'1004',name:'赵六',age:26}
    ]
  },
  // 计算属性
  getters:{
    avgAge(state){
      let total = state.stus.reduce((r,c)=>r+c.age,0)
      return (total / state.stus.length).toFixed(1)
    }
  },
  // 同步方法
  mutations:{

  },
  // 异步方法
  actions:{

  },
  // 子模块
  modules:{
    car
  }
})

// 导出store
export default store
