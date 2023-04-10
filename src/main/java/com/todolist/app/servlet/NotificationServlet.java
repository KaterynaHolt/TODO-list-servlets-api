package com.todolist.app.servlet;


import com.todolist.app.model.Item;
import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@WebServlet(name = "ToDoServlet", value = "/notification")
public class NotificationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ToDoStoreSingleton singletonStore = ToDoStoreSingleton.getInstance();
        String id = request.getParameter("id");
        String operation = request.getParameter("operation");
        System.out.println(id);
        System.out.println(operation);
        Optional<Map.Entry<String, Item>> foundElement = singletonStore.getItems().entrySet().stream()
                .filter(val -> val.getKey().equals(id)).findFirst();
        request.setAttribute("operation", operation);
        request.setAttribute("result", foundElement);
        request.getRequestDispatcher("/jsp/notification.jsp").forward(request, response);
    }
}