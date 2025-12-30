<template>
  <div class="main">
    <table>
      <tr v-for="(item,index) in todoList" :key="index">
        <td>{{item.name}}</td>
        <td>{{item.state ? '已完成' : '未完成'}}</td>
        <td>
          <button v-if="item.state" @click="delTodo(index)">删除</button>
          <button v-else @click="item.state=true">完成</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  props:['todoList'],
  methods:{
    delTodo(index){
      this.todoList.splice(index,1);
    }
  }
}
</script>

<style lang="scss" scoped>
.main{
  border: 1px solid green;
  padding: 10px;
  margin: 10px 0;
}
</style>