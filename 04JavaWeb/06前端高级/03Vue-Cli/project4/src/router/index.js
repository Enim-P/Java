import Vue from "vue";
import VueRouter from "vue-router";
Vue.use(VueRouter);

// 路由数组
let routes = [
  {
    path:'/page1',
    component:()=>import('@/views/PageOne.vue')
  },
  {
     path:'/page2',
    component:()=>import('@/views/PageTwo.vue')
  },
  {
    path:'/page3',
    component:()=>import('@/views/PageThree.vue')
  },
  {
    path:'/page4',
    component:()=>import('@/views/PageFour.vue')
  }
]

// 路由器对象
let router = new VueRouter({
  routes
});

// 导出路由器对象
export default router;