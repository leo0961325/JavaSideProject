package com.example.class1.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebFilter("/secure/*")
public class LoginFilter extends HttpFilter {

    private  static Map<String,String> users = new LinkedHashMap<>();

    static {
        users.put(":john","1234");
        users.put(":mary","5678");
        users.put(":jean","0000");
        users.put(":admin","9999");

    }
    //覆寫

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean check = false;
        check = users.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(username) &&
                        e.getValue().equals(password))
                .findAny()
                .isPresent();

        System.out.println(check); //false
        if (!check) {
            chain.doFilter(req, res);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
            if (!(username == null && password ==null)){
                req.setAttribute("errorMsg","登入錯誤");
            }
            rd.forward(req, res);
        }
    }
}
