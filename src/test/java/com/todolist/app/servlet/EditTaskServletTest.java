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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class EditTaskServletTest {
    @Spy
    private EditTaskServlet servlet;
    @Mock
    private ServletConfig servletConfig;
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
    @Test
    public void test_doGet_method() throws ServletException, IOException {
        //WHEN
        when(request.getRequestDispatcher("/jsp/edit-task.jsp")).thenReturn(rd);
        servlet.doGet(request, response);
        //THEN
        verify(rd).forward(request, response);
    }
}
