import Mock from 'mockjs';
// mockjs提供了两大功能：生成随机数据 和 拦截ajax请求

// 年级数组
let grades = [
  {gradeId:1,gradeName:'大一'},
  {gradeId:2,gradeName:'大二'},
  {gradeId:3,gradeName:'大三'}
]
// 生成随机数据
let {subjects} = Mock.mock(
  {
    // 随机生成长度为10到20的数组
    "subjects|5-10":[
      {
        'subjectId|+1':1,
        subjectName:'@ctitle(10,15)',
        classHour:'@integer(33,66)',
        gradeId:'@integer(1,3)',
      }
    ]
  }
)
subjects.forEach(s=>{
  let grade = grades.find(g=>g.gradeId==s.gradeId)
  s.grade = grade;
})

// 拦截ajax请求
Mock.mock('http://192.168.1.2:8001/grades/list','get',(options)=>{
  return grades
})

Mock.mock('http://192.168.1.2:8001/subjects/list','get',(options)=>{
  // options中保存这请求的相关信息，比如请求体对象
  // console.log(options);
  return subjects
})

Mock.mock('http://192.168.1.2:8001/subjects/add','post',(options)=>{
  let subject = JSON.parse(options.body)
  subject.subjectId = subjects.length+1
  subject.grade = grades.find(g=>g.gradeId==subject.gradeId)
  subjects.push(subject)
  return {
    code:0,
    success:true,
    message:'添加成功'
  }
})
