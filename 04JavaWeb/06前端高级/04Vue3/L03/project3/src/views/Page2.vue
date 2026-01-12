<template>
  <div class="page2">
    <h2>路由缓存</h2>
    <div>数量：{{count}}</div>
    <div>
      <button @click="count++">数量++</button>
    </div>
  </div>
</template>

<script setup>
import {ref,onMounted,onUnmounted,onActivated,onDeactivated} from 'vue'
let count = ref(0)

onMounted(()=>{
  console.log('Page2组件挂载完成！');
})
onUnmounted(()=>{
  console.log('Page2组件卸载完成！');
})
// 组件一旦缓存后，显示和离开时就不会反复触发挂载和卸载函数，
// 如果要在这两个函数中执行相关业务，需要将业务放置在激活和失活函数中
onActivated(()=>{
  console.log('Page2组件激活！');
})
onDeactivated(()=>{
  console.log('Page2组件失活！');
})
</script>

<style lang="scss" scoped>
.page2{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>