// 导入全局样式
import './assets/main.scss'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'

// 创建App
const app = createApp(App)
// 使用pinia
app.use(createPinia())
// 使用路由
app.use(router)
// 指定挂载的容器
app.mount('#app')
