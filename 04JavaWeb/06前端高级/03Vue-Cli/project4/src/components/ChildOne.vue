<template>
  <div class="one">
    <h2>子组件</h2>
    <p>姓名：{{name}} <button @click="setName">修改姓名</button></p>
    <p>年龄：{{age}} <button @click="setAge">修改年龄</button></p>
    <p>城市：{{city}}</p>
    <SubOne></SubOne>
  </div>
</template>

<script>
import SubOne from './SubOne.vue';
export default {
  components:{
    SubOne
  },
  // props是只读的，不能修改
  props:['name','age'],
  data() {
    return {
      city:'重庆市'
    }
  },
  methods:{
    setName(){
      // 触发自定义事件
      this.$emit('set-name','王五')
    },
    setAge(){
      this.$emit('set-age',35)
    }
  },
  mounted(){
    // $on用于监听事件
    this.$bus.$on('set-city',(e)=>{
      this.city = e;
    })
  }
}
</script>

<style lang="scss" scoped>
.one{
  border: 1px solid red;
  padding: 10px;
  margin-top: 10px;
}
</style>