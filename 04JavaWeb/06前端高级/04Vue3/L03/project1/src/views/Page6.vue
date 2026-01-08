<template>
  <div class="page6">
    <div class="a"></div>
    <Four></Four>
  </div>
</template>

<script>
import Four from '@/components/Four.vue';
export default {
  components:{
    Four
  },
  setup () {

    return {}
  }
}
</script>

<style lang="scss" scoped>
.page6{
  border: 1px solid #ddd;
  padding: 10px;
  // 相对定位
  position: relative;
  width: 700px;
  .a{
    width: 100px;
    height: 50px;
    background-color: red;
    // 绝对定位
    position: absolute;
    right: 0;
    bottom: 0;
  }
}
</style>