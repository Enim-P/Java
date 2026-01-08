<template>
  <div class="two">
    <span v-for="item in 300">在干嘛</span>
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
.two{
  border: 1px solid lightcoral;
  padding: 10px;
  margin: 10px;
}
</style>