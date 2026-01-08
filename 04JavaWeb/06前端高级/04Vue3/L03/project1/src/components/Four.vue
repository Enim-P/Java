<template>
  <div class="four">
    <button @click="isShow=true">弹框</button>
    <!-- teleport是传送门组件，它可以将该组件内的所有内容传送到指定的容器中 -->
    <teleport to="body">
      <!-- 这个div虽然是写在当前组件中的，显示的时候会传送给body -->
      <div class="box" v-if="isShow">
        <button @click="isShow=false">关闭</button>
      </div>
    </teleport>
  </div>
</template>

<script>
import {ref} from 'vue'
export default {
  setup () {
    let isShow = ref(false)

    return {
      isShow
    }
  }
}
</script>

<style lang="scss" scoped>
.four{
  margin: 10px;
  padding: 10px;
  border: 1px solid red;
  width: 500px;
  height: 500px;

  .box{
    width: 300px;
    height: 300px;
    background-color: lightblue;
    border: 1px solid black;
    position: absolute;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    margin: auto;
  }
}
</style>