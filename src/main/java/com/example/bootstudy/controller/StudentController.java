package com.example.bootstudy.controller;

import com.example.bootstudy.entity.Student;
import com.example.bootstudy.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * @author Zz
 */
@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping( value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        Student student = this.service.queryStudentBySno(sno);
        return student;
    }

    @RequestMapping( value = "/Testadd1", method = RequestMethod.GET)
    @Transactional
    public void Testadd1() throws Exception{
        Student student = new Student();
        student.setSno("004");
        student.setName("ddddd");
        student.setSex("S");
        try {
            this.service.add1(student);
        }catch (Exception e){
            log.error("触发事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @RequestMapping( value = "/Testadd2", method = RequestMethod.GET)
    @Transactional
    public void Testadd2() throws Exception{
        Student student = new Student();
        student.setSno("004");
        student.setName("ddddd");
        student.setSex("S");
        try {
            this.service.add2(student);
            int num = 100/0;
        }catch (Exception e){
            log.error("触发事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @RequestMapping( value = "/Testadd3", method = RequestMethod.GET)
    @Transactional
    public void Testadd3() throws Exception{
        Student student = new Student();
        student.setSno("005");
        student.setName("cccc");
        student.setSex("S");
        try {
            this.service.add1(student);
            this.service.add2(student);
//            int num = 100/0;
        }catch (Exception e){
            log.error("触发事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @RequestMapping( value = "/Testadd4", method = RequestMethod.GET)
    @Transactional
    public void Testadd4() throws Exception{
        Student student = new Student();
        student.setSno("005");
        student.setName("cccc");
        student.setSex("S");
        try {
            this.service.add1(student);
            this.service.add2(student);
            int num = 100/0;
        }catch (Exception e){
            log.error("触发事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
