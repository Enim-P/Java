import Vue from 'vue'
import App from './App.vue'

// 导入路由器对象
import router from './router'
// 导入store对象
import store from './store'

Vue.config.productionTip = false
// 在Vue的原型对象上添加成员，所有的Vue实例将会共享这一份成员
// 这里我们添加了一个成员叫$bus，表示事件总线
Vue.prototype.$bus = new Vue()

new Vue({
  render: h => h(App),
  // 注册路由器对象
  router,
  // 注册store对象
  store,
}).$mount('#app')