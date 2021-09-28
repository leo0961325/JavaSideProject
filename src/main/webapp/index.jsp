<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        out.print(sdf.format(now));
    %>

</ol>


</body>
</html>