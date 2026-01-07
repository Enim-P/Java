// createRouter：用于创建路由器
// createWebHashHistory：用于创建hash路由
import {createRouter,createWebHashHistory} from 'vue-router'

// 创建路由器
let router = createRouter({
  // hash路由
  history:createWebHashHistory(),
  // 路由数组
  routes:[
    {
      path:'/',
      component:()=>import('../views/Page1.vue')
    },
    {
      path:'/page2',
      component:()=>import('../views/Page2.vue')
    },
    {
      path:'/page3',
      component:()=>import('../views/Page3.vue')
    }
  ]
})

// 导出路由器
export default router