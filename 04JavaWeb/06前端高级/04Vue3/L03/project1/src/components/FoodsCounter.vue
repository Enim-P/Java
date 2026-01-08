<template>
  <div class="counter">
    <div class="item">
      <span>苹果：</span>
      <button @click="upPg(pgCount-1)">-</button>
      <span>{{pgCount}}</span>
      <button @click="upPg(pgCount+1)">+</button>
    </div>
    <div class="item">
      <span>西瓜：</span>
      <button @click="upXg(xgCount-1)">-</button>
      <span>{{xgCount}}</span>
      <button @click="upXg(xgCount+1)">+</button>
    </div>
    <div class="item">
      <span>葡萄：</span>
      <button @click="upPt(ptCount-1)">-</button>
      <span>{{ptCount}}</span>
      <button @click="upPt(ptCount+1)">+</button>
    </div>
  </div>
</template>

<script>
export default {
  props:['pgCount','xgCount','ptCount'],
  setup (props,{emit}) {
    let upPg = (val)=>{
      emit('update:pgCount',val)
    }
    let upXg = (val)=>{
      emit('update:xgCount',val)
    }
    let upPt = (val)=>{
      emit('update:ptCount',val)
    }
    return {
      upPg,upXg,upPt
    }
  }
}
</script>

<style lang="scss" scoped>
.counter{
  padding: 10px;
  border: 1px solid lightblue;
  .item{
    padding: 10px;
    border: 1px solid lightpink;
    margin: 10px 0;
    display: flex;
    span{
      padding: 0 10px;
    }
  }
}
</style>