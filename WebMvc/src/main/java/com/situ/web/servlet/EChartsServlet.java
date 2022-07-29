package com.situ.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.vo.BanjiCount;
import com.situ.web.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/echarts")
public class EChartsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<BanjiCount> list=new ArrayList<>();
        try {
            connection= JDBCUtil.getConnection();
            String sql="select b.name,COUNT(*) AS value\n" +
                    " from student as s inner join banji as b \n" +
                    "on s.banji_id=b.id\n" +
                    "group by b.id";
            statement=connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                String name=resultSet.getString(1);
                int value =resultSet.getInt(2);
                BanjiCount banjiCount=new BanjiCount(name,value);
                list.add(banjiCount);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        resp.setContentType("text/Html;charset=utf-8");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),list);
    }


}
