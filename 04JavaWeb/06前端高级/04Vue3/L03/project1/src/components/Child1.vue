<template>
  <div class="child1">
    <!-- props可以直接在模板中使用 -->
    <p>手机：{{phone}}</p>
    <!-- 也可以将props加工后再使用 -->
    <p>我的城市：{{myCity}}</p>
    <!-- attrs用于接收props没有接收的属性 -->
    <p>我的城市2：{{myCity2}}</p>
    <div>
      <button @click="upPhone">更新手机</button>
    </div>
    <p>吃的1：{{foods1}}</p>
    <p>吃的2：{{foods2}}</p>
    <p>吃的3：{{foods3}}</p>
    <hr>
    <!-- 这里定义了一个插槽 -->
    <slot></slot>
  </div>
</template>

<script>
import {computed,toRefs,ref} from 'vue'
export default {
  // props选项定义属性
  props:['phone','city1','city2'],
  setup(props,context){
    // setup方法有两个参数：
    // 参数1就是props,用于接收父组件传递过来的属性
    // 注意：这里只能接受到props选项中定义的属性
    // console.log(props);
    // setup方法的第二个参数是上下文对象
    // 该对象有四个成员：attrs，emit，expose，slots
    // attrs：用于接收props选项没有接收的属性
    // emit函数：用于触发自定义事件
    // expose函数：返回子组件暴露给父组件的成员
    // slots：返回的是插槽相关信息
    // console.log(context);
    // let {city1,city2} = toRefs(props)
    let myCity = computed(()=>{
      return props.city1+' '+props.city2
    })
    let myCity2 = computed(()=>{
      return context.attrs.city3 + ' '+context.attrs.city4
    })
    // 更新手机的方法
    let upPhone = ()=>{
      // 触发自定义事件，将最新的手机名称回传给父组件
      context.emit('sync-phone','华为手机')
    }
    let foods1 = ref('奶茶')
    let foods2 = ref('咖啡')
    let foods3 = ref('蛋糕')

    // 向外暴露当前组件的成员
    context.expose({
      foods1
    })
    // 返回default插槽中的内容，返回的是虚拟DOM信息
    // 虚拟DOM是一个JS对象，用来描述一个真实DOM的详细信息
    // 在正式渲染之前，可以在这样对虚拟DOM进行修改
    // 它的作用：就是对插槽中的内容进行修正
    let defaultSlot = context.slots.default()
    defaultSlot[0].children = '西安'   
    defaultSlot[1].children[0].children = '陕西省省会'

    return{
      myCity,myCity2,upPhone,
      foods1,foods2,foods3
    }
  }
}
</script>

<style lang="scss" scoped>
.child1{
  border: 1px solid red;
  padding: 10px;
}
</style>