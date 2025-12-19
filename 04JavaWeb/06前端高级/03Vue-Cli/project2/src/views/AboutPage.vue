<template>
  <div class="about">
    <h2>关于</h2>
    <div>
      <button @click="goHome">回到首页</button>
    </div>
  </div>
</template>

<script>
  export default {
    methods:{
      goHome(){
        // 编程式路由跳转
        // push方法采用压栈式方式跳转路由，上一次的路由地址依赖在路由栈中
        this.$router.push('/')
        // replace方法采用替换栈顶方式跳转路由，上一次路径地址会被当前路由地址替换
        // this.$router.replace('/')
      }
    }
  }
</script>

<style>
  .about{
    border: 1px solid lightgreen;
    padding: 10px;
  }
</style>