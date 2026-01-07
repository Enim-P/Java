<template>
  <div class="page1">
    <p>手机：{{phone}} <button @click="phone='三星手机'">更新手机</button></p>
    <p>城市1：{{city1}} <button @click="city1='南京'">更新城市</button></p>
    <p>城市2：{{city2}} <button @click="city2='武汉'">更新城市</button></p>
    <p>城市3：{{city3}} <button @click="city3='杭州'">更新城市</button></p>
    <p>城市4：{{city4}} <button @click="city4='合肥'">更新城市</button></p>
    <hr>
    <div>
      <button @click="upFoods1">修改吃的1</button>
      <button @click="upFoods3">修改吃的3</button>
    </div>
    <!-- 3.使用组件，注意ref属性只能指定一个ref对象 -->
    <Child1 :phone="phone" 
    :city1="city1" :city2="city2" :city3="city3" :city4="city4"
    @sync-phone="phone=$event" ref="child1Ref">
      <h2>南京</h2>
      <div>
        <p>江苏省省会</p>
        <p>全国四大古都之一</p>
      </div>
    </Child1>
  </div>
</template>

<script>
import {ref} from 'vue'
// 1.导入组件
import Child1 from '@/components/Child1.vue';
export default {
  // 2.注册组件
  components:{
    Child1
  },
  setup () {
    let phone = ref('苹果手机')
    let city1 = ref('北京')
    let city2 = ref('上海')
    let city3 = ref('深圳')
    let city4 = ref('广州')
    // 定义一个空的ref对象，用于绑定子组件，绑定后通过该ref对象就可以操作子组件实例
    let child1Ref = ref()
    // 修改吃的1
    let upFoods1 = ()=>{
      // 默认情况下，绑定后的ref对象，可以访问子组件中的所有成员
      // 子组件还可以通过expose方法限定父组件可以访问哪些成员
      child1Ref.value.foods1 = '红茶'
    }
    // 修改吃的3
    let upFoods3 = ()=>{
      child1Ref.value.foods3 = '饼干'
    }

    return {
      phone,city1,city2,city3,city4,
      upFoods1,upFoods3,child1Ref
    }
  }
}
</script>

<style lang="scss" scoped>
.page1{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>