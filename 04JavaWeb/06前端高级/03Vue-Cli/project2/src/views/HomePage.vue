<template>
  <div class="home">
    <h2>首页</h2>
    <div class="search">
      <span>年级：</span>
      <el-select size="mini" v-model="gradeId" placeholder="请选择年级">
        <el-option
          v-for="item in grades"
          :key="item.gradeId"
          :label="item.gradeName"
          :value="item.gradeId">
        </el-option>
      </el-select>
      <span style="margin-left: 10px;">课程：</span>
      <el-input style="width: 300px;" size="mini" v-model="subjectName"
       placeholder="请输入课程名称模糊查询"></el-input>
      <el-button style="margin-left: 10px;" size="mini" type="primary" @click="search">查询</el-button>
    </div>
    <el-table :data="subjects" style="width: 100%" size="small">
      <el-table-column prop="subjectId" label="课程编号" width="180"> </el-table-column>
      <el-table-column prop="subjectName" label="课程名称" width="280"> </el-table-column>
      <el-table-column prop="classHour" label="课程课时" width="180"> </el-table-column>
       <el-table-column prop="grade.gradeName" label="所属年级" width="180"> </el-table-column>
    </el-table>
    <el-pagination style="margin-top: 10px;"
      background
      layout="prev, pager, next"
      :current-page="pageIndex"
      :page-size="pageSize"
      :total="total"
      @current-change="currentChange">
    </el-pagination>
  </div>
</template>

<script>
// 导入axios
import axios from 'axios'
export default {
  data() {
    return {
      // 年级数组
      grades:[],
      //课程数组
      subjects:[],
      // 总数量
      total:0,
      // 页码
      pageIndex:1,
      // 每页数量
      pageSize:5,
      // 年级编号（用于筛选）
      gradeId:0,
      // 课程名称（用于筛选）
      subjectName:''
    };
  },
  methods:{
    // 搜索方法
    search(){
      this.pageIndex = 1;
      this.loadSubjects()  // 加载课程列表
    },
    // 加载年级数组
    async loadGrades(){
      let {data:{data}} = await axios.get('http://localhost:8081/grades')
      this.grades = data;
      this.grades.unshift({
        gradeId:0,
        gradeName:'请选择年级'
      })
    },
    // 加载课程数组
    async loadSubjects(){
      let {data:{data:{rows,total}}} = await axios.get('http://localhost:8081/subjects',{
        params:{
          pageIndex:this.pageIndex,
          pageSize:this.pageSize,
          gradeId:this.gradeId,
          subjectName:this.subjectName
        }
      })
      this.subjects = rows;
      this.total = total;
    },
    // 切换页码事件
    currentChange(e){
      this.pageIndex = e;
      this.loadSubjects()  // 加载课程列表
    }
  },
  mounted() {
    this.loadGrades()    // 加载年级列表
    this.loadSubjects()  // 加载课程列表
  },
};
</script>

<style>
.home {
  border: 1px solid lightblue;
  padding: 10px;
}
.search{
  display:flex;
  align-items: center;
  padding: 10px 0;
}
</style>
