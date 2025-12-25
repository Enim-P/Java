<template>
  <div class="page2">
    <!-- 直接在表达式中返回store中定义的数据，
     这里的$store返回的就是注册给Vue实例的store对象 -->
    <p>数量：{{$store.state.count}}</p>
    <ChildThree></ChildThree>
    <ChildFour></ChildFour>
  </div>
</template>

<script>
import ChildThree from '@/components/ChildThree.vue';
import ChildFour from '@/components/ChildFour.vue';
export default {
  components:{
    ChildThree,
    ChildFour
  }
}
</script>

<style lang="scss" scoped>
.page2{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>