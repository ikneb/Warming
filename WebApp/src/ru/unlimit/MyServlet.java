package ru.unlimit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int number = Integer.parseInt(request.getParameter("number"));
		int quad = Integer.parseInt(request.getParameter("quad"));
		int thick = Integer.parseInt(request.getParameter("thick"));
		String material = request.getParameter("gridRadios");
		String call = request.getParameter("call");

		System.out.println(name + " " + email + " " + number + " " + quad + " " + thick + " " + material + " " + call);

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.println();
		out.close();
	}

}
