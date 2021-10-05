package com.example.class1.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bmi_session_invalid")
public class BMISessionInvalid extends HelloHttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Get檢視就不建立新的SessionID，就使用剛剛post進來的
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        out.println("Session inValid , Session id : "+ session.getId());
        //使session失效，像是logout
        session.invalidate();

    }
}
