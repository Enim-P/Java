// 导入全局样式
import './assets/main.scss'
// 导入createApp函数
import { createApp } from 'vue'
// 导入App根组件
import App from './App.vue'

// 导入路由器
import router from './router'

// 创建App实例渲染App根组件，并挂载到#app容器中
createApp(App)
.use(router)   // 使用路由器
.mount('#app')
