<template>
  <div class="sone">
    <h3>孙组件</h3>
    <p>手机：{{phone}}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      phone:'华为手机'
    }
  },
  mounted() {
    this.$bus.$on('set-phone',(e)=>{
      this.phone = e
    })
  },
}
</script>

<style lang="scss" scoped>
.sone{
  border: 1px solid blue;
  padding: 10px;
  margin-top: 10px;
}
</style>