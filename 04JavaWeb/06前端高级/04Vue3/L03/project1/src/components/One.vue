<template>
  <div class="one">
    <span v-for="item in 200">你好</span>
  </div>
</template>

<script>
export default {
  setup () {

    return {}
  }
}
</script>

<style lang="scss" scoped>
.one{
  border: 1px solid lightblue;
  padding: 10px;
  margin: 10px;
}
</style>