<template>
  <button class="my-button" :style="{backgroundColor:bgColor,color:color}">
    <slot></slot>
  </button>
</template>

<script>
export default {
  props:['bgColor','color']
}
</script>

<style lang="scss" scoped>
.my-button{
  border: 1px solid #ddd;
  padding: 2px 12px;
}
</style>