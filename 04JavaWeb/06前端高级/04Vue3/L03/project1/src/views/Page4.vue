<template>
  <div class="page4">
    <div>衣服数量：{{count1}}</div>
    <Counter :count="count1" @update:count="count1=$event"></Counter>
    <!-- 当前回传的事件命名是update:属性名，就可以使用v-model:属性简化，
     在vue3中，v-model和.sync修饰符进行了合并，所以vue3中取消了.sync修饰符 -->
    <Counter v-model:count="count1"></Counter>
    <hr style="margin: 10px 0;">
    <div>苹果：{{pgCount}}</div>
    <div>西瓜：{{xgCount}}</div>
    <div>葡萄：{{ptCount}}</div>
    <!-- vue3中可以给一个组件设置多个v-model传值 -->
    <FoodsCounter v-model:pg-count="pgCount" 
    v-model:xg-count="xgCount" v-model:pt-count="ptCount"></FoodsCounter>
  </div>
</template>

<script>
import {ref} from 'vue'
import Counter from '@/components/Counter.vue';
import FoodsCounter from '@/components/FoodsCounter.vue';
export default {
  components:{
    Counter,FoodsCounter
  },
  setup () {
    let count1 = ref(5)
    let pgCount = ref(2)
    let xgCount = ref(3)
    let ptCount = ref(4)
    return {
      count1,pgCount,xgCount,ptCount
    }
  }
}
</script>

<style lang="scss" scoped>
.page4{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>