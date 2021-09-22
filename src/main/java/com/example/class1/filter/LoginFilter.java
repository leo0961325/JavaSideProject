package com.example.class1.filter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
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
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean check = false;
        check = users.entrySet()
                        .stream()
                        .filter(e -> e.getKey().equals(username) &&
                                e.getValue().equals(password))
                        .findAny()
                        .isPresent();

        if(check){
            chain.doFilter(req,res);
        }else {
            res.getWriter().print("Please login");
        }




    }
}
