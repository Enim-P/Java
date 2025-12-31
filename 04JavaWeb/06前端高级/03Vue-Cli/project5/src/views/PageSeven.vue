<template>
  <div class="seven">
    <h2>学生信息</h2>
    <table>
      <thead>
        <tr>
          <th>学号</th>
          <th>姓名</th>
          <th>性别</th>
          <th>年龄</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item) in stus" :key="item.no">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.sex}}</td>
          <td>{{item.age}}</td>
        </tr>
      </tbody>
    </table>
    <h2>汽车信息</h2>
    <table>
      <thead>
        <tr>
          <th>车牌</th>
          <th>车名</th>
          <th>颜色</th>
          <th>价格</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item) in cars" :key="item.no">
          <td>{{item.no}}</td>
          <td>{{item.name}}</td>
          <td>{{item.color}}</td>
          <td>{{item.price}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 学生数组
      stus:[],
      // 汽车数组
      cars:[]
    }
  },
  mounted() {
    // ajax请求数据，必须要遵循同源策略：两端的协议名，主机名(ip)，端口号要完全一致，
    // 否则就是跨越请求。
    // 解决跨域的核心方法有两种：1.后端允许跨域 2.前端通过代理服务器实现跨域
    // 注意：同源策略只针对ajax请求，原生http请求不受影响
    // 这里的代理服务器，就是前端服务器，所以http://localhost:8080可以省略
    // 因为向当前服务器发送请求，可以省略协议名、主机名、端口号
    this.$axios.get('/api1/stus/list').then(({data})=>{
      this.stus = data;
    })
    this.$axios.get('/api2/cars/list').then(({data})=>{
      this.cars = data;
    })
  },
}
</script>

<style lang="scss" scoped>
.seven{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>