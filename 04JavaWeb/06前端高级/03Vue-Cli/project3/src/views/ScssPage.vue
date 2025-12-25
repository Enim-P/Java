<template>
  <div class="scss">
    <h2>江苏省</h2>
    <div class="one">
      <h2>南京市</h2>
      <div class="two">
        <h2>雨花台区</h2>
        <div class="three">
          <h2>软件大道</h2>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    
  }
</script>

<!--
安装sass：npm i sass sass-loader -D
需要同时安装sass环境和sass翻译器，并安装到开发环境
-->
<!-- sass有两套语法：sass 和 scss
  scss语法跟css相似，使用{}定义层级关系
  sass语法跟ruby相似，使用缩进定义层级关系
-->
<style lang="scss">
// scss中使用率最高的两个技术：1.嵌套选择器 2.定义变量
// 变量名以$符号开头
// $black:black;
// $red:darkred;
// $green:darkgreen;
// $blue:darkblue;
// 导入scss文件
@import '../assets/scss/index.scss';

.scss{
  border: 1px solid $black;
  padding: 10px;
  h2{
    color: $black;
  }
  .one{
    border: 1px solid $red;
    padding: 10px;
    h2{
      color: $red;
    }
    .two{
      border: 1px solid $green;
      padding: 10px;
      h2{
        color: $green;
      }
      .three{
        border: 1px solid $blue;
        padding: 10px;
        h2{
          color: $blue;
        }
      }
    }
  }
}
</style>