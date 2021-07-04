package com.example.bootstudy.mapper;

import com.example.bootstudy.aop.datasource.DataSource;
import com.example.bootstudy.aop.datasource.DataSourceConstants;
import com.example.bootstudy.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zz
 */
@Mapper
public interface StudentMapper {
    int add(Student student);
    int update(Student student);
    int deleteByIds(String sno);

//    @DataSource(name = DataSourceConstants.testTwo)
    Student queryStudentById(@Param(value = "sno") String id);

//    @DataSource(name = DataSourceConstants.testOne)
    Student queryStudentByIdOne(@Param(value = "sno") String id);
}
