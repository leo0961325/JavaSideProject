package com.example.class1.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/bmi_session")
public class BMISessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //req.getSession(); 默認為true
        HttpSession session = req.getSession();
        String cname = req.getParameter("cname");
        Double height = Double.parseDouble(req.getParameter("height"));
        Double weight = Double.parseDouble(req.getParameter("weight"));
        Double bmi = weight / Math.pow(height/100.0,2);

        //將資料存入到 Session
        session.setAttribute("cname",cname);
        session.setAttribute("height",height);
        session.setAttribute("weight",weight);
        session.setAttribute("bmi",bmi);

        PrintWriter out = resp.getWriter();
        out.println("Post OK");
        out.println("Session Id : " + session.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //Get檢視就不建立新的SessionID，就使用剛剛post進來的
        HttpSession session = req.getSession(false);

        PrintWriter out = resp.getWriter();
        out.println("Get OK");
        out.println("Session Id : " + session.getId());
        out.println("cname : " + session.getAttribute("cname"));
        out.println("height : " + session.getAttribute("height"));
        out.println("weight : " + session.getAttribute("weight"));
        out.println("bmi : " + session.getAttribute("bmi"));

    }
}
