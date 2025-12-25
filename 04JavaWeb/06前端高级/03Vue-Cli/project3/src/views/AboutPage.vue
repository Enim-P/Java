<template>
  <div class="about">
    <div class="left">
      <p>
        <!-- 二级路由地址在定义时如果没有加/，需要拼接父级路由地址 -->
        <router-link to="/about/nj">南京</router-link>
      </p>
      <p>
        <!-- 二级路由地址在定义时如加/，直接使用二级路由地址 -->
        <router-link to="/sz">苏州</router-link>
      </p>
      <p>
        <router-link to="/about/cz">常州</router-link>
      </p>
    </div>
    <div class="right">
      <!-- 定义二级路由的出口 -->
      <router-view></router-view>
    </div>
  </div>
</template> 

<script>
export default {
  
}
</script>

<style>
.about{
  border: 1px solid lightpink;
  padding: 10px;
  height: 700px;
  display: flex;
}
.left{
  width: 200px;
  border: 1px solid #ccc;
}
.left p{
  text-align: center;
  padding: 10px 0;
}
.right{
  margin-left: 10px;
  border: 1px solid #ccc;
  flex: 1;
  padding: 10px;
}
</style>