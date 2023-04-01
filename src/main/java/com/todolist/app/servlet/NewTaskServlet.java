package com.todolist.app.servlet;


import com.todolist.app.model.Item;
import com.todolist.app.model.Priority;
import com.todolist.app.model.Status;
import com.todolist.app.model.Tag;
import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "NewTaskServlet", value = "/NewTaskServlet")
public class NewTaskServlet extends HttpServlet {
    private Logger logger = LogManager.getLogger(NewTaskServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/jsp/new-task.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String date = request.getParameter("date");
        Status status = Status.valueOf(request.getParameter("status"));
        Priority priority = Priority.valueOf(request.getParameter("priority"));
        List<Tag> tags = new ArrayList<>();
        String[] strT = request.getParameterValues("tags");
        for (String t : strT){
            tags.add(Tag.valueOf(t));
        }
        Item item = new Item(text, date, status, priority, (ArrayList<Tag>) tags);
        ToDoStoreSingleton singleton = ToDoStoreSingleton.Instance();
        singleton.addItem(item);

        //singleton.saveToFile();

        //logger.info("Logger");

    }
}
