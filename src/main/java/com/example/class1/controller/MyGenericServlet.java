package com.example.class1.controller;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//請求資訊如，路徑在tomcat http://localhost:8080/on-deploy/?name=Java
//到web.xml去配置url pattern

public class MyGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //servletRequest 表示收到client

        String name = servletRequest.getParameter("name");


        System.out.printf("Hi %s %s\n",name,new Date());
        //servletResponse 表示要回應給client端的內容
        PrintWriter out =  servletResponse.getWriter(); //透過out可以將訊息回傳給client
        out.println(""); //把訊息寫在HTTP Response part4內容裡
        out.println(name);
        out.println(" " + new Date());
        out.close();

    }
}
