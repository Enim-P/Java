<template>
  <div class="main">
    <table>
      <tbody>
        <tr v-for="(item,index) in todos" :key="index">
          <td>{{item.name}}</td>
          <td>{{item.state?'已完成':'未完成'}}</td>
          <td>
            <button v-if="item.state" @click="delTodo(index)">删除</button>
            <button v-else @click="item.state=true">完成</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props:['todos'],
  setup (props,{emit}) {
    let delTodo = (index)=>{
      if(confirm('确定删除吗？')){
        // 触发删除待办事项的事件
        emit('del-todo',index)
      }
    }
    return {
      delTodo
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