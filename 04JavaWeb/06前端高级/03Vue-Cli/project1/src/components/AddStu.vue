<template>
  <div class="add-stu">
    <h2>{{isEdit?'修改':'添加'}}学生</h2>
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
        <td>年龄：</td>
        <!-- 数字类型需要使用.number修饰符转换 -->
        <td><input type="text" v-model.number="stu.age"></td>
      </tr>
      <tr>
        <td>性别：</td>
        <td><input type="text" v-model="stu.sex"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button v-if="isEdit">修改</button>
          <button v-else @click="add">添加</button>
          <button @click="cancel">取消</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
  export default {
    props:['isEdit','data'],
    data() {
      return {
        // 学生对象
        stu:{
          no:'',name:'',age:0,sex:''
        }
      }
    },
    mounted() {
      if(this.isEdit){
        this.stu = this.data;
      }
    },
    methods: {
      // 添加
      add(){
        if(!this.stu.no){
          return alert('学号不能为空！')
        }
        // 触发自定义事件，回传学生对象
        this.$emit('add-stu',{...this.stu})
      },
      // 取消
      cancel(){
        this.stu = {no:'',name:'',age:0,sex:''}
      }
    },
  }
</script>

<style>
  .add-stu{
    border: 1px solid lightblue;
    padding: 10px;
    margin: 10px 0;
  }
</style>