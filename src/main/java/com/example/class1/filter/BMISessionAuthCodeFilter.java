package com.example.class1.filter;


import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebFilter("/bmi_session")
public class BMISessionAuthCodeFilter extends HttpFilter {



    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //如果是get請求，(就是頁面中的檢視就直接讓他走下去)
        if (req.getMethod().equalsIgnoreCase("get")){
            chain.doFilter(req,res);
        }
        //驗證授權碼
        String code = req.getParameter("code");

        HttpSession session = req.getSession();
        Object authCode = session.getAttribute("authCode");

        if(authCode != null && code.equals(authCode.toString())){
            //驗證完要變成空值，不然會殘留
            session.setAttribute("authCode",null);
            chain.doFilter(req,res);
        }else{
            //使用完就棄用
            session.invalidate();
            res.getWriter().println(code + " == " + authCode);
        }




    }
}
