package com.example.class1.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 利用@ 配置servlet name = class Name比較好   urlPatterns = url path

//http://localhost:8080/on-deploy/otherPath
//http://localhost:8080/on-deploy//HelloNewServlet
@WebServlet(name = "HelloNewServlet" ,
        urlPatterns = {"/HelloNewServlet","/otherPath","/hello.asp"})
public class HelloNewServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("HelloNewServlet " + new Date());
    }
}
