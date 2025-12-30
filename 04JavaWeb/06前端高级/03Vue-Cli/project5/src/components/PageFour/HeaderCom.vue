<template>
  <div class="header">
    <span>待办事项：</span>
    <input type="text" v-model="todoName">
    <button @click="addTodo">添加</button>
  </div>
</template>

<script>
export default {
  data(){
    return {
      todoName:''
    }
  },
  methods:{
    addTodo(){
      if(this.todoName){
        this.$emit('add-todo',this.todoName)
      }else{
        alert('请输入待办事项！')
      }
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