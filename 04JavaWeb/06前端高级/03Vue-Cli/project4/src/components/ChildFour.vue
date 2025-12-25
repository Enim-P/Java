<template>
  <div class="four">
    <p>
      <button @click="upCount">更新数量</button>
    </p>
  </div>
</template>

<script>
export default {
  methods:{
    upCount(){
      // 直接更新状态，看似效果可以实现，而且控制台也没有报错，但是不推荐
      // this.$store.state.count++
      // 通过commit调用mutations中定义的方法
      // 参数1是方法名称，参数2是传递的值
      this.$store.commit('setCount',100)
    }
  }
}
</script>

<style lang="scss" scoped>
.four{
  border: 1px solid blue;
  padding: 10px;
  margin-top: 10px;
}
</style>