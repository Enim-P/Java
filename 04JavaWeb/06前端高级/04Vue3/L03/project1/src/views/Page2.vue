<template>
  <div class="page2">
    <h2>朱元璋</h2>
    <p>宝物：{{yx}}</p>
    <Child2></Child2>
    <Child3></Child3>
  </div>
</template>

<script>
// provide函数：用于定义依赖数据
import {ref,provide} from 'vue'
import Child2 from '@/components/Child2.vue';
import Child3 from '@/components/Child3.vue';
export default {
  components:{
    Child2,Child3
  },
  setup () {
    let yx = ref('传国玉玺')
    // provide中定义依赖数据，后代组件可以注入这些依赖数据
    provide('yx',yx)
    return {
      yx
    }
  }
}
</script>

<style lang="scss" scoped>
.page2{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>