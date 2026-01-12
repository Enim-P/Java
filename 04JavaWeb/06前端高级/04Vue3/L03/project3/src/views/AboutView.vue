<template>
  <div class="about">
    <h2>直辖市</h2>
    <ul>
      <li v-for="(item,index) in citys" :key="index">
        <button @click="gotoCity(item.id)">{{item.name}}</button>
      </li>
    </ul>
    <h2>车辆信息</h2>
    <ul>
      <li v-for="(item,index) in cars" :key="index">
        <button @click="gotoCar(item.id)">{{item.name}}</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import {reactive} from 'vue'
import {useRouter} from 'vue-router'
// useRouter方法，返回当前项目中的路由器对象
let router = useRouter()
let citys = reactive([
  {id:1,name:'北京'},
  {id:2,name:'天津'},
  {id:3,name:'上海'},
  {id:4,name:'重庆'}
])
let cars = reactive([
  {id:1,name:'保时捷'},
  {id:2,name:'玛莎拉蒂'},
  {id:3,name:'法拉利'},
  {id:4,name:'迈凯伦'}
])
// 跳转方法
let gotoCity = (id)=>{
  // 使用路由器的push方法，跳转路由
  // router.push('/city/'+id)
  // 根据路由的名称跳转
  router.push({
    name:'city',
    params:{
      id
    }
  })
}
let gotoCar = (id)=>{
  // router.push('/car?id='+id)
  // 路由路由名称跳转
  router.push({
    name:'car',
    query:{
      id
    }
  })
}
</script>

<style lang="scss" scoped>
.about{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>