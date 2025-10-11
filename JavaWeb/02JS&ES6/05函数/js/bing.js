//1.检查一个年份是否是闰年
function isLeepYear(year){
  return year%4==0 && year%100!=0 || year%400==0
}

//2.对个位数字补零
function repair0(val){
  return val>=10 ? val : '0'+val
}

//3.返回一个日期的短日期格式
function miniDate(date){
  let y = date.getFullYear();
  // 月份和日期需要补零
  let m = repair0(date.getMonth()+1)
  let d = repair0(date.getDate())
  return [y,m,d].join('-')
}

//4.返回一个中国式的日期格式
function chinaDate(date){
  let y = date.getFullYear();
  // 月份和日期需要补零
  let m = repair0(date.getMonth()+1)
  let d = repair0(date.getDate())

  let h = repair0(date.getHours())
  let mi = repair0(date.getMinutes())
  let s = repair0(date.getSeconds())

  let w = date.getDay()
  return [y,m,d].join('-')+' '+[h,mi,s].join(':')+ ' 星期'
  +'日一二三四五六'[w]
}

//5.对字符串反转
function reverseStr(str){
  return str.split('').reverse().join('')
}