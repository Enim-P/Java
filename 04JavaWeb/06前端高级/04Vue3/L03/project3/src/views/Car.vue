<template>
  <div class="car">
    <h2>{{currentCar.name}}</h2>
    <p>{{currentCar.content}}</p>
  </div>
</template>

<script setup>
import {reactive,computed} from 'vue'
import {useRoute} from 'vue-router'
let route = useRoute()
// 汽车数组
let cars = reactive([
  {
    id:1,
    name:'保时捷',
    content:`保时捷（Porsche，又译作波尔舍）是大众集团旗下的世界著名豪华汽车品牌 [33]，由费迪南德·保时捷（Ferdinand Porsche）于1931年创立 [66-67]。保时捷总部位于德国斯图加特，是欧美汽车的主要代表之一 [33]。现任保时捷全球执行董事会主席为奥利弗·布鲁姆（Oliver Blume）。`
  },
  {
    id:2,
    name:'玛莎拉蒂',
    content:`玛莎拉蒂（Maserati），是意大利Stellantis集团旗下的汽车品牌 [69-70]，旗下产品涵盖跑车 [71]、豪华旅行车和SUV等 [72]，1914年12月1日成立于意大利博洛尼亚，总部位于摩德纳 [71]，创始人为阿尔菲力·玛莎拉蒂及兄弟 [72]，首席执行官为让·菲利普·因帕拉托（Jean-Philippe Imparato）。`
  },
  {
    id:3,
    name:'法拉利',
    content:`法拉利（英文名：Ferrari，股票代码：RACE [128]）是全球知名的赛车和运动跑车品牌，由恩佐·法拉利（Enzo Ferrari）于1947年创立，总部位于意大利摩德纳马拉内罗，主营业务有汽车制造、汽车生产、汽车销售。 [114]执行主席为约翰・埃尔坎（John Elkann）。`
  },
  {
    id:4,
    name:'迈凯伦',
    content:`迈凯伦集团总部位于英国沃金(Woking)，聚集了先进的高科技公司，每个公司都最大化地为迈凯伦在世界一级方程式锦标赛运动领域的前沿技术中建立起的全球名声和美誉添砖加瓦。`
  }
])
// 当前汽车
let currentCar = computed(()=>{
  // query方式的路由参数，无法通过props接收
  return cars.find(c=>c.id==route.query.id)
})
</script>

<style lang="scss" scoped>
.car{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>