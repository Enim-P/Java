<template>
  <div class="app">
    <div class="nav">
      <router-link to="/">待办事项练习</router-link>
      <router-link to="/page2">setup语法糖</router-link>
      <router-link to="/page3">pinia全局状态管理</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<style scoped>
.app{
  border: 1px solid #ddd;
  padding: 10px;
  margin: 10px;
  .nav{
    border: 1px solid #ddd;
    padding: 10px;
    margin-bottom: 10px;
    a{
      margin-right: 10px;
    }
  }
}
</style>
