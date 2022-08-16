package com.situ.spring.service.impl;

import com.situ.spring.dao.ICourseDao;
import com.situ.spring.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*<bean name="studentService" class="com.situ.spring.service.impl.StudentServiceImpl">
    <property name="studentDao" ref="studentDao"/>
</bean>*/
@Service("courseService")
public class CourseServiceImpl implements ICourseService {

    //  <property name="studentDao" ref="studentDao"/>
    // @Resource：从Spring容器中根据名字拿出指定的对象注入进来
    @Resource(name = "courseDao")
    private ICourseDao courseDao;

    @Override
    public void selectAll() {
        long begin = System.currentTimeMillis();
        System.out.println("CourseServiceImpl.selectAll");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //courseDao.selectAll();
        long end = System.currentTimeMillis();
        long takeTime=end-begin;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CourseServiceImpl.deleteById");
    }
}
