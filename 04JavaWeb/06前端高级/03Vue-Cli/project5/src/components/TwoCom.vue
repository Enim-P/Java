<template>
  <div class="two">
    <h3>模块组件2</h3>
    <div>
      <button @click="getHxData">查询核心数据</button>
      <button @click="upHxData({...hxData,version:'v4.0.0'})">修改核心数据</button>
      <p>{{hxData}}</p>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style lang="scss" scoped>
.two{
  border: 1px solid green;
  padding: 10px;
  margin-top: 10px;
}
</style>