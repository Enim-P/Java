<template>
  <div class="two">
    <h2>雨花台区</h2>
    <ThreeCom></ThreeCom>
  </div>
</template>

<script>
import ThreeCom from './ThreeCom.vue';
export default {
  components:{
    ThreeCom
  }
}
</script>

<style scoped>
.two{
  border: 1px solid green;
  padding: 10px;
}
h2{
  color: green;
}
</style>