package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//servlet1
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//Collecting employee data from HTML
		String empName  = request.getParameter("ename");
		String empCity  = request.getParameter("ecity");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H2>" + "Hello " + empName + " you stay in " + empCity +"<H2>");
		//out.println("<BIG>Hello World</BIG>");
		 
		out.println("</BODY></HTML>");
		if(empName.equals("jyoti")&& empCity.equals("delhi")){
			RequestDispatcher rd = request.getRequestDispatcher("servlet2");
			rd.forward(request, response);
		}
		else
		{
			out.println("Ssorry UserName or City Error! Enter Again !!!");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}
}
