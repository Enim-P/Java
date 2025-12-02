// 手写一个冒泡排序算法对数组排序
let arr = [44,33,55,22,11]

// 外层循环控制比较轮数，内层循环控制每轮比较次数
for(let i=0;i<arr.length-1;i++){
  for(let j=0;j<arr.length-1-i;j++){
    if(arr[j]>arr[j+1]){
      let temp = arr[j];
      arr[j] = arr[j+1];
      arr[j+1] = temp;
    }
  }
}

console.log(arr);
