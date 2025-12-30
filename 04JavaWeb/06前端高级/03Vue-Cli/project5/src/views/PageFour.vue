<template>
  <div class="four">
    <HeaderCom @add-todo="addTodo" ref="header"></HeaderCom>
    <MainCom :todoList="todoList"></MainCom>
    <FooterCom :todoList="todoList"></FooterCom>
  </div>
</template>

<script>
import HeaderCom from '@/components/PageFour/HeaderCom.vue';
import MainCom from '@/components/PageFour/MainCom.vue';
import FooterCom from '@/components/PageFour/FooterCom.vue';
export default {
  components:{
    HeaderCom,MainCom,FooterCom
  },
  data(){
    return {
      // 待办事项数组
      todoList:[
        {name:'看电影',state:true},
        {name:'吃火锅',state:false},
        {name:'打篮球',state:false},
        {name:'跑步',state:true}
      ]
    }
  },
  methods:{
    addTodo(e){
      if(this.todoList.some(r=>r.name==e && r.state==true)){
        alert('已存在该待办事项！并且已完成！')
      }else if(this.todoList.some(r=>r.name==e && r.state==false)){
        alert('已存在该待办事项！并且未完成！')
      }else{
        this.todoList.push({
          name:e,
          state:false
        })
        alert('添加完成！')
        // 拿到子组件实例
        this.$refs.header.todoName = ""
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.four{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>