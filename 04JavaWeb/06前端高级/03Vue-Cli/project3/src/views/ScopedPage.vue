<template>
  <div class="page1">
    <h2>江苏省</h2>
    <OneCom></OneCom>
  </div>
</template>

<script>
import OneCom from '@/components/OneCom.vue';
export default {
  components:{
    OneCom
  }
}
</script>

<style scoped>
/* 在style标签中添加scoped属性，表示定义为作用域样式，
此时当前style标签中定义的样式，只对当前组件生效 */
.page1{
  border: 1px solid black;
  padding: 10px;
}
h2{
  color: black;
}
</style>