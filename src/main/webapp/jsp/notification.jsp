<%@ page import="java.util.Map" %>
<%@ page import="com.todolist.app.model.Item" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notification</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/notification.css">
</head>
<body>
<div class="notification">
    <form action="<%= request.getContextPath() %>/notification" method="post">
        <h2>Information about task</h2>
        <%  String operation = (String) request.getAttribute("operation");
            Optional<Map.Entry<String, Item>> foundElement = (Optional<Map.Entry<String, Item>>) request.getAttribute("result");
            if(foundElement.isPresent()){ %>
        <p> Text - <%= foundElement.get().getValue().getValue() %></p>
        <p> Date - <%= foundElement.get().getValue().getDate() %></p>
        <p> Status - <%= foundElement.get().getValue().getStatus() %></p>
        <p> Priority - <%= foundElement.get().getValue().getPriority() %></p>
        <p> Tags - <%= foundElement.get().getValue().getTags() %></p>
        <p> Task - was <%= operation %></p>
        <%  }
        else{ %>
        <p> No task has been found.Maybe it was removed. Check your logs </p>
        <% } %>
        <button class="button" type="submit" name="RETURN">Return</button>
    </form>
</div>
</body>
</html>
