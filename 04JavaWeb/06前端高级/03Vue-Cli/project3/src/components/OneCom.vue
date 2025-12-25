<template>
  <div class="one">
    <h2>南京市</h2>
    <TwoCom></TwoCom>
  </div>
</template>

<script>
import TwoCom from './TwoCom.vue';
export default {
  components:{
    TwoCom
  }
}
</script>

<style scoped>
.one{
  border: 1px solid red;
  padding: 10px;
}
h2{
  color: red;
}
</style>