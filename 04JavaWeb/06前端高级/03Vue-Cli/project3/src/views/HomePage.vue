<template>
  <div class="home">
    <h2>热门城市</h2>
    <ul>
      <li v-for="(item,index) in citys" :key="index">
        <!-- 这里采用的是params方式传递路由参数 -->
        <router-link :to="'/city/'+item.id">{{item.name}}</router-link>
      </li>
    </ul>
    <hr>
    <div>
      <button v-for="(item,index) in citys" :key="index"
        @click="goCity(item.id)">{{item.name}}</button>
    </div>
    <hr>
    <h2>热门景点</h2>
    <ul>
      <li v-for="(item,index) in jds" :key="index">
        <!-- 这里采用的是query方式传递路由参数 -->
        <router-link :to="'/jd?id='+item.id">{{item.name}}</router-link>
      </li>
    </ul>
    <hr>
    <div>
      <button v-for="(item,index) in jds" :key="index"
        @click="goJd(item.id)">{{item.name}}</button>
    </div>
    <hr>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 城市数组
      citys:[
        {
          id:1,
          name:'北京市'
        },
        {
          id:2,
          name:'上海市'
        },
        {
          id:3,
          name:'重庆市'
        },
        {
          id:4,
          name:'天津市'
        }
      ],
      // 景点数组
      jds:[
        {
          id:1,
          name:'长城'
        },
        {
          id:2,
          name:'迪士尼'
        },
        {
          id:3,
          name:'洪崖洞'
        },
        {
          id:4,
          name:'盘山'
        }
      ]
    }
  },
  methods:{
    goCity(id){
      // $router返回的是路由器对象
      this.$router.push('/city/'+id)
    },
    goJd(id){
      this.$router.push('/jd?id='+id)
    }
  },
}
</script>

<style>
.home{
  border: 1px solid lightblue;
  padding: 10px;
}
</style>