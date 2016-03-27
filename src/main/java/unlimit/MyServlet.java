package unlimit;

import Entity.Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String name;
//	public static String email;
	public static int number;
	public static int quad;
	public static int thick;
	public static String material;
	public static String call;
	public static int density;




	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 name = request.getParameter("name");
//	    email = request.getParameter("email");
		 number = Integer.parseInt(request.getParameter("number"));
		 quad = Integer.parseInt(request.getParameter("quad"));
		thick = Integer.parseInt(request.getParameter("thick"));
		 material = request.getParameter("gridRadios");
		call = request.getParameter("call");
		density = Integer.parseInt(request.getParameter("density"));



		Main.recordDB();

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.println(Main.calkPrice());
		out.close();
	}

}
