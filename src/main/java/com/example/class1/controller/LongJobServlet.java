package com.example.class1.controller;

import com.example.class1.job.LongJob;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(value = "/longjob" , asyncSupported = true)
public class
LongJobServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print("進入 Servlet 的時間" + new Date() + "<p/>");
        out.flush();

        //longJob
        AsyncContext ctx = req.startAsync();
        LongJob longJob = new LongJob(ctx);
        Thread t = new Thread(longJob);
        t.start();

        out.print("離開 Servlet 的時間" + new Date() + "<p/>");


    }
}
