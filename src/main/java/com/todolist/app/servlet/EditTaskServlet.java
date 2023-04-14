package com.todolist.app.servlet;

import com.todolist.app.model.*;
import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditTaskServlet", value = "/edit-task")
public class EditTaskServlet extends HttpServlet {

    ToDoStoreSingleton singleton = ToDoStoreSingleton.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("id");
        request.setAttribute("uuid", uuid);
        request.getRequestDispatcher("/jsp/edit-task.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uuid = (String) session.getAttribute("uuid");
        if(request.getParameter(ToDoListAppConstants.EDIT_OPERATION) != null){

            singleton.changeItem(uuid, getItem(request));
            response.sendRedirect(request.getContextPath() + "/notification?operation=EDIT&id=" + uuid);
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
