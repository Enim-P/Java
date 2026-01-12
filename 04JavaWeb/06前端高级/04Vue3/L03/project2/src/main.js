import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// 导入createPinia函数，用于创建全局状态管理对象（它是一个分布式的全局状态管理对象）
import {createPinia} from 'pinia'
// 创建一个pinia全局状态管理对象
let pinia = createPinia()

createApp(App)
.use(router)
.use(pinia)
.mount('#app')
