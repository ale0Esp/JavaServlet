package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String ocupacion = request.getParameter("ocupacion");
        String genero = request.getParameter("genero");
        String musica[] = request.getParameterValues("musica");
        String comentarios = request.getParameter("comentarios");
        
        
        out.print("<html>");
        out.print("<head>");
        out.print("<title> resultado </title>");
        out.print("<body>");
        
        out.print("<h1> Parametros Procesados por el Servlet</h1>");
        out.print("<table border='1'>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(pass);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("tecnologias");
        out.print("</td>");
        out.print("<td>");
        for(String tecnologia: tecnologias){
            out.print(tecnologia);
            out.print(" / ");
        } 
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Genero");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupacion");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Musica");
        out.print("</td>");
        out.print("<td>");
        if(musica != null){
        for(String m: musica){
            out.print(m);
            out.print(" / ");
        } 
        }else{
            out.print("Musica no elegida");
        }
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("comentario");
        out.print("</td>");
        out.print("<td>");
        out.print(comentarios);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    } 
}
