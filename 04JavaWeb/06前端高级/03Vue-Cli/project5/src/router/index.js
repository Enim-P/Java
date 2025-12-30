import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

// 路由数组
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path:'/page1',
    component:()=>import('../views/PageOne.vue')
  },
  {
    path:'/page2',
    component:()=>import('../views/PageTwo.vue')
  },
  {
    path:'/page4',
    component:()=>import('../views/PageFour.vue')
  },
  {
    path:'/page5',
    component:()=>import('../views/PageFive.vue')
  },
  {
    path:'/page6',
    component:()=>import('../views/PageSix.vue')
  }
]

// 路由器
const router = new VueRouter({
  // 路由器的路由数组
  routes
})

// 动态添加路由
// 参数1：父级路由名称，没有父级传空
// 参数2：路由配置对象
router.addRoute('',{
  path:'/page3',
  component:()=>import('../views/PageThree.vue')
})

export default router
