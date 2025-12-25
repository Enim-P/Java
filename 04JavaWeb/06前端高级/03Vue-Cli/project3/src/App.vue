<template>
  <div id="app">
    <div class="nav">
      <router-link to="/">路由传参</router-link>
      <router-link to="/about">关于</router-link>
      <router-link to="/list">列表</router-link>
      <router-link to="/detail">详情</router-link>
      <router-link to="/scoped">Scoped</router-link>
      <router-link to="/scss">Scss</router-link>
    </div>
    <!-- keep-alive内置组件，用于路由缓存，默认情况下，它会缓存打开的所有组件，
    使用include属性绑定一个数组，在数组中指定需要缓存的组件（指定的是组件的name属性名称）
    使用exclude属性绑定一个数组，排除不需要缓存的组件，剩下的都缓存-->
    <keep-alive :include="['ListPage']">
      <!-- 路由出口 -->
      <router-view></router-view>
    </keep-alive>
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
button{
  padding: 2px 10px;
  margin: 10px;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
  margin: 10px;
  padding: 10px;
  border: 1px solid #ccc;
}
.nav{
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
}
.nav a{
  color: black;
  text-decoration: none;
  margin-right: 10px;
}
</style>
