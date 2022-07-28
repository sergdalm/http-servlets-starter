<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 28.07.2022
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email"> Email
        <input type="text" name="email" id="email" value="${param.email}" required>
    </label> <br>
    <label for="password"> Password
        <input type="password" name="password" id="password" required>
    </label><br>
    <button type="submit">Submit</button>
    <%--    в реальных приложениях ссылки можно сделать с помощью CSS стилей в виду кнопки--%>
    <%--    мы тут просто внутри ссылки засунем кнопку--%>
    <a href="${pageContext.request.contextPath}/regitsration">
        <button type="button">Register</button>
    </a>
    <div>
        <c:if test="${param.error != null}">
            <div style="color: red">
                <span>Email or password is not correct</span>
            </div>
        </c:if>
    </div>

</form>
</body>
</html>
