<%@ page import="com.sergdalm.http.service.TicketService" %>
<%@ page import="com.sergdalm.http.dto.TicketDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 18.04.2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Купленные билеты на самолёт</h1>
    <ul>
    </ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDto> tickets = TicketService.getInstance().findByFlightId(flightId);
        for(TicketDto ticket: tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
        }
    %>
</body>
</html>

<%!
    public void jspInit() {
        System.out.println("Hello world!");
    }
%>
