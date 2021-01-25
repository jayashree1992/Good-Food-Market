package com.neu.edu.webtools.project.handlingexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class ManagingExceptions {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Oops! The page is not constructed.");
		
		mv.addObject("errorDescription","Oops! We can't seem to find the page you are looking for.");
		
		mv.addObject("pageTitle", "404 error page");
		
		return mv;
		
	}
	
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ModelAndView itemNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Item is not available.");
		
		mv.addObject("errorDescription","Oops! The item you are looking for is not available");
		
		mv.addObject("pageTitle", "404 error - Item Unavailable");
		
		return mv;
		
	}
	

}



