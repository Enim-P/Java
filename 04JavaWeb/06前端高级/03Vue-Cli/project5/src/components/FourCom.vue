<template>
  <div class="four">
    <button @click="upCar">修改汽车</button>
  </div>
</template>

<script>
export default {
  methods:{
    upCar(){
      this.$bus.$emit('sync-car','理想L9')
    }
  }
}
</script>

<style lang="scss" scoped>
.four{
  border: 1px solid orange;
  padding: 10px;
  margin-top: 10px;
}
</style>