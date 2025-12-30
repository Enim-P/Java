<template>
  <div class="three">
    <p>汽车：{{car}}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      car:'问界M9'
    }
  },
  mounted() {
    this.$bus.$on('sync-car',(e)=>{
      this.car = e
    })
  },
}
</script>

<style lang="scss" scoped>
.three{
  border: 1px solid blue;
  padding: 10px;
}
</style>