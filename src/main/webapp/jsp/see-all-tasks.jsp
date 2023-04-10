<%@ page import="com.todolist.app.model.Item" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>See all tasks</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/see-all-tasks.css">
    <link href='https://unpkg.com/css.gg@2.0.0/icons/css/more-o.css' rel='stylesheet'>
</head>
<body>
<div class="seeall">
    <form action="<%= request.getContextPath() %>/see-all-tasks" method="post">
        <h2>You have <%= request.getAttribute("count") %> task(s) to do
        <button class="button" type="submit" name="ADD">Add new </button> </h2>
        <div class="incompleted">
            <label>On Hold</label>
        </div>
        <div class="tableincompleted">
            <table>
                <thead>
                <tr>
                    <th>Text</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Tags</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% Map<String, Item> onhold = (Map<String, Item>) request.getAttribute("onhold");
                for(Map.Entry<String, Item> entry : onhold.entrySet()){ %>
                <tr>
                    <td><%= entry.getValue().getValue() %></td>
                    <td><%= entry.getValue().getDate() %></td>
                    <td><%= entry.getValue().getStatus() %></td>
                    <td><%= entry.getValue().getPriority() %></td>
                    <td><%= entry.getValue().getTags().toString() %></td>
                    <td>
                        <div class="dropdown">
                            <button class="dropbtn"><i class="gg-more-o"></i></button>
                            <div class="dropdown-content">
                                <a href="<%= request.getContextPath() %>/notification?operation=COMPLETE&id=
<%=entry.getKey()%>">Complete</a>
                                <a href="<%= request.getContextPath() %>/notification?operation=EDIT&id=
<%=entry.getKey()%>">Edit</a>
                                <a href="<%= request.getContextPath() %>/notification?operation=REMOVE&id=
<%=entry.getKey()%>">Remove</a>
                            </div>
                        </div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
        <div class="completed">
        <label>Completed <label id="inactive">Inactive</label></label>
        </div>
        <div class="tablecompleted">
            <table>
                <thead>
                <tr>
                    <th>Text</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Tags</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% Map<String, Item> completed = (Map<String, Item>) request.getAttribute("completed");
                    for(Map.Entry<String, Item> entrycom : completed.entrySet()){ %>
                <tr>
                    <td><%= entrycom.getValue().getValue() %></td>
                    <td><%= entrycom.getValue().getDate() %></td>
                    <td><%= entrycom.getValue().getStatus() %></td>
                    <td><%= entrycom.getValue().getPriority() %></td>
                    <td><%= entrycom.getValue().getTags().toString() %></td>
                    <td>
                        <div class="dropdown">
                            <button class="dropbtn"><i class="gg-more-o"></i></button>
                            <div class="dropdown-content">
                                <a href="<%= request.getContextPath() %>/notification?operation=INCOMPLETE&id=
<%=entrycom.getKey()%>">Incomplete</a>
                                <a href="<%= request.getContextPath() %>/notification?operation=REMOVE&id=
<%=entrycom.getKey()%>">Remove</a>
                            </div>
                        </div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </form>
</div>
</body>
</html>
