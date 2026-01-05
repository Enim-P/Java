// 导入createRouter函数，该函数用于创建路由器
// createWebHashHistory函数，用于创建hash模式的路由
// createWebHistory函数，用于创建history模式的路由
import {createRouter,createWebHashHistory,createWebHistory} from 'vue-router'

// 创建路由器
let router = createRouter({
  // 路由模式
  history:createWebHashHistory(),
  // 路由数组
  routes:[
    {
      path:'/',
      component:()=>import('../views/Home.vue')
    },
    {
      path:'/about',
      component:()=>import('../views/About.vue')
    },
    {
      path:'/page1',
      component:()=>import('../views/Page1.vue')
    }
  ]
});

// 导出路由器
export default router