package com.situ.MyBatis.test;

import com.situ.MyBatis.pojo.Banji;
import com.situ.MyBatis.pojo.Student;
import com.situ.MyBatis.pojo.StudentBanjiVO;
import com.situ.MyBatis.utiil.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MyBatisTest {

    @Test
    public void testSelectById() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建 SqlSessionFactory    Session:会话 (连接数据库后就建立了一次会话，有了会话就可以操作数据库)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行Sql语句
        Student student = sqlSession.selectOne("selectById", 4);
        System.out.println(student);
    }

    @Test
    public void testSelectById2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = sqlSession.selectOne("selectById", 4);
        System.out.println(student);
    }

    @Test
    public void testSelectAll(){
        SqlSession session=MyBatisUtil.getSqlSession();
            List<Student> list=session.selectList("selectAll");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testDeleteById(){
        SqlSession session=MyBatisUtil.getSqlSession();
        int count=session.delete("deleteById",2);
        System.out.println(count);
        session.commit();
        session. close();

    }

@Test
    public void testUpdate(){
        SqlSession session=MyBatisUtil.getSqlSession();
        Map map=new HashMap();
        map.put("name","王二");
        map.put("id",11);
       int count= session.update("updateById",map);
    System.out.println(count);
        session.commit();
        session.close();
}

@Test
    public void add(){
        SqlSession session=MyBatisUtil.getSqlSession();
        Student student=new Student();
        student.setName("123");
        student.setAge(555);
        student.setGender("难");
        student.setBanjiId(1);
        int count=session.insert("add",student);
    System.out.println(count);
    session.commit();
    session.close();
}
@Test
    public void textSelectByPage(){
        SqlSession session=MyBatisUtil.getSqlSession();
        int pageNo =2;
        int pageSize=3;
        int offset=(pageNo-1)*pageSize;
        Map<String, Object> map=new HashMap<>();
    map.put("offset",offset);
    map.put("pageSize",pageSize);
    List<Student> list=session.selectList("selectByPage",map);
    for (Student student : list) {
        System.out.println(student);

    }
    session.commit();
    session.close();

}

@Test
    public void testSelectTotalCount(){
        SqlSession session=MyBatisUtil.getSqlSession();
        int count=session.selectOne("selectTotalCount");
    System.out.println(count);
    }

    @Test
    public void testSelectStudentBanjiInfo(){
        SqlSession session=MyBatisUtil.getSqlSession();
        List<Student> list=session.selectList("selectStudentBanjiInfo");
        for (Student student : list) {
            System.out.println(student);
        }
    }
@Test
    public void testSelectStudentBanjiInfo1(){
        SqlSession session=MyBatisUtil.getSqlSession();
        List<StudentBanjiVO> list=session.selectList("selectStudentBanjiInfo1");
    for (StudentBanjiVO studentBanjiVO : list) {
        System.out.println(studentBanjiVO);
    }
}

    @Test
    public void testSelectBanjiStudentInfo() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Banji> list = sqlSession.selectList("selectBanjiStudentInfo");
        for (Banji banji : list) {
            System.out.println(banji);
            List<Student> studentList = banji.getList();
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    @Test
    public void testselectByCondition() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student stu = new Student();
        stu.setName("王");
        stu.setAge(13);
        List<Student> list = sqlSession.selectList("selectByCondition", stu);
        for (Student student : list) {
            System.out.println(student);
        }
    }
    @Test
    public void testUpdateCondition() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = new Student();
        student.setId(4);
        // student.setName("Admin2");
        student.setAge(25);
        student.setGender("n");
        int count = sqlSession.update("updateCondition", student);
        System.out.println(count);
        sqlSession.commit();
    }


    @Test
    public void testDeleteAllByArray() {
        int[] array = {13,12};
        SqlSession sqlSession = MyBatisUtil.getSqlSession();;
        int count = sqlSession.update("deleteAllByArray", array);
        System.out.println("count: " + count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteAllByList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(10);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int count = sqlSession.update("deleteAllByList", list);
        System.out.println("count: " + count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition() {
        Student stu = new Student();
        stu.setName("王");
        stu.setAge(23);
        stu.setGender("女");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> list = sqlSession.selectList("selectByCondition1", stu);
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
