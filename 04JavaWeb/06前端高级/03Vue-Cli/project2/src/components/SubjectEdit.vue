<template>
  <!--抽屉-->
  <el-drawer
    :title="subjectId ? '修改课程' : '添加课程'"
    size="40%"
    :visible.sync="drawer"
    direction="rtl"
    :before-close="drawerClose">
    <div style="padding: 10px;">
      <el-form :model="subFormData" status-icon :rules="subFormRules" ref="subForm" label-width="100px">
        <el-form-item label="课程名称" prop="subjectName">
          <el-input v-model="subFormData.subjectName"></el-input>
        </el-form-item>
        <el-form-item label="课程课时" prop="classHour">
          <el-input v-model.number="subFormData.classHour"></el-input>
        </el-form-item>
        <el-form-item label="所属年级" prop="gradeId">
          <el-select v-model="subFormData.gradeId" placeholder="请选择年级">
            <el-option
              v-for="item in grades"
              :key="item.gradeId"
              :label="item.gradeName"
              :value="item.gradeId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <!-- 判断是显示添加还是修改按钮 -->
          <el-button v-if="subjectId>0" type="primary" @click="upSubject()">修改</el-button>
          <el-button v-else type="primary" @click="addSubject()">添加</el-button>
          <el-button @click="cancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-drawer>
</template>

<script>
  import axios from 'axios';
  export default {
    data() {
      // 验证课程名称
      var validateSubjectName = (rule, value, callback)=>{
        if(!value){
          return callback(new Error('课程名称不能为空'))
        }
        callback()  //验证成功
      }
      // 验证课程课时
      var validateClassHour = (rule, value, callback)=>{
        if(!value){
          return callback(new Error('课程课时不能为空'))
        }else if(!Number.isInteger(value)){
          return callback(new Error('课程课时必须为数字'))
        }
        callback()  //验证成功
      }
      // 验证课程年级
      var validatGradeId = (rule, value, callback)=>{
        if(value==0){
          return callback(new Error('请选择所属年级'))
        }
        callback()  //验证成功
      }
      return {
        // 编辑时，传过来的课程编号
        subjectId:0,
        // 年级数组
        grades:[],
        // 控制抽屉是否打开
        drawer:false,
        // 表单数据
        subFormData: {
          subjectId:'',
          subjectName:'',
          classHour:'',
          gradeId:0,
        },
        // 表单验证
        subFormRules: {
          // 验证课程名称
          subjectName: [
            { 
              // 指定验证方法
              validator: validateSubjectName, 
              // 指定触发方式，blur表示失去光标触发，change表示切换选项时触发
              trigger: 'blur' 
            }
          ],
          classHour: [
            { validator: validateClassHour, trigger: 'blur' }
          ],
          gradeId: [
            { validator: validatGradeId, trigger: 'change' }
          ]
        },
      }
    },
    methods:{
      // 加载年级数组
      async loadGrades(){
        let {data:{data}} = await axios.get('http://localhost:8081/grades')
        this.grades = data;
        this.grades.unshift({
          gradeId:0,
          gradeName:'请选择年级'
        })
      },
      // 修改课程
      upSubject(){
        // 修改之前先验证表单
        this.$refs.subForm.validate((valid)=>{
          if(valid){
            // 实现修改课程的业务
            axios.put('http://localhost:8081/subjects',this.subFormData)
            .then(({data:{code}})=>{
              if(code==1){
                this.$message({
                  message:'修改成功！',
                  type:'success',
                  showClose:true,
                })
                // 更新父组件中的课程列表
                this.$parent.loadSubjects();
              }else{
                this.$message({
                  message:'修改失败！',
                  type:'error',
                  showClose:true,
                })
              }
            })
          }else{
            return false;
          }
        })
      },
      // 添加课程
      addSubject(){
        // 添加之前先验证表单
        this.$refs.subForm.validate((valid)=>{
          if(valid){
            // 实现添加课程的业务
            axios.post('http://localhost:8081/subjects',this.subFormData)
            .then(({data:{code}})=>{
              if(code==1){
                this.$message({
                  message:'添加成功！',
                  type:'success',
                  showClose:true,
                })
                // 重置表单
                this.$refs.subForm.resetFields()
                // 更新父组件中的课程列表
                this.$parent.loadSubjects();
              }else{
                this.$message({
                  message:'添加失败！',
                  type:'error',
                  showClose:true,
                })
              }
            })
          }else{
            return false;
          }
        })
      },
      // 取消方法
      cancel(){
        // 重置表单
        this.$refs.subForm.resetFields()
      },
      // 抽屉关闭
      drawerClose(done){
        // 重置表单
        this.$refs.subForm.resetFields()
        // 编辑的课程编号重新设置为0
        this.subjectId = 0
        // 关闭抽屉
        done()
      },
    },
    watch:{
      // 监听课程编号
      subjectId(nval){
        if(nval!=0){
          // 根据传过来的课程编号，查询该课程信息
          axios.get('http://localhost:8081/subjects/'+nval).then(({data:{data}})=>{
            this.subFormData = data
          })
        }
      }
    },
    mounted() {
      this.loadGrades()   // 加载年级
    },
  }
</script>

<style>

</style>