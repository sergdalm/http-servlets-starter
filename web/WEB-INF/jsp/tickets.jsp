<%@ page import="com.sergdalm.http.service.TicketService" %>
<%@ page import="com.sergdalm.http.dto.TicketDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 18.04.2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ include file="index.html" %>--%>
<html>
<head>
    <title>Купленные билеты</title>
</head>
<body>
    <c:if test="${not empty requestScope.tickets}">
        <h1>Купленные билеты</h1>
        <ul>
            <c:forEach var="ticket" items="${requestScope.tickets}">
                <li>${fn:toLowerCase(ticket.seatNo)}</li>
            </c:forEach>
        </ul>
    </c:if>
</body>

</html>

