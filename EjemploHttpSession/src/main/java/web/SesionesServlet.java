package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sesion = request.getSession();
        String titulo = null;
        //Pedir el atributo conadorvisitas
        Integer contadorVisitas = (Integer)sesion.getAttribute("contadorVisitas");
        //si es nulo es la primera vez que se accede
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        }else{
            contadorVisitas++;
            titulo = "bienvenido de nuevo";
        }
        //agrgeamos nuevo valor
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        PrintWriter out = response.getWriter();
        out.print("no. de accesos al recurso"+contadorVisitas);
        out.print("<br>");
        out.print("ID "+sesion.getId());
        out.close();
        
    }
}
