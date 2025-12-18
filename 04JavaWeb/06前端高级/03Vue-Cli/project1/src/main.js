// main.js是程序的入口文件

// 从当前环境中导入Vue，可以理解成之前在浏览器的环境中需要通过script标签引入Vue
import Vue from 'vue'   // 这里就是从node_modules中导入Vue
// 导入App根组件，所有的.vue文件都是单文件组件，就是一个文件就是一个组件
import App from './App.vue'

// 不显示生产提示信息（不要在控制台显示太多信息，方便调试）
Vue.config.productionTip = false

// 创建Vue实例并挂载到#app容器中
new Vue({
  // el:'#app',
  // render函数，用于渲染挂载的内容，类似于之前的template选项
  render: h => h(App),  // 渲染APP组件
}).$mount('#app')    // 等同于el:'#app'，都表示挂载到#app容器
