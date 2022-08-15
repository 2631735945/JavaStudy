package com.situ.mvc.controller;


import com.situ.mvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    //${pageContext.request.contextPath}/student/add.action

    @RequestMapping("/add1")
    public void add1(String name,Integer age,String gender){
        System.out.println("StudentController.add");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("gender: " + gender);
        Student student = new Student(name, age, gender);
        System.out.println(student);

    }

    @RequestMapping("/add2")
    public ModelAndView add2(Student student){
        System.out.println("StudentController.add");
        System.out.println(student);
        //        Model:数据  View:界面
        ModelAndView modelAndView=new ModelAndView();
        //request.setAttribute("student", student);
        modelAndView.addObject("student",student);
        //request.getRequestDispatcher("student_info.jsp").forword(request, response);

        modelAndView.setViewName("student_info");
        return modelAndView;

    }

//    默认情况下既支持GET请求，也支持POST请求
//    @RequestMapping(value="/add",method= {RequestMethod.POST,RequestMethod.GET})
//    @RequestMapping(value="/add",method= {RequestMethod.POST})
    @RequestMapping(value="/add3",method= RequestMethod.POST)
    public String add3(Student student, Model model){
        System.out.println("StudentController.add");
        System.out.println(student);
        //        Model:数据  View:界面

        model.addAttribute("student",student);

        return "student_info";

    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("StudentController.add");
        // String[] ids = request.getParameterValues("ids[]");
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String gender=request.getParameter("gender");
        Student student=new Student(name,Integer.parseInt(age),gender);
        request.setAttribute("student",student);
        request.getRequestDispatcher("student_info.jsp").forward(request,response);

    }



    @RequestMapping("/deleteAll")
    public void delete(Integer[] ids){
        for (Integer id : ids) {
            System.out.println(id);
        }
    }


    @RequestMapping("/selectAll")
    public String selectAll(Model model){
        System.out.println("StudentController.selectAll");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "zhangsan1", 23, "男"));
        list.add(new Student(2, "zhangsan2", 23, "男"));
        list.add(new Student(3, "zhangsan3", 23, "男"));
        model.addAttribute("list", list);

        return "student_list";

    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        System.out.println("StudentController.deleteById");
        System.out.println("id:"+id);

        // response.sendRedirect("/JavaSpringMVC/student/selectAll.action");
        return "redirect:/student/selectAll.action";
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Student> select(){
        System.out.println("StudentController.select");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "zhangsan1", 23, "男"));
        list.add(new Student(2, "zhangsan2", 23, "男"));
        list.add(new Student(3, "zhangsan3", 23, "男"));

        return list;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Student selectById() {
        System.out.println("StudentController.selectById");
        Student student = new Student(1, "lisi", 23, "男");

        return student;
    }

    @RequestMapping("/selectByPage")
    public void selectByPage(@RequestParam(value = "pageN", defaultValue = "1") Integer pageNo,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             @RequestParam(required = true) Integer totalPage) {
        /*if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }*/
        System.out.println("pageNo: " + pageNo);
        System.out.println("pageSize: " + pageSize);
    }



}
