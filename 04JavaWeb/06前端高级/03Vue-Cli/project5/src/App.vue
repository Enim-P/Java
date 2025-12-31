<template>
  <div id="app">
    <nav>
      <router-link to="/">Mixin(混入)</router-link> |
      <router-link to="/about">EventBus(事件总线)</router-link> | 
      <router-link to="/page1">自定义指令</router-link> |
      <router-link to="/page2">全局组件</router-link> |
      <router-link to="/page3">动态路由</router-link> |
      <router-link to="/page4">待办事项</router-link> |
      <router-link to="/page5">Key和动画</router-link> |
      <router-link to="/page6">nextTick</router-link> |
      <router-link to="/page7">代理服务器</router-link> |
      <router-link to="/page8">MockJS</router-link> |
    </nav>
    <router-view/>
  </div>
</template>

<style lang="scss">
*{
  margin: 0;
  padding: 0;
  list-style: none;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  padding: 10px;
  margin: 10px;
  border: 1px solid #ddd;
}
button{
  padding: 2px 8px;
  margin: 2px;
}
nav {
  padding: 10px;
  border: 1px solid #ddd;
  margin-bottom: 10px;
  a {
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
table{
  border-collapse: collapse;
  td,th{
    border: 1px solid #ddd;
    padding: 2px 10px;
  }
}
</style>
