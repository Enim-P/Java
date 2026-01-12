<template>
  <div class="footer">
    <span>已完成：{{todoStore.ywc}}</span>
    <span>未完成：{{todoStore.wwc}}</span>
  </div>
</template>

<script setup>
import useTodo from '../stores/todo'
let todoStore = useTodo()
</script>

<style lang="scss" scoped>
.footer{
  border: 1px solid blue;
  padding: 10px;
  display: flex;
  justify-content: space-between;
}
</style>