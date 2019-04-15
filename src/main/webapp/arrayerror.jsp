<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 2019/4/15
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>错误页面</title>
</head>
<body>

    <h1>@ControllerAdvice + @ExceptionHandler--------错误页面</h1>
</body>
</html>
