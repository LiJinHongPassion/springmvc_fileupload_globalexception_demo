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
    <title>文件上传</title>
</head>
<body>


    <%--enctype  文件编码格式--%>


    <h1>上传文件</h1>
    <form method="post" action="<%=request.getContextPath() %>/form" enctype="multipart/form-data">
        <input type="text" name="name"/>
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>

    <p><a href="<%=path%>/testSimpleMappingExceptionResolver">SimpleMappingExceptionResolver</a></p>
    <p><a href="<%=path%>/testGlobalExceptionMapping">@ControllerAdvice + @ExceptionHandler</a></p>
    <p><a href="<%=path%>/testExceptionMapping">@ExceptionHandler</a></p>
    <p><a href="<%=path%>/testResponseStatusExceptionResolver">@ResponseStatus--标记在类</a></p>
    <p><a href="<%=path%>/testResponseStatusExceptionResolver1">@ResponseStatus--标记在方法</a></p>
    <%--测试404异常--%>
    <p><a href="<%=path%>/test.jsp"> <"error-page"> </a></p>
</body>
</html>
