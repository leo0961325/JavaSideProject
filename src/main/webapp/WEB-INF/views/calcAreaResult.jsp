<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: M4610-1
  Date: 2021/8/29
  Time: 上午 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>計算面積結果</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 20px">

<% List<Map> list = (List) request.getAttribute("list"); %>
<% for (Map map : list) { %>
<%--//因為當初沒有給泛型，所以要toString--%>
    <% if (map.get("r").toString().equals("0")) continue;%>
    <form class="pure-form">
        <fieldset>
            <legend>計算<%=map.get("name")%>結果:</legend>
            半徑:<%=map.get("r")%> </p>
            結果:<%=map.get("result")%>
            <p>耶成功了</p>
            <br>
            <button type="button" class="pure-button pure-button-primary" onclick="goBack()">回上一頁</button>
        </fieldset>
    </form>
<% }%>
<script>
    function goBack() {
        window.history.back()
    }
</script>
</body>
</html>
