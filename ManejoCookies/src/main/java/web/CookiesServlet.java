package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //ussuario por primera vez
        boolean userNew=true;
        
        //Obtenemos arreglo ccookies
        Cookie[] cookies= request.getCookies();
        //biscamos si existe una coockie
        //visitante recurrente
        if(cookies!=null){
            for(Cookie c: cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    //ususrio si ha visitafo
                    userNew=false;
                    break;
                }
            }
            
        }
        String mensaje = "";
        if(userNew){
            Cookie visitante = new Cookie("visitanteRecurrente","si");
            response.addCookie(visitante);
            mensaje = "Gracias por visitar nuestro sitio";
        }else{
            mensaje="Bienvenido de nuevo";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: "+mensaje);
        out.close();
    }
    
}
