<template>
  <div class="page3">
    <div>
      <button @click="addStu">添加学生</button>
    </div>
    <table>
      <thead>
        <tr>
          <th>学号</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in stuStore.stus" :key="index">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.age}}</td>
          <td>
            <button @click="stuStore.delStu(index)">删除</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            平均年龄：{{stuStore.avgAge}}
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
// 导入stu全局状态hook函数
import useStu from '../store/stu'
// 执行useStu函数，返回stuStore
let stuStore = useStu()

let addStu = ()=>{
  // 直接调用方法
  stuStore.addStu({
    no:Math.random().toString().slice(-5,-1),
    name:'随机',
    age:20
  })
}

</script>

<style lang="scss" scoped>
.page3{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>