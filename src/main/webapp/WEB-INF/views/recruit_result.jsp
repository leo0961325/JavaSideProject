<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Jstl使用要載入的標籤庫，核心標籤--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>招聘結果</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 20px">

<form class="pure-form">
    <fieldset>
        <legend>招聘結果:</legend>
        總人數 : ${ fn:length(list)}
        <p/>
        <table class="pure-table pure-table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Sex</th>
                <th>Score</th>
                <th>Pass</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="amount" value="0"></c:set>
            <c:forEach var="person" items="${list}" varStatus="item" >
            <tr>
                <%-- varStatus 每一個都是 1個item--%>
                <td>${item.index +1 }</td>
                <td>${person.name}</td>
                <td>${person.sex}</td>
                <td>${person.score}</td>
                <%--      if test 裡面是 Boolean值回傳true or false --%>
                <td>
                    <c:if test="${person.score >= 60}">
                        <c:out value="Pass"></c:out>
<%--                        每一次pass amount都+1--%>
                        <c:set var="amount" value="${amount+1}"></c:set>
                    </c:if>
                </td>
            </tr>
            </c:forEach>

            </tbody>
        </table>
        <p/>
        錄取人數:${amount}
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
