<template>
  <div class="page1">
    <div>{{msg}}</div>
    <!-- v-text：相当于innerText -->
    <div v-text="msg"></div>
    <!-- v-html：相当于innerHTML，
      其实这个指令背后肯定要先获取dom元素，在通过dom元素的innerHTML属性设置内容
    -->
    <div v-html="msg"></div>
    <!-- 像上面这些都是官方指令，指令的作用本质上就是对DOM操作的封装 -->
    <hr style="margin: 10px 0;">
    <div v-red>我是红色</div>
    <div v-blue>我是蓝色</div>
    <div v-color="color1">今天是2025年12月29日星期一</div>
    <div v-color="color2">今天的温度是15度</div>
    <button @click="isShow=!isShow">显示/隐藏</button>
    <div v-myif="isShow">你好！欢迎光临！</div>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        msg:'<h2>你好！欢迎光临！</h2>',
        color1:'green',
        color2:'#400598',
        isShow:false,
      }
    }
  }
</script>

<style lang="scss" scoped>
.page1{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>