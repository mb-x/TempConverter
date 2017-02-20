package com.mb.tempconverter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.net.httpserver.Filter.Chain;

public class ClickCounterFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("ClickCounterFilter - destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("ClickCounterFilter - doFilter");
		
		ServletContext sc = req.getServletContext();
		int counter = (int) sc.getAttribute("counter");
		counter++;
		sc.setAttribute("counter", counter);
		System.out.println("ClickCounterFilter - "+sc.getAttribute("counter"));
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("ClickCounterFilter - init");
		int counter = 0;
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("counter", counter);
	}

}
