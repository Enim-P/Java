<template>
  <div id="app">
    <div class="nav">
      <router-link to="/page1" active-class="active">组件传值</router-link>
      <router-link to="/page2" active-class="active">Vuex</router-link>
      <router-link to="/page3" active-class="active">Vuex-子模块</router-link>
      <router-link to="/page4" active-class="active">Vuex-映射函数</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
}
</script>

<style lang="scss">
*{
  margin: 0;
  padding: 0;
  list-style: none;
  text-decoration: none;
  outline: none;
}
.nav{
  border: 1px solid #ddd;
  padding: 10px;
  margin-bottom: 10px;
}
.nav a{
  margin-right: 10px;
}
.nav a.active{
  color: darkgreen;
  font-weight: 600;
}
table{
  border-collapse: collapse;
  td,th{
    border: 1px solid #ddd;
    padding: 2px 10px;
  }
}
button{
  padding: 2px 10px;
  margin: 0 2px;
}
a{
  color: #2c3e50;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
  border: 1px solid #ddd;
  padding: 10px;
  margin: 10px;
}
</style>
