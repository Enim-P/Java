<template>
  <div class="three">
    <p>数量：{{count}}</p>
  </div>
</template>

<script>
export default {
  computed:{
    // 通常情况下，全局store里面的状态，定义成计算属性返回
    count(){
      return this.$store.state.count
    }
  }
}
</script>

<style lang="scss" scoped>
.three{
  border: 1px solid red;
  padding: 10px;
  margin-top: 10px;
}
</style>