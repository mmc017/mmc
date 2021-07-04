package com.example.bootstudy.service;

import com.example.bootstudy.aop.datasource.DataSource;
import com.example.bootstudy.aop.datasource.DataSourceConstants;
import com.example.bootstudy.config.SpringContextUtil;
import com.example.bootstudy.entity.Student;
import com.example.bootstudy.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zz
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

//    @Autowired
//    private StudentService service;


    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentMapper.deleteByIds(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        StudentService service = (StudentService) SpringContextUtil.getBean(this.getClass());
        Student student = service.queryStudentBySno1(sno);
        Student student1 = service.queryStudentBySno2(sno);
        return student;
    }

    @Override
    @DataSource(name = DataSourceConstants.testOne)
    public Student queryStudentBySno1(String sno){
        Student student = studentMapper.queryStudentByIdOne(sno);
        return student;
    }

    @Override
    @DataSource(name = DataSourceConstants.testTwo)
    public Student queryStudentBySno2(String sno){
        Student student = studentMapper.queryStudentById(sno);
        return student;
    }

    @Override
    @DataSource(name = DataSourceConstants.testOne)
    public void add1(Student student){
        this.studentMapper.add(student);
    }

    @Override
    @DataSource(name = DataSourceConstants.testTwo)
    public void add2(Student student){
        this.studentMapper.add(student);
    }
}
