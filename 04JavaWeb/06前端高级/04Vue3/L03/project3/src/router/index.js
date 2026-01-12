import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      // 用于定义路由元信息，其实就是一个对象，在对象中存储路由的相关数据
      meta:{
        title:'首页'
      },
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      meta:{
        title:'关于'
      },
      component: () => import('../views/AboutView.vue'),
    },
    {
      // params路由传参，参数需要在路径url中定义出来
      path:'/city/:id',
      // 开启props模式接受params的路由参数
      props:true,
      name:'city',
      meta:{
        title:'城市'
      },
      component:()=>import('../views/City.vue')
    },
    {
      // query路由传参，参数不需要子啊路由url中定义
      path:'/car',
      name:'car',
      meta:{
        title:'汽车'
      },
      component:()=>import('../views/Car.vue')
    },
    {
      path:'/page1',
      name:'page1',
      meta:{
        title:'非路由缓存'
      },
      component:()=>import('../views/Page1.vue')
    },
    {
      path:'/page2',
      name:'page2',
      meta:{
        title:'路由缓存'
      },
      component:()=>import('../views/Page2.vue')
    },
    {
      path:'/page3',
      name:'page3',
      meta:{
        title:'过渡动画'
      },
      component:()=>import('../views/Page3.vue')
    },
    {
      path:'/:pathMatch(.*)*',
      meta:{
        title:'404'
      },
      component:()=>import('../views/NotFound.vue')
    }
  ],
})

// 添加路由守卫
// 前置守卫
router.beforeEach((to,from,next)=>{
  // 这里没有拦截，全部放行
  next()
})
// 后置守卫
router.afterEach((to,from)=>{
  // 路由跳转完成后，更新网页标题
  document.title = to.meta.title
})

export default router
