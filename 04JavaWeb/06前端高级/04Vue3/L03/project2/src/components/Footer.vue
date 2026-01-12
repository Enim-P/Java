<template>
  <div class="footer">
    <span>已完成：{{ywc}}</span>
    <span>未完成：{{wwc}}</span>
  </div>
</template>

<script>
export default {
  props:['ywc','wwc'],
  setup () {
    
    return {}
  }
}
</script>

<style lang="scss" scoped>
.footer{
  border: 1px solid blue;
  padding: 10px;
  display: flex;
  justify-content: space-between
}
</style>