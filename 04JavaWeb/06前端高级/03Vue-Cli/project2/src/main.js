// 脚手架环境支持commonJS规范的导入和导出语法
// let obj = require('./commonjs/index1')
// console.log(obj);
// console.log(obj.fun1(100,20));
// console.log(obj.fun2(100,20));

// ES6的导入语法
// 导入默认导出的成员 和 分别导出的成员
// import pc,{fun1,phone} from './es6module/index1'
// console.log(fun1);
// console.log(phone);
// console.log(pc);

// 默认导出的成员，在导入时可以随意定义名称
// 分别导出的成员，在导入时可以重命名
// import pc2,{fun1 as f1,phone as p1} from './es6module/index2'
// console.log(pc2);
// console.log(f1);
// console.log(p1);

// 导入Vue
import Vue from 'vue'
// 导入VueRouter
import VueRouter from 'vue-router'
// 导入App组件
import App from './App.vue'
// 导入element-ui组件库
import ElementUI from 'element-ui';
// 导入element-ui组件库的样式
import 'element-ui/lib/theme-chalk/index.css';
// Vue使用element-ui组件库
Vue.use(ElementUI);

// Vue使用VueRouter
Vue.use(VueRouter)

// 导入路由页面组件
import HomePage from './views/HomePage.vue'
import ListPage from './views/ListPage.vue'
import AboutPage from './views/AboutPage.vue'

// 创建一个路由器
let router = new VueRouter({
  // 路由数组
  routes:[
    // 每个路由配置一个对象
    {
      // 路由路径
      path:'/',
      // 路由组件
      component:HomePage
    },
    {
      path:'/list',
      component:ListPage
    },
    {
      path:'/about',
      component:AboutPage
    }
  ]
});

Vue.config.productionTip = false

// 创建Vue实例
new Vue({
  // 渲染APP组件
  render: h => h(App),
  // 给当前Vue实例指定一个路由器
  router
}).$mount('#app')  // 挂载到#app容器中
