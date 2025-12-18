<template>
  <div id="app">
    <h2>学生列表</h2>
    <button @click="show">显示添加面板</button>
    <table>
      <thead>
        <tr>
          <th>学号</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>性别</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in stus" :key="index">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.age}}</td>
          <td>{{item.sex}}</td>
          <td>
            <button @click="editStu(item)">编辑</button>
            <button @click="delStu(index)">删除</button>
          </td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="5">平均年龄：{{avgAge}}</td>
        </tr>
      </tfoot>
    </table>
    <!-- 3.使用组件 -->
    <AddStu v-if="isShow" @add-stu="addStu" 
      :isEdit="isEdit" :data="data"></AddStu>
  </div>
</template>

<script>
// 所有的.vue文件都是单文件组件，一个文件就是一个组件
// 在单文件组件中，将组件的三要素进行了拆分
// template：定义组件的结构
// style：定义组件的样式
// script：定义组件的逻辑

// 1.导入AddStu组件
import AddStu from './components/AddStu.vue'
export default {
  // 组件的名字，可以省略
  name: 'App',
  // 2.注册组件
  components:{
    AddStu
  },
  // data选项必须是一个方法，由方法返回一个对象
  data() {
    return {
      // 学生数组
      stus:[
        {no:'1001',name:'张三',age:20,sex:'男'},
        {no:'1002',name:'李四',age:21,sex:'女'},
        {no:'1003',name:'王五',age:22,sex:'女'},
        {no:'1004',name:'赵六',age:23,sex:'男'}
      ],
      // 是否显示添加学生组件
      isShow:false,
      // 是否是编辑状态
      isEdit:false,
      // 传给子组件的数据
      data:{}
    }
  },
  computed:{
    // 平均年龄
    avgAge(){
      let total = this.stus.reduce((p,c)=>p+c.age,0);
      return (total / this.stus.length).toFixed(1)
    }
  },
  methods: {
    // 显示面板的方法
    show(){
      if(!this.isShow){
        this.isShow = true;
      }else{
        // 关闭面板
        this.isShow = false;
        // 取消编辑状态
        this.isEdit = false;
        // 清空编辑数据
        this.data = {}
      }
    },
    // 添加学生
    addStu(e){
      if(this.stus.some(s=>s.no==e.no)){
        return alert('学号不能重复！')
      }
      this.stus.push(e)
      alert('添加成功！')
    },
    // 删除学生
    delStu(index){
      if(confirm('确定删除吗？')){
        this.stus.splice(index,1)
        alert('删除成功！')
      }
    },
    // 编辑学生
    editStu(item){
      if(!this.isShow){
        this.data = {...item}
        this.isEdit = true;
        this.isShow = true;
      }else{
        // 关闭面板
        this.isShow = false;
        // 取消编辑状态
        this.isEdit = false;
        // 清空编辑数据
        this.data = {}
      }
      
    }
  },
}
</script>

<style>
  *{
    margin: 0;
    padding: 0;
    list-style: none;
  }
  table{
    border-collapse: collapse;
    margin: 10px 0;
  }
  td,th{
    border: 1px solid #ccc;
    padding: 2px 20px;
  }
  button{
    border: 1px solid #ccc;
    padding: 2px 10px;
    margin-right: 10px;
  }
  #app {
    border: 1px solid #ccc;
    padding: 10px;
    margin: 10px;
  }
</style>
