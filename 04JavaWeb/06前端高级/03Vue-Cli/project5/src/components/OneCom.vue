<template>
  <div class="one">
    <h3>模块组件1</h3>
    <div>
      <button @click="getHxData">查询核心数据</button>
      <button @click="upHxData({...hxData,version:'v3.0.0'})">修改核心数据</button>
      <p>{{hxData}}</p>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style lang="scss" scoped>
.one{
  border: 1px solid red;
  padding: 10px;
}
</style>