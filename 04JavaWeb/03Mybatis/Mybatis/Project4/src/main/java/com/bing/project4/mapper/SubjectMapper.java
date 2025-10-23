package com.bing.project4.mapper;

import com.bing.project4.pojo.Grade;
import com.bing.project4.pojo.Kecheng;
import com.bing.project4.pojo.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubjectMapper {

    //@Select注解定义查询SQL语句
    @Select("select * from subject")
    List<Subject> selectAllSubject();

    //当查询返回的结果跟实体类中定义的属性命名不相同时，需要自定义映射关系
    @Results({
            @Result(id = true,column = "subjectId",property = "id"),
            @Result(column = "subjectName",property = "name"),
            @Result(column = "classHour",property = "ks"),
            @Result(column = "gradeId",property = "nj")
    })
    @Select("select * from subject")
    List<Kecheng> selectAllKecheng();

    // 映射一对一关系
    @Results({
            // 字段名和属性名一个的可以省略定义映射关系
            /*@Result(id = true,column = "subjectId",property = "subjectId"),
            @Result(column = "subjectName",property = "subjectName"),
            @Result(column = "classHour",property = "classHour"),
            @Result(column = "gradeId",property = "gradeId"),*/
            @Result(column = "gradeId",property = "grade",
                    one = @One(select = "getGradeByGradeId")
            )
    })
    @Select("select * from subject")
    List<Subject> selectAllSubject2();
    @Select("select * from grade where gradeId=#{gradeId}")
    Grade getGradeByGradeId(int gradeId);

    // Mybatis默认是这样做的：1.调研无参构造方法创建Subject对象 2.在调用setXXX方法给属性赋值
    // 指定创建对象时，调用的构造函数，在创建对象时直接对属性赋值
    @ConstructorArgs({
            @Arg(column = "subjectId",javaType = int.class),
            @Arg(column = "subjectName",javaType = String.class)
    })
    @Select("select subjectId,subjectName from subject")
    List<Subject> selectAllSubject3();

    //@Insert注解定义插入SQL语句
    @Insert("insert into subject(subjectName,classHour,gradeId) " +
            "values(#{subjectName},#{classHour},#{gradeId})")
    int addSubject(Subject subject);

    //@Update注解定义更新SQL语句
    @Update("update subject set subjectName=#{subjectName},classHour=#{classHour}," +
            "gradeId=#{gradeId} where subjectId=#{subjectId}")
    int updateSubject(Subject subject);

    //两个以上的参数需要添加@Param定义参数名称
    //如果只有一个参数，而且是对象类型，它会自动映射出对象身上的属性的值
    //如果传了两个参数，其中一个参数是对象，此时就需要使用对象.属性的方式获取属性的值
    @Update("update subject set subjectName=#{subject.subjectName},classHour=#{subject.classHour}," +
            "gradeId=#{subject.gradeId} where subjectId=#{subjectId}")
    int updateSubject2(@Param("subjectId") int subjectId, @Param("subject") Subject subject);

    //@Delete注解定义删除SQL语句
    @Delete("delete from subject where subjectId=#{subjectId}")
    int delteSubject(int subjectId);
}
