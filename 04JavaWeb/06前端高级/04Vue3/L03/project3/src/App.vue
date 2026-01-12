<template>
  <div class="app">
    <div class="nav">
      <router-link to="/">首页</router-link>
      <router-link to="/about">关于</router-link>
      <router-link to="/page1">非路由缓存</router-link>
      <router-link to="/page2">路由缓存</router-link>
      <router-link to="/page3">过渡动画</router-link>
    </div>
    <!-- 对路由页面进行缓存 -->
    <!-- v-slot="{ Component }"：获取路由打开的组件，然后再动态渲染对应的组件 -->
    <router-view v-slot="{ Component }">
      <keep-alive :include="['Page2']">
        <component :is="Component" />
      </keep-alive>
    </router-view>
   
  </div>
</template>

<style lang="scss" scoped>
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