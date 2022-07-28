<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 21.04.2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/images/users/360040899SUN_IMAGE.png" alt="User image">
<%--enctype="multipart/form-data"--%>
<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
    <label for="name"> Name:
        <%--            атрибут id используется для JS, для добавления стилей и при тестировании--%>
        <%--            на сервере мы этот атрибут никак использовать не можем--%>
        <%--            тут мы их используем только как best practice--%>
        <input type="text" name="name" id="name">
    </label><br>
    <label for="birthday"> Birthday:
        <%--            атрибут required следит чтобы значение было обязательно введено--%>
        <%--            иначе запрос не будет отправлен на сервер--%>
        <input type="date" name="birthday" id="birthday" required>
    </label><br>
    <label for="imageId"> Image:
        <input type="file" name="image" id="imageId">
    </label><br>
    <label for="email"> Email:
        <input type="text" name="email" id="email">
    </label><br>
    <label for="passwordId"> Password:
        <input type="password" name="password" id="passwordId">
    </label><br>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select>
    <br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value="${gender}">${gender}
        <br>
    </c:forEach>
    <button type="submit">Send</button>

    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">

            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span>
                <br>
            </c:forEach>
        </div>
    </c:if>
</form>
</body>
</html>
