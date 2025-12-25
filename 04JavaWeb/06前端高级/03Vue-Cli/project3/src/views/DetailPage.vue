<template>
  <div class="detail">
    <div>
      详情：
      <textarea rows="6" cols="50" v-model="message"></textarea>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message:'请认真阅读详情'
    }
  },
  mounted() {
    console.log("DetailPage - 挂载完成");
  },
  destroyed() {
    console.log('DetailPage - 销毁完成');
  },
  // 组件一旦被缓存了，它就会触发另外两个生命周期函数
  activated(){
    console.log("DetailPage - 组件激活生命周期函数");
  },
  deactivated(){
    console.log("DetailPage - 组件失活生命周期函数");
  }
}
</script>

<style>
.detail{
  border: 1px solid lightcoral;
  padding: 10px;
}
</style>