<template>
  <div class="list">
    <h2>您在当前页面停留了{{time}}秒</h2>
    <div>
      苹果：{{pgCount}} 
      <button @click="pgCount--">数量-</button>
      <button @click="pgCount++">数量+</button>
    </div>
    <div>
      橘子：{{jzCount}} 
      <button @click="jzCount--">数量-</button>
      <button @click="jzCount++">数量+</button>
    </div>
    <div>
      西瓜：{{xgCount}} 
      <button @click="xgCount--">数量-</button>
      <button @click="xgCount++">数量+</button>
    </div>
    <div>
      <button>购买</button>
    </div>
  </div>
</template>

<script>
export default {
  // name属性定义组件的名称，通常情况下可以省略，
  // 如果需要给某一个组件做缓存，就必须要知道名称
  name:'ListPage',
  data() {
    return {
      pgCount:4,
      jzCount:3,
      xgCount:5,
      // 停留时间
      time:0,
      // 定时器变量
      timer:null
    }
  },
  // 组件一旦被缓存了，进来时会触发mounted，离开时不会触发destroyed
  // 而且mounted只会触发第一次
  mounted() {
    console.log("ListPage - 挂载完成");
  },
  destroyed() {
    console.log('ListPage - 销毁完成');
  },
  // 组件一旦被缓存了，它就会触发另外两个生命周期函数
  activated(){
    console.log("ListPage - 组件激活生命周期函数");
    this.timer = setInterval(() => {
      this.time++
    }, 1000);
  },
  deactivated(){
    console.log("ListPage - 组件失活生命周期函数");
    clearInterval(this.timer)
  }
}
</script>

<style>
  .list{
    border: 1px solid lightgreen;
    padding: 10px;
  }
</style>