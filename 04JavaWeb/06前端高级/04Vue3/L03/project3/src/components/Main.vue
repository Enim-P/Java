<template>
  <div class="main">
    <table>
      <thead>
        <tr>
          <th>事项名称</th>
          <th>完成状态</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in todoStore.todoList" :key="index">
          <td>{{item.name}}</td>
          <td>{{item.state?'已完成':'未完成'}}</td>
          <td>
            <button v-if="item.state" @click="todoStore.delTodo(index)">删除</button>
            <button v-else @click="todoStore.wcTodo(index)">完成</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import useTodo from '../stores/todo'
let todoStore = useTodo()


</script>

<style lang="scss" scoped>
.main{
  border: 1px solid green;
  padding: 10px;
  margin: 10px 0;
}
</style>