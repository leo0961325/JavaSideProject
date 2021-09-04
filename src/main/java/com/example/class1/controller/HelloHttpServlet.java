package com.example.class1.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//請求資訊如，路徑在tomcat http://localhost:8080/on-deploy/?name=Java
//到web.xml去配置url pattern


public class HelloHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //servletRequest 表示收到client

        String name = req.getParameter("name");


        System.out.printf("Hi %s %s\n",name,new Date());
        //servletResponse 表示要回應給client端的內容
        PrintWriter out =  resp.getWriter(); //透過out可以將訊息回傳給client
        out.println("Hello"); //把訊息寫在HTTP Response part4內容裡
        out.println(name);
        out.println(" " + new Date());
        out.close();

    }
}
