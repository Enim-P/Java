<template>
  <div class="three">
    <p>数量：{{count}}</p>
    <hr>
    <h3>学生列表</h3>
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
        <tr v-for="(item,index) in stus" :key="index">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.sex}}</td>
          <td>{{item.age}}</td>
          <td>
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
  </div>
</template>

<script>
export default {
  computed:{
    // 通常情况下，全局store里面的状态，定义成计算属性返回
    count(){
      return this.$store.state.count
    },
    stus(){
      // 从state中返回状态
      return this.$store.state.stus
    },
    avgAge(){
      // 从getters中返回计算属性
      return this.$store.getters.avgAge
    }
  },
  methods:{
    // 删除学生
    delStu(index){
      // commit调用的是mutations中定义的同步方法
      // dispatch调用的是actions中定义的异步方法
      this.$store.dispatch('delStu',index)
    }
  }
}
</script>

<style lang="scss" scoped>
.three{
  border: 1px solid red;
  padding: 10px;
  margin-top: 10px;
}
</style>