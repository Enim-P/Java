<template>
  <div class="footer">
    <div class="num">
      <span>已完成：{{ywc}}</span>
      <span>未完成：{{wwc}}</span>
    </div>
  </div>
</template>

<script>
export default {
  props:['todoList'],
  computed:{
    // 已完成数量
    ywc(){
      return this.todoList.filter(r=>r.state).length
    },
    // 未完成数量
    wwc(){
      return this.todoList.filter(r=>!r.state).length
    }
  }
}
</script>

<style lang="scss" scoped>
.footer{
  border: 1px solid purple;
  padding: 10px;
  .num{
    display: flex;
    justify-content: space-between;
    width: 200px;
  }
}
</style>