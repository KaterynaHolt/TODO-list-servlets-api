package com.todolist.app.servlet;

import com.todolist.app.model.Item;
import com.todolist.app.model.Priority;
import com.todolist.app.model.Status;
import com.todolist.app.model.Tag;
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
import java.util.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class SeeAllTasksServletTest {
    @Spy
    private SeeAllTasksServlet servlet;
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
     * This method tests doGet method of SeeAllTaskServlet
     * @throws ServletException
     * @throws IOException
     */
    @Test
    public void test_doGet_method() throws ServletException, IOException {
        //WHEN
        when(request.getRequestDispatcher("/jsp/see-all-tasks.jsp")).thenReturn(rd);
        servlet.doGet(request, response);
        //THEN
        verify(rd).forward(request, response);
    }
}
