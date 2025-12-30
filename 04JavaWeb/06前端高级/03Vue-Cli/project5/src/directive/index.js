import Vue from 'vue'

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