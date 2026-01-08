<template>
  <div class="counter">
    <button @click="upCount(count-1)">-</button>
    <span>{{count}}</span>
    <button @click="upCount(count+1)">+</button>
  </div>
</template>

<script>
export default {
  props:['count'],
  setup (props,{emit}) {
    // 更新数量的方法
    let upCount = (val)=>{
      // 注意：这里的事件名称必须是update:属性名称
      emit('update:count',val)
    }
    return {
      upCount
    }
  }
}
</script>

<style lang="scss" scoped>
.counter{
  display: flex;
  span{
    padding: 0 10px;
  }
}
</style>