import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

// 导入路由器对象
import router from './router'

new Vue({
  render: h => h(App),
  // 当前Vue实例，注册指定的路由器对象
  router
}).$mount('#app')
