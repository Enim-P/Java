<template>
  <div class="child2">
    <h3>朱标</h3>
    <Child4></Child4>
  </div>
</template>

<script>
import Child4 from './Child4.vue';
export default {
  components:{
    Child4
  },
  setup () {
    

    return {}
  }
}
</script>

<style lang="scss" scoped>
.child2{
  border: 1px solid red;
  padding: 10px;
}
</style>