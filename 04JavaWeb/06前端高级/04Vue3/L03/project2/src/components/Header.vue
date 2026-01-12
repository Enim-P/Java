<template>
  <div class="header">
    <span>待办事项：</span>
    <input type="text" v-model="name">
    <button @click="addTodo">添加</button>
  </div>
</template>

<script>
import {ref} from 'vue'
export default {
  setup (props,{emit}) {
    // 待办事项名称
    let name = ref('')
    // 添加待办事项的方法
    let addTodo = ()=>{
      if(name.value==''){
        return alert('请输入待办事项！')
      }
      emit('add-todo',name.value)
    }
    return {
      name,addTodo
    }
  }
}
</script>

<style lang="scss" scoped>
.header{
  border: 1px solid red;
  padding: 10px;
}
</style>