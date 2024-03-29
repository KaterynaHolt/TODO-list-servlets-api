package com.todolist.app.servlet;

import com.todolist.app.model.Item;
import com.todolist.app.model.Priority;
import com.todolist.app.model.Status;
import com.todolist.app.model.Tag;
import com.todolist.app.service.ToDoStoreSingleton;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;


public class EditTaskServletTest {
    @Spy
    private EditTaskServlet servlet;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    RequestDispatcher rd;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * This method tests doGet method of EditTaskServlet
     * @throws ServletException
     * @throws IOException
     */
    @Test
    public void test_doGet_method() throws ServletException, IOException {
        //GIVEN
        String uuid = UUID.randomUUID().toString();
        //WHEN
        when(request.getParameter("id")).thenReturn(uuid);
        when(request.getRequestDispatcher("/jsp/edit-task.jsp")).thenReturn(rd);
        doNothing().when(request).setAttribute("uuid", uuid);

        servlet.doGet(request, response);
        //THEN
        verify(request).getParameter("id");
        verify(request).setAttribute("uuid", uuid);
        verify(rd).forward(request, response);
    }
}
