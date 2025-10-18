package com.bing.service.impl;

import com.bing.dao.IGradeDao;
import com.bing.dao.IStudentDao;
import com.bing.dao.impl.GradeDao;
import com.bing.dao.impl.StudentDao;
import com.bing.pojo.Grade;
import com.bing.pojo.Student;
import com.bing.service.IStudentService;

import java.util.List;

/**
 * 学生业务逻辑类
 */
public class StudentService implements IStudentService {
    // 创建学生数据访问层对象
    IStudentDao studentDao = new StudentDao();
    // 创建年级数据访问层对象
    IGradeDao gradeDao = new GradeDao();

    @Override
    public int insertStudent(Student student) {
        return 0;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }

    @Override
    public int deleteStudent(String studentNo) {
        return 0;
    }

    @Override
    public List<Student> selectAll() {
        // 业务逻辑层如果没有业务要处理，就直接将数据访问层的结果返回
        List<Student> students = studentDao.selectAll();
        List<Grade> grades = gradeDao.selectAll();
        // 遍历学生集合，给每个学生对象添加年级对象
        students.forEach(s->{
            Grade grade = grades.stream().filter(g->g.getGradeId()==s.getGradeId())
                    .findFirst().get();
            s.setGrade(grade);
        });
        return students;
    }

    @Override
    public List<Student> selectByGrade(int gradeId) {
        return null;
    }

    @Override
    public List<Student> selectByName(String studentName) {
        return null;
    }

    @Override
    public List<Student> selectByGradeAndName(int gradeId, String studentName) {
        return null;
    }
}
