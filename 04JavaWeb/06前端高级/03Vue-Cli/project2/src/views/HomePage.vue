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
      <el-button style="margin-left: 10px;" size="mini" type="success" 
        @click="$refs.edit.drawer=true">添加</el-button>
    </div>
    <el-table :data="subjects" style="width: 100%" size="small">
      <el-table-column prop="subjectId" label="课程编号" width="180"> </el-table-column>
      <el-table-column prop="subjectName" label="课程名称" width="280"> </el-table-column>
      <el-table-column prop="classHour" label="课程课时" width="180"> </el-table-column>
      <el-table-column prop="grade.gradeName" label="所属年级" width="180"> </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.row.subjectId)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.subjectId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination style="margin-top: 10px;"
      background
      layout="prev, pager, next"
      :current-page="pageIndex"
      :page-size="pageSize"
      :total="total"
      @current-change="currentChange">
    </el-pagination>
    <!-- 3.使用组件 -->
    <SubjectEdit ref="edit"></SubjectEdit>
  </div>
</template>

<script>
// 导入axios
import axios from 'axios'
// 1.导入组件（@是回到项目的根路径）
import SubjectEdit from '@/components/SubjectEdit.vue';
export default {
  // 2.注册组件
  components:{
    SubjectEdit
  },
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
    // 删除方法
    handleDelete(subjectId){
      this.$confirm('确定删除该课程信息吗？', '系统提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 确定操作
          axios.delete('http://localhost:8081/subjects/'+subjectId).then(({data:{code}})=>{
            if(code==1){
               this.$message({
                message:'删除成功！',
                type:'success',
                showClose:true,
              })
              this.loadSubjects()  //重新加载课程列表
            }else{
              this.$message({
                message:'删除失败！',
                type:'error',
                showClose:true,
              })
            }
          })
        }).catch(() => {
          // 取消操作
        });
    },
    // 编辑方法
    handleEdit(subjectId){
      this.$refs.edit.drawer = true   //打开编辑窗口
      this.$refs.edit.subjectId = subjectId   //将需要编辑的课程编号传过去
    },
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
