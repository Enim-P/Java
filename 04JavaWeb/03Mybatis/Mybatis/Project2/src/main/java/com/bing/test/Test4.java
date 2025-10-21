package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

// 映射成Map类型
public class Test4 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            List<Map> maps = subjectMapper.selectAllSubject2();
            maps.forEach(map->{
                System.out.println(map);
                map.keySet().forEach(key->{
                    System.out.println(key+" : "+map.get(key));
                });
            });
        }
    }
}
