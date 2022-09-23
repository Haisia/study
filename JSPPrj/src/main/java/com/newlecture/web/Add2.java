package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		String[] num_ = request.getParameterValues("num");
		
		int result = 0;
		
		for(int i=0; i<num_.length; i++) {
			result += Integer.parseInt(num_[i]);
		}
		
//		if(!x_.equals("")) {
//			x = Integer.parseInt(x_);
//		}
//		if(!y_.equals("")) {
//			y = Integer.parseInt(y_);
//		}
//		
		out.println(result);
	}
}
