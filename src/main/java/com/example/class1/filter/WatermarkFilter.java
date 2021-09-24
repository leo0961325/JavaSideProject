package com.example.class1.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/secure/*")
public class WatermarkFilter extends HttpFilter {


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        //最初的建構值
        MyResponse myRes = new MyResponse(res);
        //原本的res無法取得 string html
        chain.doFilter(req,myRes);

        String html = myRes.getHTMLString();
        //路徑都對阿但不知道為什麼沒有
        String waterMark = "<body background=\"/WEB-INF/images/do_not_copy.png\"";
        html = html.replaceAll("<body",waterMark);

        res.getWriter().print(html);
    }
}
