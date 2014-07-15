package com.app4j.tradeobserver;

import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Handles requests for the application home page.
 */
public class HelloController implements Controller{
	@Autowired HelloSpring helloSpring;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String name = req.getParameter("name");
		
		String message = this.helloSpring.sayHello(name);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("message", message);
		
		return new ModelAndView("hello", model);
		
	}

}