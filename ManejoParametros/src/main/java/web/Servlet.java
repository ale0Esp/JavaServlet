package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{ 
    @Override
    protected void doPost(HttpServletRequest requets, HttpServletResponse response) throws IOException{
        //Leer parametros del formulario html
        String usuario = requets.getParameter("usuario");
        String pass = requets.getParameter("pass");
        
        System.out.println("user = " + usuario);
        System.out.println("pass = " + pass);
        
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("El parametro usuario es:"+usuario);
        out.print("<br/>");
        out.print("el parametro password es: "+pass);
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
