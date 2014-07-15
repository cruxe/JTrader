package com.app4j.tradeobserver.spring.web.hello;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app4j.tradeobserver.HelloSpring;
import com.app4j.tradeobserver.spring.web.AbstractDispatcherServletTest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/* 3.1.1 ������ �ǳ� 3.2.1�� �ȵ�*/
public class SimpleHelloControllerTest extends AbstractDispatcherServletTest{
	@Test
	public void helloController() throws ServletException, IOException {
		ModelAndView mav = setLocations("WEB-INF/spring/appServlet/servlet-context.xml")
										.setClasses(HelloSpring.class)
										.initRequest("/hello", RequestMethod.GET)
										.addParameter("name", "Spring")
										.runService()
										.getModelAndView();
		
		assertThat(mav.getViewName(), is("hello"));
		assertThat((String)mav.getModel().get("message"), is("Hello Spring"));
	}

}
