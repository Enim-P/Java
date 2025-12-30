import axios from 'axios';

// 导入组件
import MyButton from '@/components/MyButton.vue';

// 插件就是一个方法
// 方法提供两个参数：
// 参数1：Vue
// 参数2：配置选项（如果没有配置，通常可以省略）
export default function(Vue,options){
  // 全局混入
  Vue.mixin({
    data() {
      return {
        hxData:{}
      }
    },
    methods:{
      getHxData(){
        axios.get('/data/data.json').then(({data})=>{
          this.hxData = data;
        })
      },
      upHxData(val){
        this.hxData = val
      }
    },
  })
  // 通过原型对象扩展
  // 通过Vue的原型对象注册中央事件总线
  Vue.prototype.$bus = new Vue()
  // 通过Vue的原型对象注册axios
  Vue.prototype.$axios = axios
  // 自定义指令
  // 参数1：指令的名称
  // 参数2：指定的操作方法
  Vue.directive('red', function(el,bind){
    // 对DOM结构的操作在这个方法中完成
    // 该方法有两个参数：
    // 参数1：当前指令所在的DOM元素
    // 参数2：是一个参数对象，里面绑定了一份数据
    el.style.color = 'red'
  })

  Vue.directive('blue', function(el,bind){
    el.style.color = 'blue'
  })

  Vue.directive('color', function(el,bind){
    el.style.color = bind.value 
  })

  Vue.directive('myif', function(el,bind){
    if(bind.value){
      el.style.display = 'block'
    }else{
      el.style.display = 'none'
    }
  })
  // 注册全局组件
  Vue.component('MyButton', MyButton)
}