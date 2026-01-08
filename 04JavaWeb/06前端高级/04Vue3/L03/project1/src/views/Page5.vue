<template>
  <div class="page5">
    <h2>我是页面</h2>
    <One></One>
    <!-- 使用suspense处理异步组件的加载过程 -->
    <suspense>
      <!-- 默认插槽展示异步组件的结果 -->
      <template #default>
        <Two></Two>
      </template>
      <!-- fallback插槽中定义加载过程中显示的信息 -->
      <template #fallback>
        <div>正在加载...</div>
      </template>
    </suspense>
    <Three></Three>
  </div>
</template>

<script>
// 导入defineAsyncComponent函数，用于导入异步组件
import {defineAsyncComponent} from 'vue'
// 默认情况下，必需等到所有组件都加载完成后，整个页面才会显示
// 使用异步组件导入，谁先加载好，谁先展示，不用等其他组件
let One = defineAsyncComponent(()=>import('@/components/One.vue'));
let Two = defineAsyncComponent(()=>import('@/components/Two.vue')) ;
let Three = defineAsyncComponent(()=>import('@/components/Three.vue')) ;
export default {
  components:{
    One,Two,Three
  },
  setup () {
    return {}
  }
}
</script>

<style lang="scss" scoped>
.page5{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>