<template>
  <div class="page2">
    <p>姓名：{{name}}</p>
    <p>年龄：{{age}}</p>
    <p>手机：{{phone}}</p>
    <p>汽车：{{car}}</p>
    <p>奶茶：{{food}}</p>
    <div>
      <button @click="setName">修改姓名</button>
      <button @click="upMoney">修改存款</button>
    </div>
    <Child1 ref="child1Ref" :phone="phone" :car="car" :food="food"
    @up-car="car=$event" @up-food="food=$event"></Child1>
    <Child2></Child2>
  </div>
</template>

<script setup>
// setup语法糖，只需要在script标签中添加一个setup属性
// 从此以后，script标签中定义的所有成员，直接可以在模板中访问，默认全部返回
import {ref} from 'vue'
// 导入组件后无需注册，直接可以使用
import Child1 from '@/components/Child1.vue';
import Child2 from '@/components/Child2.vue';
// 定义的变量，无需返回，直接在模板中使用
let name = ref('张三')
let age = ref(20)
let phone = ref('苹果手机')
let car = ref('华为汽车')
let food = ref('霸王茶姬')
let setName = ()=>{
  name.value = '李四'
}
// 第一个空的ref对象，绑定Child1组件
let child1Ref = ref()
let upMoney = ()=>{
  // 子组件默认不会暴露任何成员
  // console.log(child1Ref.value);
  child1Ref.value.money = 30000
}

</script>

<style lang="scss" scoped>
.page2{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>