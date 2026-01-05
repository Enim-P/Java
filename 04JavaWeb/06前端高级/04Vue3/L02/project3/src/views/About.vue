<template>
  <div class="about">
    <h2>计算属性</h2>
    <p>姓：<input type="text" v-model="firstName"></p>
    <p>名：<input type="text" v-model="lastName"></p>
    <p>姓名：{{firstName+'.'+lastName}}</p>
    <p>姓名：{{fullName}}</p>
    <p>姓名：<input type="text" v-model="fullName"></p>
    <hr>
    <table>
      <thead>
        <tr>
          <th><input type="checkbox"  v-model="ckAll"></th>
          <th>商品名称</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in foods">
          <td><input type="checkbox" v-model="item.state"></td>
          <td>{{item.name}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
// 导入computed函数，用于定义组合式计算属性
import {computed,ref,reactive} from 'vue'
export default {
  setup(){
    let firstName = ref('周')
    let lastName = ref('杰伦')
    // 姓名定义成一个计算属性
    // let fullName = computed(()=>{
    //   return firstName.value+'.'+lastName.value
    // })
    // 定义可写状态的计算属性
    let fullName = computed({
      // 返回计算属性的值
      get(){
        return firstName.value+'.'+lastName.value
      },
      // 设置技术属性的值
      set(val){
        let arr = val.split('.')
        firstName.value = arr[0]
        lastName.value = arr[1]
      }
    })
    // 食物数组
    let foods = reactive([
      {name:'苹果',state:true},
      {name:'西瓜',state:false},
      {name:'奶茶',state:false},
      {name:'咖啡',state:true}
    ])
    // 全选状态
    let ckAll = computed({
      get(){
        return foods.every(f=>f.state)
      },
      set(val){
        foods.forEach(f=>f.state=val)
      }
    })
    return {
      firstName,lastName,fullName,
      foods,ckAll
    }
  }
}
</script>

<style lang="scss" scoped>
.about{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>