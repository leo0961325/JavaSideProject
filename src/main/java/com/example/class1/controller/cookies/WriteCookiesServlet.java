package com.example.class1.controller.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/cookies/write")
public class WriteCookiesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salary = req.getParameter("salary");
        String age = req.getParameter("age");

        //建立Cookies
        Cookie cookieSalary = new Cookie("salary",salary+"" );
        Cookie cookieAge = new Cookie("age",age+"" );
        //設定續存時間
        cookieSalary.setMaxAge(100);
        cookieAge.setMaxAge(100);
        //將cookie寫入client端
        resp.addCookie(cookieSalary);
        resp.addCookie(cookieAge);

        resp.getWriter().println("Write cookie OK !");

    }
}