package unlimit;


import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServletPassword")
public class MyServletPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static String password;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        password = request.getParameter("password");

        if (password.equals("test")) {


            JSONObject resultJson = new JSONObject();

            resultJson.put("password", "yes"); //create json
            System.out.println(resultJson);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(resultJson);
            out.close();
        } else {
            JSONObject resultJson = new JSONObject();

            resultJson.put("password", "no"); //create json
            System.out.println(resultJson);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(resultJson);
            out.close();
        }


    }
}