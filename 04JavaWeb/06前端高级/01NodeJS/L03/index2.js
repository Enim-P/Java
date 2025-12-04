// 转换日期的方法
function toMiniDate(date){
  let year = date.getFullYear();
  let month = date.getMonth()+1;
  let day = date.getDate();
  return [year,month,day].map(r=>r<10 ? '0'+r : r).join('-');
}

module.exports = {
  toMiniDate
}