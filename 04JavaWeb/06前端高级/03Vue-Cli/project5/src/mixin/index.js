import Vue from 'vue'
import axios from 'axios';

// 全局混入
// 将来无论有多少页面，多少组件，全局混入中的成员会跟它们合并
Vue.mixin({
  // 除了不能定义模板，其他所有选项都可以混入
  data() {
    return {
      hxData:{}
    }
  },
  methods:{
    getHxData(){
      axios.get('/data/data.json').then(({data})=>{
        this.hxData = data;
      })
    },
    upHxData(val){
      this.hxData = val
    }
  },
  mounted() {
    // console.log('组件挂载完成！');
  }
})