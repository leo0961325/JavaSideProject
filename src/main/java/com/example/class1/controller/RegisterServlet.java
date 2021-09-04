package com.example.class1.controller;


import com.example.class1.service.RegisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private RegisterService registerService = new RegisterService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //sno , eno , time(多選) , pay , memo
        String sno = req.getParameter("sno");
        String eno = req.getParameter("eno");
        List<Integer> time = Stream.of(req.getParameterValues("time"))
                                    .map(t -> Integer.parseInt(t))
                                    .collect(toList());

        //因為value 是 true or false
        Boolean pay = Boolean.parseBoolean(req.getParameter("pay"));
        String memo = req.getParameter("memo");

        //分派器:
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registerResult.jsp");
        //配置參數
        req.setAttribute("sno", sno);
        req.setAttribute("eno", eno);
        req.setAttribute("time", registerService.getTimeNamesById(time));
        req.setAttribute("pay", pay);
        req.setAttribute("memo", memo);

        //分派
        rd.forward(req, resp);
    }
}
