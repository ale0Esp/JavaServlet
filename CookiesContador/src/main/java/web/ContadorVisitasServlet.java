package web;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //declara variable
        int contador=0;
        
        //Revisamos si existe la cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("ContadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        //Incrementar contador
        contador++;
        //Se agrega a la respuesta del navegador
        Cookie c = new Cookie("ContadorVisitas",Integer.toString(contador));
        //cookie se almacena en el cliente por una hora
        c.setMaxAge(3600);
        response.addCookie(c);
        //Mandamos mensaje al navegador
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas de cada cliente"+contador);
        
    }
}
