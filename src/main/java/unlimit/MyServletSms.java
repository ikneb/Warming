package unlimit;


import Entity.Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServletSms")
public class MyServletSms extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static String name;
    public static String email;
    public static int number;
    public static String sms;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        name = request.getParameter("name");
        email = request.getParameter("email");
        number = Integer.parseInt(request.getParameter("number"));
        sms = request.getParameter("sms");


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("{\"number\":\"ok\"}");
        out.close();

        Main.sms();


    }
}