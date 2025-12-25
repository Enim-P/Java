<template>
  <div class="jd">
    <h2>{{currentJd.name}}</h2>
    <p>{{currentJd.content}}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 景点数组
      jds:[
        {
          id:1,
          name:'长城',
          content:'八达岭长城，位于北京市延庆区军都山关沟古道北口，游览面积119万平方米。 [50]是中国古代伟大的防御工程万里长城的重要组成部分，是明长城的一个隘口。八达岭长城为居庸关的重要前哨，古称“居庸之险不在关而在八达岭”。'
        },
        {
          id:2,
          name:'迪士尼',
          content:'上海迪士尼度假区（Shanghai Disney Resort） [6]，是中国大陆第一座、全球第六座迪士尼度假区 [15]，地处上海国际旅游度假区的核心区 [11]，位于上海市浦东新区川沙镇黄赵路310号 [8]，一期开园日占地面积为3.9平方千米 [6] [11]。'
        },
        {
          id:3,
          name:'洪崖洞',
          content:'洪崖洞（Hong Ya Dong [50]），又叫洪岩洞、神仙洞、洪崖门 [6] [14]，全称为洪崖洞民俗风貌区 [17]，是兼具观光旅游、休闲度假等功能的旅游区 [22]，位于重庆市渝中区嘉陵江滨江路88号 [17]，地处长江、嘉陵江两江交汇的滨江地带 [22]，北临解放碑沧白路，南接滨江路 [15]。洪崖洞分为11层，高达79米 [52]，总占地面积3.15万平方米 [12]。'
        },
        {
          id:4,
          name:'盘山',
          content:'盘山风景名胜区，位于天津市蓟州区官庄镇莲花岭村 [20]，占地面积106平方千米，因雄踞北京之东，故有「京东第一山」之誉，盘山旧名无终、徐无、四正、盘龙。相传东汉末年，无终名士田畴不受献帝封赏、隐居于此，因此人称田盘山，简称盘山 [1] [21] [30]。景区是自然山水与名胜古迹并著、佛教文化与皇家文化相融的旅游胜地 [28-29]。'
        }
      ]
    }
  },
  mounted() {
    // $route是当前路由对象，它的query属性中保存的就是query路由参数
    console.log(this.$route.query);
  },
  computed:{
    currentJd(){
      // 注意：params路由参数可以通过props接收，query方式不行
      return this.jds.find(j=>j.id==this.$route.query.id)
    }
  }
}
</script>

<style>
.jd{
  border: 1px solid lightsalmon;
  padding: 10px;
}
</style>