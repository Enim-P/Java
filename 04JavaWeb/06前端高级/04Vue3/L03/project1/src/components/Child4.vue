<template>
  <div class="child4">
    <h4>朱允炆</h4>
    <p>职称：{{type}}</p>
    <p>宝物：{{yx}}</p>
  </div>
</template>

<script>
import $bus from '../eventBus'
// inject函数：用于注入上层组件中定义的依赖数据
import {inject,ref} from 'vue'
export default {
  setup () {
    // 注入依赖数据
    let yx = inject('yx')
    let type = ref('皇帝')

    // 使用事件总线监听指定的事件
    $bus.on('sync-type',(e)=>{
      type.value = e
    })

    return {
      yx,type
    }
  }
}
</script>

<style lang="scss" scoped>
.child4{
  border: 1px solid blue;
  padding: 10px;
}
</style>