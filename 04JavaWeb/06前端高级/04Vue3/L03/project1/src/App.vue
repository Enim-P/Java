<template>
  <div class="app">
    <div class="nav">
      <router-link to="/">父子组件传值</router-link>
      <router-link to="/page2">依赖注入和事件总线</router-link>
      <router-link to="/page3">Vuex</router-link>
      <router-link to="/page4">自定义v-model</router-link>
      <router-link to="/page5">异步组件</router-link>
      <router-link to="/page6">传送门</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<style scoped>
.app{
  margin: 10px;
  padding: 10px;
  border: 1px solid #ddd;
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
