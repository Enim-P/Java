<template>
  <div class="five">
    <div>
      <span>学号：</span>
      <input type="text" v-model="stu.no">
    </div>
    <div>
      <span>姓名：</span>
      <input type="text" v-model="stu.name">
    </div>
    <div>
      <button @click="addStu">添加</button>
    </div>
    <ul>
      <!-- 在做列表渲染时，key必须要全包唯一性，因为底层就是根据这个key在做优化
       v-for在做列表渲染时，会将每个列表项生成一个对应的虚拟DOM，每个虚拟DOM对应一个唯一的key，
       每次列表发生变化后，都会重新生成一份虚拟DOM，跟之前生成虚拟DOM进行比较，
       为了优化性能，key和value都相同的那部分虚拟DOM不会渲染到页面中，
       比如：我们将index作为key，向数组中添加新的内容时，前面内容对应的索引是不会变化的，
       所以对应的key也就没有变化，那么，那一部分对应的虚拟DOM就不会向页面更新；
       但是如果是向数组的前面插入一条数据，此时生成出来的虚拟DOM的key就全部重新排序了，
       列表中所有的数据都要重新渲染。
       所以，通常不要使用index作为key，而是要使用对象身上的唯一属性，比如：学号，工号，身份证号，车牌号等等
        -->
      <li v-for="(item) in stus" :key="item.no">
        <span>{{item.no+' . '+item.name}}</span>
        <input type="text">
      </li>
    </ul>
    <hr style="margin: 10px 0;">
    <button @click="isShow=!isShow">显示/隐藏</button>
    <br>
    <!-- 将需要添加过渡动画的元素放置到transition组件中，添加name属性定义一个标记 -->
    <transition name="tag">
      <img v-if="isShow" width="200px" src="https://qcloud.dpfile.com/pc/SubrJ6V-95oE_dOuN3fC2G0cpGIyRnsKYoMHWvt6Bu-86DRaYKVlOfP__9y-SpoC.jpg"/>
    </transition>
    <div>
      <input type="text" v-model="food">
      <button @click="foods.push(food)">添加</button>
    </div>
    <!-- transition-group组件，用于给整个列表添加过渡动画，tag属性设置当前组件渲染成什么元素 -->
    <transition-group class="foods" name="tag" tag="ul">
      <li v-for="(item,index) in foods" :key="index">
        <span>{{item}}</span>
        <button @click="foods.splice(index,1)">删除</button>
      </li>
    </transition-group>
  </div>
</template>

<script>
export default {
  data() {
    return {
      stu:{
        no:'',name:''
      },
      stus:[
        {no:'1001',name:'张三'},
        {no:'1002',name:'李四'},
        {no:'1003',name:'王五'},
        {no:'1004',name:'赵六'},
      ],
      isShow:false,
      food:'',
      foods:['苹果','西瓜','葡萄','香蕉']
    }
  },
  methods: {
    addStu(){
      this.stus.unshift({...this.stu})
    }
  },
}
</script>

<style lang="scss" scoped>
.five{
  border: 1px solid #ddd;
  padding: 10px;
  .foods{
    li{
      border: 1px solid #ddd;
      margin: 4px 0;
      padding: 4px;
      width: 200px;
      display: flex;
      justify-content: space-between;
    }
  }
}
// 进入前样式
.tag-enter{
  transform: translateX(200px) rotate(360deg);
  opacity: 0;
}
// 进入时样式
.tag-enter-active{
  transition: all .5s ease;
}
// 离开时样式
.tag-leave-active{
  transition: all .5s ease;
}
// 离开后样式
.tag-leave-to{
  transform: translateX(-200px)  rotate(-360deg);
  opacity: 0;
}
</style>