<template>
  <div class="four">
    <p>
      <button @click="upCount">更新数量</button>
    </p>
    <hr>
    <h3>添加学生</h3>
    <table>
      <tr>
        <td>学号：</td>
        <td><input type="text" v-model="stu.no"></td>
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
          <button @click="addStu">添加</button>
          <button @click="cancel">取消</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 学生信息
      stu:{
        no:'',name:'',sex:'',age:''
      }
    }
  },
  methods:{
    // 添加方法
    addStu(){
      this.$store.commit('addStu',{...this.stu})
    },
    // 取消方法
    cancel(){
      this.stu = {
        no:'',name:'',sex:'',age:''
      }
    },
    // 更新数量
    upCount(){
      // 直接更新状态，看似效果可以实现，而且控制台也没有报错，但是不推荐
      // this.$store.state.count++
      // 通过commit调用mutations中定义的方法
      // 参数1是方法名称，参数2是传递的值
      this.$store.commit('setCount',100)
    }
  }
}
</script>

<style lang="scss" scoped>
.four{
  border: 1px solid blue;
  padding: 10px;
  margin-top: 10px;
}
</style>