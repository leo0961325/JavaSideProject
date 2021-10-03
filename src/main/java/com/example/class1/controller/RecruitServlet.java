package com.example.class1.controller;


import com.example.class1.vo.Person;
import com.github.javafaker.Faker;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/recruit")
public class RecruitServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //form表單的amount
        int amount = Integer.parseInt(req.getParameter("amount"));

        List<Person> list = new ArrayList<>();

        Faker faker = new Faker();
        Random random = new Random();
        //amount有幾個就產生幾個隨機人數
        for (int i = 0 ; i < amount ; i++){
            Person person =new Person(faker.name().name(),
                                      random.nextInt(100)%2==0?"男":"女",
                                      random.nextInt(101));
            list.add(person);
        }
        req.setAttribute("list",list);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/recruit_result.jsp");
        rd.forward(req,resp);
    }
}
