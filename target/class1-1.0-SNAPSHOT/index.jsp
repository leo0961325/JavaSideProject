<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.class1.service.Calc" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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


    <%
        Calc calc = new Calc();
        calc.setX(10);
        calc.setY(20);
        calc.getResult();
        out.print(calc.getResult());
    %>
<%-- jsp Action    id等同 於物件名稱   class=class--%>
    <jsp:useBean id="calc2" class="com.example.class1.service.Calc"></jsp:useBean>
    <%-- setProperty會自己呼叫 setter   --%>
    <jsp:setProperty name="calc2" property="x" value="20"></jsp:setProperty>
    <jsp:setProperty name="calc2" property="y" value="30"></jsp:setProperty>
    <%-- getProperty自己就會去呼叫 getResult()   --%>
    <jsp:getProperty name="calc2" property="result"/>

</ol>


</body>
</html>