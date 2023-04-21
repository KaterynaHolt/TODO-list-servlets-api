package com.todolist.app.servlet;

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
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class NewTaskServletTest {
    @Spy
    private NewTaskServlet servlet;
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
     * This method tests doGet method of NewTaskServlet
     * @throws ServletException
     * @throws IOException
     */
    @Test
    public void test_doGet_method() throws ServletException, IOException {
        //WHEN
        when(request.getRequestDispatcher("/jsp/new-task.jsp")).thenReturn(rd);
        servlet.doGet(request, response);
        //THEN
        verify(rd).forward(request, response);
    }
}
