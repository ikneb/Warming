package unlimit;

import Entity.Main;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;


@WebServlet("/MyServlet")
public class MyServlet extends HttpsServer {
    private static final long serialVersionUID = 1L;
    public static String name;
    //	public static String email;
    public static int number;
    public static int quad;
    public static int thick;
    public static String material;
    public static String call;
    public static int density;
    public static double price;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        name = request.getParameter("name");
        number = Integer.parseInt(request.getParameter("number"));
        quad = Integer.parseInt(request.getParameter("quad"));
        thick = Integer.parseInt(request.getParameter("thick"));
        material = request.getParameter("gridRadios");
        call = request.getParameter("call");
        density = Integer.parseInt(request.getParameter("density"));

        Main main = new Main();
        price = Main.calkPrice();

        JSONObject resultJson = new JSONObject();

        resultJson.put("price",price); //create json

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(resultJson);
        out.close();

        main.recordDB();

    }

    @Override
    public void setHttpsConfigurator(HttpsConfigurator httpsConfigurator) {

    }

    @Override
    public HttpsConfigurator getHttpsConfigurator() {
        return null;
    }

    @Override
    public void bind(InetSocketAddress inetSocketAddress, int i) throws IOException {

    }

    @Override
    public void start() {

    }

    @Override
    public void setExecutor(Executor executor) {

    }

    @Override
    public Executor getExecutor() {
        return null;
    }

    @Override
    public void stop(int i) {

    }

    @Override
    public HttpContext createContext(String s, HttpHandler httpHandler) {
        return null;
    }

    @Override
    public HttpContext createContext(String s) {
        return null;
    }

    @Override
    public void removeContext(String s) throws IllegalArgumentException {

    }

    @Override
    public void removeContext(HttpContext httpContext) {

    }

    @Override
    public InetSocketAddress getAddress() {
        return null;
    }
}
