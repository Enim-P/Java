// 导入Vue
import Vue from 'vue'
// 导入App根组件
import App from './App.vue'
// 导入路由器
import router from './router'
// 导入Store
import store from './store'

import './mock'

// 直接导入模块，就将模块中的代码执行一遍
// import './mixin'
// 加入事件总线
// import './eventBus'
// 加入自定义指令
// import './directive'

// 之前我们对Vue的扩展是分散的，需要挨个加载
// 现在统一使用插件扩展
import myPlugin from './plugin'
Vue.use(myPlugin)


// 关闭生产提示：浏览器的控制台不需要打印那么多提示信息
Vue.config.productionTip = false

// 创建Vue实例
new Vue({
  // 注册路由器
  router,
  // 注册Store
  store,
  // 渲染APP根组件
  render: h => h(App)
}).$mount('#app')   // 挂载到#app容器中
