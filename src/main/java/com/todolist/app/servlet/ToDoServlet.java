package com.todolist.app.servlet;


import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import com.todolist.app.model.Item;


@WebServlet(name = "ToDoServlet", value = "/hello")
public class ToDoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("Hello world TODO list!");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ToDoStoreSingleton singleton = ToDoStoreSingleton.Instance();
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Information about task</h1>");
        /*for (Map.Entry<String, Item> tasks : singleton.getItems().entrySet()) {
            printWriter.print("<p> Text - " + tasks.getValue().getValue() + "</p>");
            printWriter.print("<p> Date - " + tasks.getValue().getDate() + "</p>");
            printWriter.print("<p> Status - " + tasks.getValue().getStatus() + "</p>");
            printWriter.print("<p> Priority - " + tasks.getValue().getPriority() + "</p>");
            printWriter.print("<p> Tags - " + tasks.getValue().getTags() + "</p>");
        }
        printWriter.print("<p> Task - " + response.toString() + "</p>");*/
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }
}
