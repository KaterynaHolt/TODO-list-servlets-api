package com.todolist.app.servlet;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "ToDoServlet", value = "/notification/")
public class ToDoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("operation", request.getParameter("operation"));
        request.setAttribute("id", request.getParameter("id"));
        request.getRequestDispatcher("/jsp/notification.jsp").forward(request, response);
    }
}