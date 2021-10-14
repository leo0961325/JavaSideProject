<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" uri="http://my.scwcd" %>
<%@taglib prefix="myself" uri="http://mytldd.com" %>
    <html>
        <head>
    <title>Title</title>
    </head>
    <body>
    <h1><my:required/></h1>
    <h2><my:greet user="leo ${1+2}"></my:greet></h2>
    <h1><my:if condition="<%= new Date().getTime() % 2 == 0%>"></my:if>
        現在時間 : <%= new Date()%>
    </h1>
    <h1><my:loop count="3">
    JAVA
    </my:loop></h1>
    <hr/>
    <my:mark search="s">
    she sell sea shore on the sea shore
    </my:mark>
    <hr/>

    <h1><my:implicit attributeName="authCode" scopeName="session"/></h1>

    <h1><my:switch conditionValue="3">
            <my:case caseValue="1">
                男生
            </my:case>
            <my:case caseValue="2">
                女生
            </my:case>
            <my:default>
                錯誤
            </my:default>
        </my:switch>
       </h1>

    <h1><myself:hello/></h1>

    <h1><myself:welcome username="John">
            現在時刻: <%=new Date()%>
        </myself:welcome></h1>

    <h1><myself:BMITag height="190" weight="60" result="true"></myself:BMITag> </h1>
    
    <h1>
        <myself:exchange symbol="USDTWD=x"></myself:exchange>
    </h1>

    <h1>
        <myself:exchange symbol="TWDUSD=x"></myself:exchange>
    </h1>
    
    
    </body>
    </html>
