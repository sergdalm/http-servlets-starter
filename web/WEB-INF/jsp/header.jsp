<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 20.04.2022
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${not empty sessionScope.user}">
        <%--        Префикс ссылки добавляется с помощью Cntrl+N--%>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">
                Logout
            </button>
        </form>
    </c:if>
</div>

