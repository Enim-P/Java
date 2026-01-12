<template>
  <div class="child2">
    <p>姓名：{{name}}</p>
    <p>年龄：{{age}}</p>
    <div>
      <button @click="upName">修改姓名</button>
      <button @click="upAge">修改年龄</button>
    </div>
  </div>
</template>

<script setup>
// Vue2推出的选项式API语法和Vue3推出的组合式API语法是可以同时共存的，但是不推荐
import {ref} from 'vue'
// export default {
//   // 选项式API
//   data() {
//     return {
//       name:'张三'
//     }
//   },
//   methods:{
//     upName(){
//       this.name = '李四'
//     }
//   },
//   // 组合式API
//   setup () {
//     let age = ref(20)
//     let upAge = ()=>{
//       age.value = 30
//     }
//     return {
//       age,upAge
//     }
//   }
// }
// defineOptions用于定义选项式API
defineOptions({
  // 最大的用途就是给组件重新定义一个名字，
  // 因为组件一旦采用setup语法糖定义，名字默认就是文件名
  name:'MyChild2',
   data() {
    return {
      name:'张三'
    }
  },
  methods: {
    upName(){
      this.name = '李四'
    }
  },
})
let age = ref(20)
let upAge = ()=>{
  age.value = 30
}
</script>

<style lang="scss" scoped>
.child2{
  border: 1px solid green;
  padding: 10px;
  margin: 10px;
}
</style>