package com.situ.spring.controller;

import com.situ.spring.pojo.Student;
import com.situ.spring.service.IStudentService;

import java.util.List;

public class StudentController {
//    private IStudentService studentService=new StudentServiceImpl();
   private IStudentService studentService;

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    public void selectAll(){
        System.out.println("StudentController.selectAll");
       studentService.selectAll();

    }
}

