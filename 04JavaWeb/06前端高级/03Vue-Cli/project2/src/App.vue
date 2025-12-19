<template>
  <div id="app">
    <div class="nav">
      <!-- router-link内置组件，用于跳转路由 -->
      <router-link to="/">首页</router-link>
      <!-- 路由链接组件，默认采用的是push方式跳转，
       如果要采用replace跳转，只需要添加一个replace属性 -->
      <router-link to="/list" replace>列表</router-link>
      <router-link to="/about">关于</router-link>
    </div>
    <!-- router-view内置组件，用于展示路由页面 -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  
}
</script>

<style>
  *{
    margin: 0;
    padding: 0;
    list-style: none;
  }
  .nav{
    border: 1px solid #ccc;
    padding: 10px;
    display: flex;
    margin-bottom: 10px;
  }
  .nav a{
    margin-right: 10px;
    text-decoration: none;
    color: black;
  }
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    color: #2c3e50;
    border: 1px solid #ccc;
    padding: 10px;
    margin: 10px;
  }
</style>
