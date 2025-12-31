<template>
  <div class="eight">
    <h2>课程信息</h2>
    <table>
      <thead>
        <tr>
          <th>课程编号</th>
          <th>课程名称</th>
          <th>课时课时</th>
          <th>所属年级</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item) in subjects" :key="item.subjectId">
          <td>{{item.subjectId}}</td>
          <td>{{item.subjectName}}</td>
          <td>{{item.classHour}}</td>
          <td>{{item.grade.gradeName}}</td>
        </tr>
      </tbody>
    </table>
    <table>
      <tr>
        <td>课程名称：</td>
        <td><input type="text" v-model="subject.subjectName"></td>
      </tr>
      <tr>
        <td>课程课时：</td>
        <td><input type="text" v-model="subject.classHour"></td>
      </tr>
      <tr>
        <td>所属年级：</td>
        <td>
          <select v-model="subject.gradeId">
            <option v-for="(item) in grades" 
            :key="item.gradeId" :value="item.gradeId">{{item.gradeName}}</option>
          </select>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button @click="addSubject">添加</button>
          <button>取消</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  data(){
    return {
      // 年级数组
      grades:[],
      // 课程数组
      subjects:[],
      // 课程对象
      subject:{
        subjectName:'',
        classHour:'',
        gradeId:''
      }
    }
  },
  methods: {
    // 加载年级信息的方法
    loadGrades(){
      this.$axios.get('http://192.168.1.2:8001/grades/list').then(({data})=>{
        this.grades = data;
      })
    },
    // 加载课程信息的方法
    loadSubjecs(){
      // 查询课程信息
      this.$axios.get('http://192.168.1.2:8001/subjects/list').then(({data})=>{
        this.subjects = data;
      })
    },
    // 添加课程
    addSubject(){
      this.$axios.post('http://192.168.1.2:8001/subjects/add',this.subject)
      .then(({data})=>{
        if(data.code==0){
          alert(data.message)
          this.loadSubjecs()
        }
      })
    }
  },
  mounted() {
    this.loadGrades()
    this.loadSubjecs()
  },
}
</script>

<style lang="scss" scoped>
.eight{
  border: 1px solid #ddd;
  padding: 10px;
}
</style>