// 对字符串类型增强
// 字符增强反转方法
String.prototype.reverse = function(){
  return this.split('').reverse().join('')
}


// 对数组类型增强



// 对日期类型增强
// 日期增强返回短日期方法
Date.prototype.getMiniDate = function(){
  let y = this.getFullYear()
  let m = this.getMonth()+1
  let d = this.getDate()
  return [y,m,d].map(r=>r>=10?r:'0'+r).join('-')
}

