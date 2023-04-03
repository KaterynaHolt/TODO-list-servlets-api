package com.todolist.app.servlet;


import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import com.todolist.app.model.Item;


@WebServlet(name = "ToDoServlet", value = "/hello/")
public class ToDoServlet extends HttpServlet {
    private final ToDoStoreSingleton singletonStore = ToDoStoreSingleton.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        String id = request.getParameter("id");
        response.setContentType("text/html");
        System.out.println(id);
        System.out.println(operation);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<h1>Information about task</h1>");
        Optional<Map.Entry<String, Item>> foundElement = singletonStore.getItems().entrySet().stream()
                .filter(val -> val.getKey().equals(id)).findFirst();
        if(foundElement.isPresent()){
            printWriter.println("<p> Text - " + foundElement.get().getValue().getValue() + "</p>");
            printWriter.println("<p> Date - " + foundElement.get().getValue().getDate() + "</p>");
            printWriter.println("<p> Status - " + foundElement.get().getValue().getStatus() + "</p>");
            printWriter.println("<p> Priority - " + foundElement.get().getValue().getPriority() + "</p>");
            printWriter.println("<p> Tags - " + foundElement.get().getValue().getTags() + "</p>");
        }
        printWriter.println("<p> Task - was " + operation + "</p>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
