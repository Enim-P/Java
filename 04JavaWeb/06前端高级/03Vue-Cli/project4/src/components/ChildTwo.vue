<template>
  <div class="two">
    <h2>子组件</h2>
    <p>
      <button @click="upCity">修改城市名称</button>
    </p>
    <SubTwo></SubTwo>
  </div>
</template>

<script>
import SubTwo from './SubTwo.vue';
export default {
  components:{
    SubTwo
  },
  methods:{
    upCity(){
      // $emit用于触发事件,$on用于监听事件
      // 注意：触发事件和监听事件的对象必须是同一个对象
      this.$bus.$emit('set-city','成都市')
    }
  },
  
}
</script>

<style lang="scss" scoped>
.two{
  border: 1px solid green;
  padding: 10px;
  margin-top: 10px;
}
</style>