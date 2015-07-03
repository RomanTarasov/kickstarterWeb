package ua.goit.web;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;

import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Quote;
import ua.goit.web.model.dao.memory.MDao;
import ua.goit.web.servlet.DispatcherServlet;

@RunWith(MockitoJUnitRunner.class)
public class databaseTest extends Mockito {
	ApplicationContext app;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	 private Map attributes;
	@Before
	public void setUp() {
		attributes = new HashMap();
		app = new ClassPathXmlApplicationContext("application-context.xml");
		when(request.getRequestURI()).thenReturn("/kickstarterWeb/main");
		when(request.getContextPath()).thenReturn("/kickstarterWeb");
		RequestDispatcher rd = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		

	}

	@Test
	public void test() {
		DispatcherServlet servlet = (DispatcherServlet) app
				.getBean("dispatcherServlet");
		MDao mdao = (MDao) app.getBean("memoryDao");
		servlet.setMemoryDao(mdao);
		try {
			servlet.doGet(request, response);
	

		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
