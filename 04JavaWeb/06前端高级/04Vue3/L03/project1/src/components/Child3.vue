<template>
  <div class="child3">
    <h3>朱棣</h3>
    <button @click="upType">修改职称</button>
    <Child5></Child5>
  </div>
</template>

<script>
// 导入事件总线
import $bus from '../eventBus'
import Child5 from './Child5.vue';
export default {
  components:{
    Child5
  },
  setup () {
    let upType = ()=>{
      // 使用事件总线触发指定的事件
      $bus.emit('sync-type','庶民')
    }

    return {
      upType
    }
  }
}
</script>

<style lang="scss" scoped>
.child3{
  border: 1px solid green;
  padding: 10px;
  margin-top: 10px;
}
</style>