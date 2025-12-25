<template>
  <div class="page1">
    <h1>父组件</h1>
    <p>姓名：{{name}} <button @click="setName">修改姓名</button></p>
    <p>年龄：{{age}} <button @click="setAge">修改年龄</button></p>
    <p>汽车：{{car}}</p>
    <!-- 父组件通过props向子组件传值，子组件通过$emit触发自定义事件向父组件回传值 -->
    <ChildOne :name="name" :age="age"
    @set-name="name=$event" @set-age="age=$event"></ChildOne>
    <ChildTwo></ChildTwo>
  </div>
</template>

<script>
import ChildOne from '@/components/ChildOne.vue';
import ChildTwo from '@/components/ChildTwo.vue';
export default {
  components:{
    ChildOne,
    ChildTwo
  },
  // 定义数据
  data() {
    return {
      name:'张三',
      age:20,
      car:'保时捷'
    }
  },
  // 定义依赖数据，后代组件可以注入父级中定义的依赖数据
  provide(){
    return{
      // 数据
      car:this.car,
      // 修改数据的方法
      setCar:this.setCar
    }
  },
  methods:{
    setName(){
      this.name = "李四"
    },
    setAge(){
      this.age = 30
    },
    setCar(val){
      this.car = val
    }
  }
}
</script>

<style lang="scss" scoped>
.page1{
  border: 1px solid lightblue;
  padding: 10px;
}
</style>