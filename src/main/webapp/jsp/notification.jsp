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
<%
    ToDoStoreSingleton singletonStore = ToDoStoreSingleton.getInstance();
    String operation = request.getParameter("operation");
    String id = request.getParameter("id");
    System.out.println(id);
    System.out.println(operation);
    PrintWriter printWriter = response.getWriter();
    printWriter.println("<h1>Information about task</h1>");
    Optional<Map.Entry<String, Item>> foundElement = singletonStore.getItems().entrySet().stream()
            .filter(val -> val.getKey().equals(id)).findFirst();
    if(foundElement.isPresent()){
        printWriter.println("<p> Text - " + foundElement.get().getValue().getValue() + "</p>");
        printWriter.println("<p> Date - " + foundElement.get().getValue().getDate() + "</p>");
        printWriter.println("<p> Status - " + foundElement.get().getValue().getStatus() + "</p>");
        printWriter.println("<p> Priority - " + foundElement.get().getValue().getPriority() + "</p>");
        printWriter.println("<p> Tags - " + foundElement.get().getValue().getTags() + "</p>");
        printWriter.println("<p> Task - was " + operation + "</p>");
    }
    else{
        printWriter.println("<p> No task has been found. Check your logs </p>");
    }
    printWriter.close();
%>
</body>
</html>
