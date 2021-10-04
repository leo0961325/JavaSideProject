package com.example.class1.controller.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookies/read")
public class ReadCookiesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        if(cookies != null){
            for (Cookie cookie : cookies){
                out.println(cookie.getName()+":"+cookie.getValue());
            }
        }else {
            out.println("No cookies");
        }

        resp.getWriter().println("Write cookie OK !");

    }
}
