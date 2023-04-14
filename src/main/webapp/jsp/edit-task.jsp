<%@ page import="com.todolist.app.model.Item" %>
<%@ page import="com.todolist.app.model.Tag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit task</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/edit-task.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/js/newtask.js"></script>
</head>
<body>
<div class="edittask">
    <% Item item = (Item) request.getAttribute("item");
        String uuid = (String) request.getAttribute("uuid");
        session.setAttribute("uuid", String.valueOf(uuid));%>
    <form action="<%= request.getContextPath() %>/edit-task" method="post">
        <h2 class="main-text">Edit task</h2>
        <div class="form-group">
            <label class="text">Text <br>
                <input type="text" class="textbox" name="text" value="<%= "  " + item.getValue().trim()%>" />
            </label>
        </div>
        <div class="form-group">
            <label class="text">Due date <br>
                <input type="date" class="textbox" name="date" value="<%=item.getDate()%>" />
            </label>
        </div>
        <div class="form-group">
            <label class="text">Status</label> <br>
            <select class="select" name="status">
                <option value="<%= item.getStatus().toString().toUpperCase(java.util.Locale.ROOT)%>"
                        hidden="hidden"><%= item.getStatus()%></option>
                <option value="INPROGRESS">Inprogress</option>
                <option value="PENDING">Pending</option>
                <option value="COMPLETED">Completed</option>
                <option value="INCOMPLETED">Incompleted</option>
            </select>
        </div>
        <div class="form-group">
            <label class="text-priority">Priority</label> <br>
            <select class="select" name="priority">
                <option value="<%= item.getPriority().toString().toUpperCase(java.util.Locale.ROOT)%>"
                        hidden="hidden"><%= item.getPriority()%></option>
                <option value="MINOR">Minor</option>
                <option value="CRITICAL">Critical</option>
                <option value="NORMAL">Normal</option>
            </select>
        </div>
        <div class="form-group">
            <label class="text">Tags</label> <br>
            <select class="select-mult" name="tags" multiple="true">
                <%  Tag[] tags = Tag.values();
                    for(Tag t : tags){
                        if(item.getTags().contains(t)){ %>
                    <option value="<%= t.toString().toUpperCase(java.util.Locale.ROOT)%>" selected><%= t%></option>
                    <% }
                        else { %>
                    <option value="<%= t.toString().toUpperCase(java.util.Locale.ROOT)%>"><%= t%></option>
                    <% }
                    } %>
            </select>
        </div>
        <div class="form-group">
            <button class="edit" type="submit" name="EDIT">Edit</button>
            <button class="cancel" type="submit" name="CANCEL">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
