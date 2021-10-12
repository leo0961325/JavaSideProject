package com.example.class1.controller;


import com.example.class1.controller.utils.Util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 * 這支API是產生驗證碼用的
 */
@WebServlet("/authcode")
public class AuthCodeServlet extends HelloHttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        String authCode = String.format("%04d", new Random().nextInt(10000));
        //放到session裡面給BMISessionAuthCodeFilter使用
        HttpSession session = req.getSession();
        session.setAttribute("authCode", authCode);

        ImageIO.write(Util.getAuthImg(authCode), "JPEG", resp.getOutputStream());
    }

}
