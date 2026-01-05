<template>
  <div class="home">
    <h2>ref和reactive</h2>
    <table>
      <thead>
        <tr>
          <th>学号</th>
          <th>姓名</th>
          <th>性别</th>
          <th>年龄</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in stus" :key="item.no">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.sex}}</td>
          <td>{{item.age}}</td>
          <td>
            <button @click="editStu(index)">编辑</button>
            <button @click="delStu(index)">删除</button>
          </td>
        </tr>
      </tbody>
    </table>
    <table>
      <tr>
        <td>学号：</td>
        <td><input type="text" v-model="stu.no" :disabled="isEdit"></td>
      </tr>
      <tr>
        <td>姓名：</td>
        <td><input type="text" v-model="stu.name"></td>
      </tr>
      <tr>
        <td>性别：</td>
        <td><input type="text" v-model="stu.sex"></td>
      </tr>
      <tr>
        <td>年龄：</td>
        <td><input type="text" v-model.number="stu.age"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button v-if="isEdit" @click="upStu">修改</button>
          <button v-else @click="addStu">添加</button>
          <button @click="cancel">取消</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
// ref和reactive都是用于定义响应式数据
// ref：既可以定义基本类型，也可以定义引用类型
// reactive：只能定义引用类型
// 注意：ref定义的成员必须要通过.value返回对应的值
import {ref,reactive} from 'vue'
export default {
  setup(){
    // 是否是编辑状态
    let isEdit = ref(false)
    // 学生数组
    let stus = reactive([
      {no:'1001',name:'张三',sex:'女',age:20},
      {no:'1002',name:'李四',sex:'男',age:22},
      {no:'1003',name:'王五',sex:'男',age:24},
      {no:'1004',name:'赵六',sex:'女',age:26}
    ])
    // 学生对象
    let stu = ref({
      no:'',name:'',sex:'',age:''
    })
    // 添加学生
    let addStu = ()=>{
      // 注意：ref对象需要.value返回具体的值
      if(!stu.value.no){
        return alert('请输入学号！')
      }
      if(stus.some(s=>s.no==stu.value.no)){
        return alert('学号不能重复！')
      }
      stus.push({...stu.value})
    }
    // 取消
    let cancel = ()=>{
      stu.value = {
        no:'',name:'',sex:'',age:''
      }
      isEdit.value = false
    }
    // 删除学生
    let delStu = (index)=>{
      if(confirm('确定删除吗？')){
        stus.splice(index,1)
      }
    }
    // 编辑学生
    let editStu = (index)=>{
      isEdit.value = true
      stu.value = {...stus[index]}
    }
    // 修改学生
    let upStu = ()=>{
      let index = stus.findIndex(s=>s.no==stu.value.no)
      stus.splice(index,1,{...stu.value})
    }
    return {
      stus,stu,isEdit,
      addStu,cancel,delStu,editStu,upStu
    }
  }
}
</script>

<style lang="scss" scoped>
.home{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>