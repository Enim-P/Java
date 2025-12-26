<template>
  <div class="four">
    <h3>学生列表</h3>
    <p>a：{{a}}</p>
    <p>b：{{b}}</p>
    <p>c：{{c}}</p>
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
          <button @click="addStu({...stu})">添加</button>
          <button @click="cancel1">取消</button>
        </td>
      </tr>
    </table>
    <hr style="margin: 10px 0;">
    <h3>汽车列表</h3>
    <table>
      <thead>
        <tr>
          <th>车牌</th>
          <th>车名</th>
          <th>颜色</th>
          <th>价格</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in cars" :key="index">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.color}}</td>
          <td>{{item.price}}</td>
          <td>
            <button @click="delCar(index)">删除</button>
          </td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="5">
            平均价格：{{avgPrice}}
          </td>
        </tr>
      </tfoot>
    </table>
    <hr>
    <h3>添加汽车</h3>
    <table>
      <tr>
        <td>车牌：</td>
        <td><input type="text" v-model="car.no"></td>
      </tr>
      <tr>
        <td>车名：</td>
        <td><input type="text" v-model="car.name"></td>
      </tr>
      <tr>
        <td>颜色：</td>
        <td><input type="text" v-model="car.color"></td>
      </tr>
      <tr>
        <td>价格：</td>
        <td><input type="text" v-model.number="car.price"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button @click="addCar({...car})">添加</button>
          <button @click="cancel2">取消</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
// 自定义映射函数
// function mapper(arr){
//   let obj = {}
//   arr.forEach(r=>{
//     obj[r] = function(){
//       return this.$store.state[r]
//     }
//   })
//   return obj;
// }

// 导入vuex导入映射函数，使用映射函数可以帮我们快速生成固定的代码块
// 通常情况下我们只会去映射state和getters，因为这两个成员都是直接放回
// 如果方法没有自己的逻辑，也可以使用映射函数
import {mapState,mapGetters,mapMutations,mapActions} from 'vuex'

export default {
  data() {
    return {
      // 学生信息
      stu:{
        no:'',name:'',sex:'',age:''
      },
      // 汽车信息
      car:{
        no:'',name:'',color:'',price:''
      }
    }
  },
  computed:{
    // 使用映射函数，自动生成固定结构代码
    ...mapState(['stus','a','b','c']),
    ...mapGetters(['avgAge']),
    // 如果要映射子模块中的成员，第一个参数是子模块名称
    ...mapState('car',['cars']),
    ...mapGetters('car',['avgPrice'])
  },
  methods:{
    // 映射方法
    ...mapActions(['delStu']),
    ...mapMutations(['addStu']),
    // 取消学生
    cancel1(){
      this.stu = {
        no:'',name:'',sex:'',age:''
      }
    },
    // 映射子模块方法
    ...mapActions('car',['delCar']),
    ...mapMutations('car',['addCar']),
    // 取消汽车
    cancel2(){
      this.car = {
        no:'',name:'',color:'',price:''
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