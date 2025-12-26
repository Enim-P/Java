// 每个子模块，就是一个导出去的对象
export default {
  // 在对象中有自己的状态，计算属性，同步方法，异步方法
  // 默认情况下，子模块的state是私有的，其他成员都会跟主模块合并
  // 合并后如果命名冲突，后合并的成员会把之前的成员替换掉。
  // 所以，通常情况下子模块要设置为私有子模块
  namespaced:true,   //设置为私有子模块，所以的成员都不会跟主模块合并
  state:{
    // 汽车数组
    cars:[
      {no:'苏A1001',name:'问界',color:'黑色',price:100},
      {no:'苏A1002',name:'理想',color:'白色',price:120},
      {no:'苏A1003',name:'小鹏',color:'红色',price:140},
      {no:'苏A1004',name:'小米',color:'紫色',price:160},
    ]
  },
  getters:{
    // 平均价格
    avgPrice(state){
      let total = state.cars.reduce((r,c)=>r+c.price,0)
      return (total / state.cars.length).toFixed(1)
    }
  },
  mutations:{
    // 添加汽车
    addCar(state,val){
      state.cars.push(val)
    },
    // 删除汽车
    delCar(state,index){
      state.cars.splice(index,1)
    }
  },
  actions:{
    // 删除汽车的异步方法
    async delCar(store,index){
      setTimeout(() => {
        // 调用同步方法更新状态
        store.commit('delCar',index)
      }, 500);
    }
  }
}