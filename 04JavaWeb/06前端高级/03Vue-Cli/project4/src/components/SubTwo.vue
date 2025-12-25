<template>
  <div class="stwo">
    <h3>孙组件</h3>
    <p>汽车：{{myCar}} <button @click="updateCar">修改汽车</button></p>
    <p>
      <button @click="upPhone">修改手机名称</button>
    </p>
  </div>
</template>

<script>
export default {
  // 注入父级中定义的依赖数据
  // inject是只读数据，不能修改
  inject:['car','setCar'],
  data() {
    return {
      // 因为inject是只读数据，如果要修改，就必须先中转成自己的数据
      myCar:this.car
    }
  },
  methods:{
    updateCar(){
      this.myCar = '宝马'
      this.setCar('宝马')
    },
    upPhone(){
      this.$bus.$emit('set-phone','苹果手机')
    }
  }
}
</script>

<style lang="scss" scoped>
.stwo{
  border: 1px solid purple;
  padding: 10px;
  margin-top: 10px;
}
</style>