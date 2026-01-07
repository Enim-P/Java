<template>
  <div class="page3">
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
        <tr v-for="(item,index) in stus" :key="index">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.age}}</td>
          <td>
            <button>删除</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">平均年龄：{{avgAge}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
// useStore函数执行后，返回store对象
import {useStore} from 'vuex'
import {computed} from 'vue'
export default {
  setup () {
    // 返回当前项目中的store对象
    let store = useStore()
    // 学生数组
    let stus = computed(()=>{
      return store.state.stus
    })
    // 平均年龄
    let avgAge = computed(()=>{
      return store.getters.avgAge
    })
    return {
      stus,avgAge
    }
  }
}
</script>

<style lang="scss" scoped>
.page3{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>