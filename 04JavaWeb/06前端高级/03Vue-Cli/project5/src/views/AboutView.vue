<template>
  <div class="about">
    <ThreeCom></ThreeCom>
    <FourCom></FourCom>
  </div>
</template>

<script>
import ThreeCom from '@/components/ThreeCom.vue';
import FourCom from '@/components/FourCom.vue';
export default {
  components:{
    ThreeCom,FourCom
  }
}
</script>

<style lang="scss">
.about{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>