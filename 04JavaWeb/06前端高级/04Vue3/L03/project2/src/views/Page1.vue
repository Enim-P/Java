<template>
  <div class="page1">
    <Header @add-todo="addTodo"></Header>
    <Main :todos="todos" @del-todo="delTodo"></Main>
    <Footer :ywc="ywc" :wwc="wwc"></Footer>
  </div>
</template>

<script>
import {reactive,computed} from 'vue'
import Header from '@/components/Header.vue';
import Main from '@/components/Main.vue';
import Footer from '@/components/Footer.vue';
export default {
  components:{
    Header,Main,Footer
  },
  setup () {
    // 待办事项数组
    let todos = reactive([
      {name:'吃火锅',state:true},
      {name:'看电影',state:false},
      {name:'打麻将',state:true},
      {name:'打游戏',state:false}
    ])
    // 删除待办事项的方法
    let delTodo = (index)=>{
      todos.splice(index,1)
    }
    // 添加待办事项的方法
    let addTodo = (name)=>{
      if(todos.some(r=>r.name==name)){
        return alert('该待办事项已经存在！')
      }
      todos.push({name,state:false})
    }
    // 已完成数量
    let ywc = computed(()=>{
      return todos.filter(r=>r.state).length
    })
    // 未完成数量
    let wwc = computed(()=>{
      return todos.filter(r=>!r.state).length
    })
    return {
      todos,delTodo,addTodo,ywc,wwc
    }
  }
}
</script>

<style lang="scss" scoped>
.page1{
  border: 1px solid #ddd;
  padding: 10px;
  width: 500px;
}
</style>