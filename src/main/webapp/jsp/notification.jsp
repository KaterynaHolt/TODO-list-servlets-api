<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.todolist.app.model.Item" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.todolist.app.service.ToDoStoreSingleton" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notification</title>
</head>
<body>
<h1>Information about task</h1></h1>
<%  ToDoStoreSingleton singletonStore = ToDoStoreSingleton.getInstance();
    String id = (String) request.getAttribute("id");
    String operation = (String) request.getAttribute("operation");
    System.out.println(id);
    System.out.println(operation);
    Optional<Map.Entry<String, Item>> foundElement = singletonStore.getItems().entrySet().stream()
            .filter(val -> val.getKey().equals(id)).findFirst();
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
