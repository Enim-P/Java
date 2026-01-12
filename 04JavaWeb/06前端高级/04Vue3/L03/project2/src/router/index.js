import {createRouter,createWebHistory} from 'vue-router'

//  创建路由器
let router = createRouter({
  // 设置为history路由
  history:createWebHistory(),
  // 路由数组
  routes:[
    {
      path:'/',
      name:'page1',
      component:()=>import('../views/Page1.vue')
    },
    {
      path:'/page2',
      name:'page2',
      component:()=>import('../views/Page2.vue')
    },
    {
      path:'/page3',
      name:'page3',
      component:()=>import('../views/Page3.vue')
    }
  ]
})

// 导出路由器
export default router