// 导入Vue
import Vue from 'vue'
// 导入VueRouter
import VueRouter from 'vue-router'
// Vue使用VueRouter
Vue.use(VueRouter)

//导入进度条插件
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

//全局进度条的配置
// NProgress.configure({ 
//   showSpinner: true,  //加载微调器设置,默认为true
//   //使用缓动（CSS缓动字符串）和速度（以毫秒为单位）调整动画设置。（默认：ease和200）
//   easing: 'ease',
//   speed: 2000,
//   minimum: 0,  //更改启动时使用的最小百分比
// })


// 导入路由组件
// import HomePage from '../views/HomePage.vue'
// import AboutPage from '../views/AboutPage.vue'
// import CityPage from '@/views/CityPage.vue'
// import JdPage from '@/views/JdPage.vue'
// import NanJing from '@/views/NanJing.vue'
// import SuZhou from '@/views/SuZhou.vue'
// import ChangZhou from '@/views/ChangZhou.vue'

// 创建路由器对象
let router = new VueRouter({
  // 路由模式：1.hash模式，2.history模式
  // 1.hash模式，会在路由地址中添加#号，#号后面是具体的挑战地址，底层采用的是锚链接实现，
  // hash模式的优点是稳定兼容性高，缺点是地址上添加了#号不美观。
  // 2.history模式，路由地址中不会添加#号，底层采用的是H5最新的history API实现的
  // history模式的优点是地址美观，缺点是兼容性略低。
  // history模式的路由上线后，存在刷新后丢失状态的问题，需要在服务器上添加相关配置解决。
  mode:'hash',
  // 路由数组
  routes:[
    {
      // 路由地址
      path:'/',
      // 路由名称
      name:'home',
      // 路由组件
      // component:HomePage,   // 直接指定一个路由组件
      // 直接通过方法，动态导入路由组件，只会在访问该路由时，才会加载该页面组件
      // 这种方式称之为：路由懒加载
      component:()=>import('../views/HomePage.vue'),
      // 路由元信息：其实就是一个对象，可以在该对象中存放一些数据
      meta:{
        title:'首页',
        role:[1,2,3],  // 表示能访问当前路由的用户
      }
    },
    {
      path:'/home',
      // redirect属性设置重定向
      redirect:'/'
    },
    {
      path:'/index',
      redirect:'/'
    },
    {
      path:'/about',
      name:'about',
      // component:AboutPage,
      // 在加载路由的方法中添加 /* webpackChunkName:"自定义组名" */注释，表示路由分组懒加载
      // 访问该组中的任意一个路由都会整体打包
      component:()=>import(/* webpackChunkName:"about" */ '../views/AboutPage.vue'),
      meta:{
        title:'关于',
        role:[1,2]
      },
      // 定义二级路由
      children:[
        {
          // 二级路由的路由地址有两种写法：
          // 1.路由地址不加/
          path:'nj',
          // component:NanJing,
          component:()=>import(/* webpackChunkName:"about" */ '@/views/NanJing.vue'),
          meta:{
            title:'南京',
            role:[1,2]
          },
        },
        {
          // 二级路由的路由地址有两种写法：
          // 1.路由地址加/
          path:'/sz',
          // component:SuZhou,
          component:()=>import(/* webpackChunkName:"about" */ '@/views/SuZhou.vue'),
          meta:{
            title:'苏州',
            role:[1]
          },
        },
        {
          path:'cz',
          // component:ChangZhou,
          component:()=>import(/* webpackChunkName:"about" */ '@/views/ChangZhou.vue'),
          meta:{
            title:'常州',
            role:[1,2]
          },
        }
      ]
    },
    {
      // 路由传参有两种方式：
      // 1.params路由参数，这种方式需要在路由地址中先定义好参数，比如这里的:id就是一个params参数
      path:'/city/:id',
      // component:CityPage,
      component:()=>import('@/views/CityPage.vue'),
      // 开启props接受params参数
      props:true,
      meta:{
        title:'城市',
        role:[1,3]
      }
    },
    {
      // 路由传参有两种方式：
      // 2.query路由参数，这种方式不需要在路由地址中定义好参数
      path:'/jd',
      // component:JdPage,
      component:()=>import('@/views/JdPage.vue'),
      meta:{
        title:'景点',
        role:[1,2]
      }
    },
    {
      path:'/list',
      component:()=>import('../views/ListPage.vue'),
      meta:{
        title:'列表',
        role:[1,2,3]
      }
    },
    {
      path:'/detail',
      component:()=>import('../views/DetailPage.vue'),
      meta:{
        title:'详情',
        role:[1,2,3]
      }
    },
    {
      // *表示未注册的所有路径
      path:'*',
      component:()=>import('../views/NotFound.vue'),
      meta:{
        title:'404'
      }
    },
    {
      path:'/scoped',
      component:()=>import('@/views/ScopedPage.vue'),
      meta:{
        title:'scoped'
      }
    },
    {
      path:'/scss',
      component:()=>import('@/views/ScssPage.vue'),
      meta:{
        title:'Scss'
      }
    }
  ]
})

// 定义路由守卫
// 前置守卫：在路由跳转之前拦截
router.beforeEach((to,from,next)=>{
  //to：到哪去的路由
  //from：从哪来的路由
  //next：执行该方法放行
  NProgress.start();  // 开启进度条
  // 拿到用户的身份
  let userRole = sessionStorage.getItem('role')
  userRole = userRole ? parseInt(userRole) : 0
  if(to.meta.role){
    // 需要验证身份
    if(to.meta.role.includes(userRole)){
      next()
    }else{
      NProgress.done()  // 结束进度条
      alert('访问权限不够！')
    }
  }else{
    // 不需要验证身份
    next()
  }
})
// 后置守卫：在路由跳转之后拦截
router.afterEach((to,from)=>{
  // 完成跳转后，显示对应的标题
  document.title = to.meta.title
  NProgress.done()  // 结束进度条
})

// 导出路由器对象
export default router