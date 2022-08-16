package com.situ.ssm.controller;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Student> selectAll(){
        System.out.println("StudentController.selectAll");
        List<Student> list = studentService.selectAll();
        return list;

    }

}
