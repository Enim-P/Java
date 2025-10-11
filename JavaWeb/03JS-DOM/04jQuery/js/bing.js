let $b = {
  throttle_time:null,
  shake_time:null,
  // 节流方法
  throttle(callback,time){
    if(new Date() - this.throttle_time >= time){
      callback()
      this.throttle_time = new Date()
    }
  },
  // 防抖方法
  shake(callback,time){
    if(new Date() - this.shake_time >= time){
      callback()
    }
    this.shake_time = new Date()
  }
}