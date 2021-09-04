<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<%--拿到的 getAttribute 是obj 所以要 toString--%>
<%
 String sno =  request.getAttribute("sno").toString();
 String eno =  request.getAttribute("eno").toString();
 String time =  request.getAttribute("time").toString();
 String payString =  request.getAttribute("pay").toString();
 Boolean pay = Boolean.parseBoolean(payString);
 String memo =  request.getAttribute("memo").toString();
%>
<head>
    <title>計算面積結果</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 20px">

<form class="pure-form">
    <fieldset>
        <legend style="color: #005100">註冊結果:</legend>
        學員編號 : <%=sno%> <p/>
        認證代號 : <%=eno%><p/>
        考試時段 : <%=time%><p/>
        繳費狀況 : <%=(pay)? "已繳費" : "未繳費"%><p/>
        備註資料 : <%=memo%><p/>
        <br>
        <button type="button" class="pure-button pure-button-primary" onclick="goBack()">回上一頁</button>
    </fieldset>
</form>
<script>
    function goBack() {
        window.history.back()
    }
</script>
</body>
</html>
