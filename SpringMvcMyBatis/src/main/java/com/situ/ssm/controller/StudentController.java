package com.situ.ssm.controller;

import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.service.impl.StudentServiceImpl;
import com.situ.ssm.util.LayUITableJSONResult;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    IStudentService studentService=new StudentServiceImpl();
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Student> selectAll(){
        List<Student> list = studentService.selectAll();
        return list;
    }
    @RequestMapping("/selectByPage")
    @ResponseBody
//    @RequestParam(value = "page",defaultValue="1")
//    @RequestParam(value = "pageSize",defaultValue = "10")
    public LayUITableJSONResult selectByPage( Integer page, Integer limit){
        System.out.println("StudentController.selectByPage");
        LayUITableJSONResult layUITableJSONResult = studentService.selectByPage(page,limit);
        return layUITableJSONResult;
}
@RequestMapping("/deleteById")
    @ResponseBody
    public LayUITableJSONResult deleteById(Integer id){
    System.out.println("StudentController.deleteById");

        int count =studentService.deleteById(id);
        if(count>0){
            return LayUITableJSONResult.ok("删除成功");
        }else {
            return LayUITableJSONResult.error("删除失败");
        }
}

    @RequestMapping("/deleteAll")
    @ResponseBody
//    @RequestParam(required = false)
//    @RequestBody
    public LayUITableJSONResult deleteAll(  @RequestParam(value="ids[]")  String[] ids){
    System.out.println("StudentController.deleteAll");
    for (String id : ids) {
        System.out.println(id);
    }

        int count=studentService.deleteAll(ids);
        if(count>0){
            return LayUITableJSONResult.ok("删除成功");
        }else {
            return LayUITableJSONResult.error("删除失败");

        }

    }

    @RequestMapping("/insertStudent")
    @ResponseBody
    public LayUITableJSONResult insertStudent(Student student){
        System.out.println("StudentController.insertStudent");

        System.out.println(student);
        int count=studentService.insertStudent(student);
        System.out.println(count);
        if(count>0){
            return LayUITableJSONResult.ok("添加成功");
        }else {
            return LayUITableJSONResult.error("添加失败");
        }

    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public LayUITableJSONResult updateStudent(Student student,Integer id){
        System.out.println("StudentController.updateStudent");
        System.out.println(student);
        System.out.println(id);
        Map<String,Object> map=new HashMap<>();

        String name=student.getName();
        Integer age=student.getAge();
        String gender=student.getGender();

        map.put("name",name);
        map.put("age",age);
        map.put("gender",gender);
        map.put("id",id);
        int count =studentService.updateStudent(map);
        if(count>0){
            return LayUITableJSONResult.ok("修改成功");
        }else {
            return LayUITableJSONResult.error("修改失败");

        }
    }
}

