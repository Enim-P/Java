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
            <button @click="delStu(index)">删除</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">平均年龄：{{avgAge}}</td>
        </tr>
      </tbody>
    </table>
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
    <hr style="margin: 10px 0;">
    <table>
      <thead>
        <tr>
          <th>车牌</th>
          <th>车名</th>
          <th>价格</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in cars" :key="index">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.price}}</td>
          <td><button @click="delCar(index)">删除</button></td>
        </tr>
        <tr>
          <td colspan="4">平均价格：{{avgPrice}}</td>
        </tr>
      </tbody>
    </table>
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
        <td>价格：</td>
        <td><input type="text" v-model.number="car.price"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button @click="addCar">添加</button>
          <button @click="cancel2">取消</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
// useStore函数执行后，返回store对象
import {useStore} from 'vuex'
import {computed,ref} from 'vue'
export default {
  setup () {
    // 返回当前项目中的store对象
    let store = useStore()
    // 学生对象
    let stu = ref({
      no:'',name:'',age:''
    })
    // 学生数组
    let stus = computed(()=>{
      return store.state.stus
    })
    // 平均年龄
    let avgAge = computed(()=>{
      return store.getters.avgAge
    })
    // 添加
    let addStu = ()=>{
      store.commit('addStu',{...stu.value})
    }
    // 取消
    let cancel = ()=>{
      stu.value = {no:'',name:'',age:''}
    }
    // 删除
    let delStu = (index)=>{
      if(confirm('确定删除吗？')){
        store.dispatch('delStu',index)
      }
    }
    ////////////////////////////////
    // 汽车对象
    let car = ref({
      no:'',name:'',price:''
    })
    // 汽车数组
    let cars = computed(()=>{
      // 返回子模块car中的状态
      return store.state.car.cars;
    })
    // 平均价格
    let avgPrice = computed(()=>{
      // 注意：返回子模块中的getters语法跟返回state是不一样的
      return store.getters['car/avgPrice']
    })
    // 添加汽车
    let addCar = ()=>{
      // 调用子模块car中的addCar同步方法
      store.commit('car/addCar',{...car.value})
    }
    // 取消
    let cancel2 = ()=>{
      car.value = {
        no:'',name:'',price:''
      }
    }
    // 删除汽车
    let delCar = (index)=>{
      if(confirm('确定删除吗？')){
        // 调用子模块car中的delCar异步方法
        store.dispatch('car/delCar',index)
      }
    }
    return {
      stus,avgAge,stu,addStu,cancel,delStu,
      cars,avgPrice,car,addCar,cancel2,delCar
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