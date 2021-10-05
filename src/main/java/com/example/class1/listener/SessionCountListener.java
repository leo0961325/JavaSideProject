package com.example.class1.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCountListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //建立count全域
        ServletContext context = se.getSession().getServletContext();
        if (context.getAttribute("count")==null){
            context.setAttribute("count",0);
        }
        int count = Integer.parseInt(context.getAttribute("count").toString());
        count++;
        context.setAttribute("count",count);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        //如果沒有session人數就直接return
        if (context.getAttribute("count")==null){
            return;
        }
        int count = Integer.parseInt(context.getAttribute("count").toString());
        count--;
        context.setAttribute("count",count);



    }
}
