<template>
  <div class="child1">
    <p>手机：{{props.phone}}</p>
    <p>汽车：{{props.car}}</p>
    <p>奶茶：{{attrs.food}}</p>
    <div>
      <button @click="upCar">修改汽车</button>
      <button @click="upFood">修改奶茶</button>
    </div>
    <p>存款：{{money}}</p>
  </div>
</template>

<script setup>
import {useAttrs,ref} from 'vue'
// defineProps用于接收父组件传递过来的属性数据，该函数默认就已经导入了，不需要手动导入
// 需要接收哪些属性在参数数组中定义出来
let props = defineProps(['phone','car'])
// defineEmits用于触发自定义事件，该函数默认就已经导入了，不需要手动导入
// 需要将触发哪些事件在参数数组中定义出来
let emits = defineEmits(['up-car','up-food'])
// useAttrs函数，用于捡漏defineProps没有接收的属性
let attrs = useAttrs()
// 修改汽车
let upCar = ()=>{
  emits('up-car','小鹏汽车')
}
// 修改奶茶
let upFood = ()=>{
  emits('up-food','沪上阿姨')
}
let money = ref(20000)
// defineExpose用于暴露成员给父组件使用，该函数默认导入
defineExpose({
  money
})
</script>

<style lang="scss" scoped>
.child1{
  border: 1px solid red;
  padding: 10px;
  margin: 10px;
}
</style>