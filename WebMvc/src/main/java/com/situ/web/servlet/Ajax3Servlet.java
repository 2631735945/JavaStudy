package com.situ.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.Area;
import com.situ.web.pojo.City;
import com.situ.web.pojo.Province;
import com.situ.web.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ajax3")
public class Ajax3Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String method=req.getParameter("method");
     switch (method){
         case "selectProvince":
             selectProvince(req,resp);
             break;
         case  "selectCity":
             selectCity(req,resp);
             break;
         case "selectArea":
             selectArea(req,resp);
             break;
         default:
             System.out.println("Ajax3Servlet.default");
             break;
     }
    }

    private void selectArea(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Ajax3Servlet.selectArea");
        String cityId=req.getParameter("cityId");
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        List<Area> list=new ArrayList<>();
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,area,city_id from tm_area where city_id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(cityId));
            System.out.println(statement);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String area=resultSet.getString(2);
                int city_id=resultSet.getInt(3);
                Area area1=new Area(id,area,city_id);
                list.add(area1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        resp.setContentType("text/Html;charset=utf-8");
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(resp.getWriter(),list);
    }

    private void selectCity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Ajax3Servlet.selectCity");
        String provinceId=req.getParameter("provinceId");
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<City> list=new ArrayList<>();
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,city,province_id from tm_city where province_id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(provinceId));
            System.out.println(statement);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String city=resultSet.getString("city");
                int province_id=resultSet.getInt("province_id");
                City city1=new City(id,city,province_id);
                list.add(city1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }

            resp.setContentType("text/Html;charset=utf-8");
            ObjectMapper mapper=new ObjectMapper();
            mapper.writeValue(resp.getWriter(),list);

    }

    private void selectProvince(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Ajax3Servlet.selectProvince");
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Province> list=new ArrayList<>();
        try {
            connection= JDBCUtil.getConnection();
            String sql="select id,province from tm_province";
            statement=connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String province=resultSet.getString("province");
                Province province1=new Province(id,province);
                list.add(province1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper=new ObjectMapper() ;
        objectMapper.writeValue(resp.getWriter(),list);
    }
}
