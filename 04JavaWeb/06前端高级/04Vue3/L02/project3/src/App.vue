<template>
  <div class="app">
    <div class="nav">
      <RouterLink to="/">ref和reactive</RouterLink>
      <router-link to="/about">计算属性</router-link>
      <router-link to="/page1">侦听器</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>
.app{
  border: 1px solid #ddd;
  padding: 10px;
  margin: 10px;
  .nav{
    border: 1px solid #ddd;
    padding: 10px;
    a{
      margin-right: 10px;
      color: #333;
    }
    margin-bottom: 10px;
  }
}
</style>
