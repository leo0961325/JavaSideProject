<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.class1.service.Calc" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page errorPage="error_page.jsp" %>
<%--Jstl使用要載入的標籤庫，核心標籤--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<h3>JAVA WEB程式列表 2021/08/27</h3>
<ol>
    <li><a href="http://localhost:8080/on-deploy/generic?name=leo">GenericServlet</a></li>
    <li><a href="http://localhost:8080/on-deploy/helloServlet?name=mikoduck">HelloHttpServlet</a></li>
</ol>
<h3>JAVA WEB程式列表 2021/08/28</h3>
<ol>
    <li><a href="http://localhost:8080/on-deploy/HelloNewServlet">HelloNewServlet(利用@部屬servlet)</a></li>
    <a href="#" onclick="alert('有空在做')">原始碼</a>
    <li><a href=""></a></li>
</ol>

<form class="pure-form" method="post" action="http://localhost:8080/on-deploy/recruit">
    <fieldset>
        <legend>招募</legend>
        <input type="number" placeholder="請輸入人數:" name="amount"/>
        <button type="submit" class="pure-button pure-button-primary">Submit</button>
    </fieldset>
</form>

<form class="pure-form"
      method="post" action="http://localhost:8080/on-deploy/bmi_session">
    <fieldset>
        <legend>BMI(Session版本) 使用人數 : ${applicationScope.count} 人</legend>
        <input name="cname" type="text" placeholder="姓名" value="王小名"><p />
        <input name="height" type="text" placeholder="身高" value="170"><p />
        <input name="weight" type="text" placeholder="體重" value="60"><p />

        <button type="submit" class="pure-button pure-button-primary">傳送</button>
        <button type="button"
                onclick="location.href='http://localhost:8080/on-deploy/bmi_session'"
                class="pure-button pure-button-primary">檢視</button>
        <button type="button"
                onclick="location.href='http://localhost:8080/on-deploy/bmi_session_invalid'"
                class="pure-button pure-button-primary">刪除Session</button>
    </fieldset>
</form>

</body>
</html>