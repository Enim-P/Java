// 定义方法，传入日期参数，返回短日期格式

function getMiniDate(date){
  let year = date.getFullYear()
  let month = date.getMonth();
  let day = date.getDate();
  return [year,month,day].map(r => r<10 ? '0'+r : r).join("-")
}

let date = new Date()
console.log(date);

let date2 = getMiniDate(date);

// 2025-12-02
console.log(date2);
