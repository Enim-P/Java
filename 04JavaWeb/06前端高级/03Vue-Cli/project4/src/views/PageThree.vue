<template>
  <div class="page3">
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
          <button @click="addCar">添加</button>
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
      // 汽车信息
      car:{
        no:'',name:'',color:'',price:''
      }
    }
  },
  computed:{
    // 汽车列表
    cars(){
      // 注意：这里是从car子模块中返回对应的state
      return this.$store.state.car.cars;
    },
    // 平均价格
    avgPrice(){
      // 注意：访问私有getters和访问私有state的语法是不一样的
      return this.$store.getters['car/avgPrice'];
    }
  },
  methods:{
    // 删除汽车
    delCar(index){
      // 注意：这里指定的是子模块car中的delCar方法
      this.$store.dispatch('car/delCar',index)
    },
    // 添加汽车
    addCar(){
      // 注意：这里指定的是子模块car中的addCar方法
      this.$store.commit('car/addCar',{...this.car})
    },
    // 取消方法
    cancel(){
      this.car = {
        no:'',name:'',color:'',price:''
      }
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