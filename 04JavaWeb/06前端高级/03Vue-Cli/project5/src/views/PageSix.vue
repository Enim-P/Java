<template>
  <div class="six">
    <button @click="isShow=!isShow">显示/隐藏</button>
    <hr style="margin: 10px 0;">
    <div class="box" v-if="isShow">
      <input ref="txt" type="text">
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return {
      isShow:false
    }
  },
  watch:{
    isShow(nval){
      if(nval){
        // $nextTick里面的代码，会在页面挂载完成后执行
        // 因为数据的更新永远在页面挂载完成之前，
        // 有些操作不能只根据数据来写，而是要根据页面是否挂载完成来写。
        this.$nextTick(()=>{
          this.$refs.txt.focus()
        })
        // 野路子，不科学
        // setTimeout(() => {
        //   this.$refs.txt.focus()
        // }, 1000);
        
        // 这里会报错
        // this.$refs.txt.focus()
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.six{
  border: 1px solid #ddd;
  padding: 10px;
  .box{
    width: 300px;
    height: 300px;
    border: 1px solid #ccc; 
    padding: 20px; 
    input{
      padding: 2px;
      line-height: 20px;
    }
  }
}
</style>