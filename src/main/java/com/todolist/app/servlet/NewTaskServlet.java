package com.todolist.app.servlet;


import com.todolist.app.model.*;
import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "NewTaskServlet", value = "/new-task")
public class NewTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/new-task.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ToDoStoreSingleton singleton = ToDoStoreSingleton.getInstance();
        if(request.getParameter(ToDoListAppConstants.ADD_OPERATION) != null){
            String uuid = singleton.addItem(getItem(request));
            response.sendRedirect(request.getContextPath() + "/notification?operation="
                    + ToDoListAppConstants.ADD_OPERATION + "&id=" + uuid);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/see-all-tasks");
        }
    }

    /**
     *This method gets item from request
     * @param request - http request
     * @return item
     */
    private static Item getItem(HttpServletRequest request) {
        String text = request.getParameter("text");
        String date = request.getParameter("date");
        Status status = Status.valueOf(request.getParameter("status"));
        Priority priority = Priority.valueOf(request.getParameter("priority"));
        List<Tag> tags = new ArrayList<>();
        String[] strT = request.getParameterValues("tags");
        for (String t : strT){
            tags.add(Tag.valueOf(t));
        }
        Item item = new Item(text, date, status, priority, tags);
        return item;
    }


}
