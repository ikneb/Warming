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
	public static String email;
	public static int number;
	public static int quad;
	public static int thick;
	public static String material;
	public static String call;




	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 name = request.getParameter("name");
//		String email = request.getParameter("email");
		 number = Integer.parseInt(request.getParameter("number"));
		 quad = Integer.parseInt(request.getParameter("quad"));
//		int thick = Integer.parseInt(request.getParameter("thick"));
//		String material = request.getParameter("gridRadios");
//		String call = request.getParameter("call");

		System.out.println(name + " " + number + " " + quad );
		Main main = new Main();
		main.recordDB();

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.println();
		out.close();
	}

}
