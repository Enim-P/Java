export default {
  // 设置为私有模块
  namespaced:true,
  state:{
    // 汽车数组
    cars:[
      {no:'苏A1001',name:'保时捷',price:5000},
      {no:'苏A1002',name:'奔驰',price:4400},
      {no:'苏A1003',name:'宝马',price:3800},
      {no:'苏A1004',name:'奥迪',price:2700},
    ]
  },
  getters:{
    // 平均价格
    avgPrice(state){
      let total = state.cars.reduce((r,c)=>r+c.price,0)
      return (total/state.cars.length).toFixed(1)
    }
  },
  mutations:{
    // 添加汽车
    addCar(state,car){
      if(state.cars.some(c=>c.no==car.no)){
        return alert('车牌号不能重复！')
      }
      state.cars.push(car)
    },
    // 删除汽车
    delCar(state,index){
      state.cars.splice(index,1)
    }
  },
  actions:{
    // 异步删除方法
    delCar(store,index){
      setTimeout(() => {
        // 执行网异步任务后，还是要调用同步方法更新state
        store.commit('delCar',index)
      }, 500);
    }
  }
}