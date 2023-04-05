<%@ page import="java.util.Map" %>
<%@ page import="com.todolist.app.model.Item" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notification</title>
</head>
<body>
<h1>Information about task</h1></h1>
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
<p> No task has been found. Check your logs </p>
<% } %>
</body>
</html>
