<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 21.04.2022
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Список перелётов</title>
</head>
<body>
    <h1>Список перелётов</h1>
    <ul>
        <c:forEach var="flight" items="${requestScope.flights}">
            <li><a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}"> ${flight.description}</a></li>
        </c:forEach>
    </ul>
<%--printWriter.write("<ul>");--%>
<%--    flightService.findAll().forEach(flightDto -> printWriter.write(--%>
<%--    """--%>
<%--    <li>--%>
<%--        <a href ="/tickets?flightId=%d">%s</a>--%>
<%--    </li>--%>
<%--    """.formatted(flightDto.getId(), flightDto.getDescription())));--%>
<%--    printWriter.write("</ul>");--%>
</body>
</html>
