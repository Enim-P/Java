<template>
  <div class="page1">
    <h2>非路由缓存</h2>
    <div>数量：{{count}}</div>
    <div>
      <button @click="count++">数量++</button>
    </div>
  </div>
</template>

<script setup>
import {ref,onMounted,onUnmounted} from 'vue'
let count = ref(0)

onMounted(()=>{
  console.log('Page1组件挂载完成！');
})
onUnmounted(()=>{
  console.log('Page1组件卸载完成！');
})
</script>

<style lang="scss" scoped>
.page1{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>