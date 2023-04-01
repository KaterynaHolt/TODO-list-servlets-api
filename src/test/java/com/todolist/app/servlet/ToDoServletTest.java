package com.todolist.app.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.io.PrintWriter;
import static org.mockito.Mockito.*;


public class ToDoServletTest {
    @Spy
    private ToDoServlet servlet;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private PrintWriter printWriter;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * This method tests printing "Hello world TODO list!"
     * @throws IOException
     * @throws ServletException
     */
    @Test
    public void test_printing_hello_world() throws IOException, ServletException {
        //WHEN
        when(servlet.getServletConfig()).thenReturn(servletConfig);
        when(response.getWriter()).thenReturn(printWriter);
        servlet.doGet(request, response);
        //THEN
        verify(printWriter).write("Hello world TODO list!");
    }
}

