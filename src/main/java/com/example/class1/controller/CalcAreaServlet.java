package com.example.class1.controller;


import com.example.class1.service.CalcAreaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/CalcArea") //urlPattern
public class CalcAreaServlet extends HttpServlet {

    //類似Autowired 把 service import進來
    private CalcAreaService calcAreaService = new CalcAreaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Sorry method is get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收單筆參數
        //String string_type = req.getParameter("type");
        //String string_r = req.getParameter("r"); //對應html name=r
        //int type = Integer.parseInt(string_type);
        //int r = Integer.parseInt(string_r);

        //1.接收多組參數(多重複名稱,type=1&r=10&type=1&r=10type=1&r=10)
         String[] types = req.getParameterValues("type");
         String[] rs = req.getParameterValues("r");

        //2.商業邏輯運算
        //double area = calcAreaService.getAreaResult(type,r);
        //String typeName = calcAreaService.getNameByType(type);

        List<Map> list = calcAreaService.getAreaResults(types,rs);
        //3.建立分派器給view 與jsp位置
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/calcAreaResult.jsp");
        //3.1 新增/設定 request 屬性，傳遞給jsp頁面使用
        //3.1 這裡set給jsp get
//        req.setAttribute("r",r);
//        req.setAttribute("result" , String.format("%.2f",area));
//        req.setAttribute("typeName" ,typeName);

        req.setAttribute("list",list);
        //3.2傳送
        rd.forward(req,resp);

        //一開始測試有沒有成功
        resp.getWriter().print("\ndoPost OK");

    }

}
