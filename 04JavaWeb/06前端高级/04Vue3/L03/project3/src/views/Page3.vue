<template>
  <div class="page3">
    <div>
      <button @click="isShow=!isShow">显示/隐藏</button>
    </div>
    <!-- 需要添加动画的元素，使用Transition组件包裹起来 -->
    <Transition name="flag">
      <img v-if="isShow" style="width: 200px;" src="https://qcloud.dpfile.com/pc/Slgvx-LX6xjEXU_zsRtIbhCK7OSrLqK4WlwyV-DEMZF1IvQuz5oUhaV_Pbnr27MJ.jpg"/>
    </Transition>
    <hr style="margin: 10px 0;">
    <div>
      <span>三国人物：</span>
      <input type="text" v-model="name">
      <button @click="names.push(name)">添加</button>
    </div>
    <!-- 给列表元素添加动画，使用TransitionGroup组件 -->
    <TransitionGroup tag="ul" name="flag">
       <li v-for="(item,index) in names" :key="index">
        <span>{{item}}</span>
        <button @click="names.splice(index,1)">删除</button>
      </li>
    </TransitionGroup>
  </div>
</template>

<script setup>
import {ref,reactive} from 'vue'
let isShow = ref(false)
let names = reactive(['刘备','曹操','孙权','关羽'])
let name = ref('')
</script>

<style lang="scss" scoped>
.page3{
  border: 1px solid #ddd;
  padding: 10px;
  ul{
    li{
      width: 200px;
      display: flex;
      justify-content: space-between;
      border: 1px solid lightblue;
      margin: 2px;
      padding: 2px;
    }
  }
}
// 进入时
.flag-enter-active{
  transition: all 1s;
}
// 离开时
.flag-leave-active{
  transition: all 2s;
}
// 进入前
.flag-enter-from{
  opacity: 0;
  transform: translateX(200px) rotate(360deg);
}
// 离开后
.flag-leave-to{
  opacity: 0;
  transform: translateX(-200px) rotate(-360deg);
}
</style>