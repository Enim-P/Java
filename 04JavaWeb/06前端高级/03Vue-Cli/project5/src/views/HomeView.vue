<template>
  <div class="home">
    <h2>页面组件</h2>
    <div>
      <button @click="getHxData">查询核心数据</button>
      <button @click="upHxData({...hxData,version:'v2.0.0'})">修改核心数据</button>
      <p>{{hxData}}</p>
    </div>
    <OneCom></OneCom>
    <TwoCom></TwoCom>
  </div>
</template>

<script>
import OneCom from '@/components/OneCom.vue';
import TwoCom from '@/components/TwoCom.vue';
export default {
 components:{
  OneCom,TwoCom
 },
}
</script>

<style lang="scss">
.home{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>
