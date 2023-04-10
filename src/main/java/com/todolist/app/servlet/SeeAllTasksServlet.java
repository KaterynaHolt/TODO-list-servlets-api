package com.todolist.app.servlet;

import com.todolist.app.model.Item;
import com.todolist.app.model.Status;
import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


@WebServlet(name = "SeeAllTasksServlet", value = "/see-all-tasks")
public class SeeAllTasksServlet extends HttpServlet {
    static ToDoStoreSingleton singleton = ToDoStoreSingleton.getInstance();

    static {
        singleton.getExample();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Item> onhold = new LinkedHashMap<>();
        Map<String, Item> completed = new LinkedHashMap<>();
        for(Map.Entry<String, Item> entry : singleton.getItems().entrySet()){
            if(!entry.getValue().getStatus().equals(Status.COMPLETED)){
                onhold.put(entry.getKey(), entry.getValue());
            }
            else {
                completed.put(entry.getKey(), entry.getValue());
            }
        }
        int count = onhold.size();
        request.setAttribute("count", count);
        request.setAttribute("onhold", onhold);
        request.setAttribute("completed", completed);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/see-all-tasks.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("ADD") != null){
            response.sendRedirect(request.getContextPath() + "/new-task");
        }
    }
}
