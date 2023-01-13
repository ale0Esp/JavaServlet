package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException{
        //simulando valores;
        String userOk = "juan";
        String passOk= "123";
        
        String user = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        PrintWriter out= response.getWriter();
        if(userOk.equals(user) && passOk.equals(pass)){
            out.print("<h1>Datos ok<h1>");
            out.print("<h2><br>user="+user);
            out.print("<br>pass="+pass+"</h2>");
        }else{
            response.sendError(response.SC_UNAUTHORIZED,"Credenciales erroneos");
        }
    }
}
