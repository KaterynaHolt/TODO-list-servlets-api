package com.todolist.app.servlet;

import com.todolist.app.model.ToDoListAppConstants;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.IOException;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class NotificationServletTest {
    @Spy
    private NotificationServlet servlet;
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
     * This method tests doGet method of NotificationServlet
     * @throws ServletException
     * @throws IOException
     */
    @Test
    public void test_doGet_method() throws ServletException, IOException {
        //GIVEN
        String uuid = UUID.randomUUID().toString();
        String operation = ToDoListAppConstants.ADD_OPERATION;
        //WHEN
        when(request.getParameter("id")).thenReturn(uuid);
        when(request.getParameter("operation")).thenReturn(operation);
        when(request.getRequestDispatcher("/jsp/notification.jsp")).thenReturn(rd);
        doNothing().when(request).setAttribute("operation", operation);

        servlet.doGet(request, response);
        //THEN
        verify(request).getParameter("id");
        verify(request).getParameter("operation");
        verify(request).setAttribute("operation", operation);
        verify(rd).forward(request, response);
    }
}
