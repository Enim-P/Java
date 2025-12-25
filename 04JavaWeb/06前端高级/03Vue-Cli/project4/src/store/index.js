// 导入Vue
import Vue from "vue";
// 导入Vuex
import Vuex from 'vuex';
// Vue使用Vuex
Vue.use(Vuex)

// 创建Store对象
let store = new Vuex.Store({
  // 用于定义全局状态
  state:{
    count:5
  },
  // 定义更新状态的方法
  mutations:{
    // 更新状态的方法，有两个参数：状态对象，更新的值
    setCount(state,val){
      state.count = val
    }
  }
})

// 导出store对象
export default store;