<%@ page import="com.todolist.app.model.Item" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>See all tasks</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/see-all-tasks.css">
    <link href='https://unpkg.com/css.gg@2.0.0/icons/css/more-o.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://unpkg.com/css.gg@2.0.0/icons/css/shape-circle.css' rel='stylesheet'>
</head>
<body>
<div class="see-all">
    <form action="<%= request.getContextPath() %>/see-all-tasks" method="post">
        <h2>You have <span style="color:#F32276"><%= request.getAttribute("count") %> task(s) </span> to do
        <button class="button" type="submit" name="ADD">Add new </button> </h2>
        <div class="incompleted">
            <label>On Hold</label>
        </div>
        <div class="table-incompleted">
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
                    <td><i class="gg-shape-circle" style="color: #c061cb; width: 9px; height: 9px; float: left;
                     margin-right: 10px; display: flex;justify-content: center; align-items: center;"></i>
                        <%= entry.getValue().getValue() %></td>
                    <td><%= entry.getValue().getDate() %></td>
                    <td><%= entry.getValue().getStatus() %></td>
                    <td><%= entry.getValue().getPriority() %></td>
                    <td><span style="color:#437CF5"><%= entry.getValue().showTags() %></span></td>
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
        <div class="table-completed">
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
                    <td><i class="gg-shape-circle" style="color: #c061cb; width: 9px; height: 9px; float: left;
                     margin-right: 10px; display: flex;justify-content: center; align-items: center;"></i>
                        <%= entrycom.getValue().getValue() %></td>
                    <td><%= entrycom.getValue().getDate() %></td>
                    <td><%= entrycom.getValue().getStatus() %></td>
                    <td><%= entrycom.getValue().getPriority() %></td>
                    <td><span style="color:#437CF5"><%= entrycom.getValue().showTags() %></span></td>
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
