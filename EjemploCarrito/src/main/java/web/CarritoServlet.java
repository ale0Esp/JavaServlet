package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Creamos o recuperamos el objeto de la sesiones
        HttpSession sesion = request.getSession();
        
        //recuperamios lista de articulos
        List <String> articulos= (List <String>) sesion.getAttribute("Articulos");
        
        ///Verificamos si la lista de articulos existe
        if(articulos==null){
            articulos = new ArrayList<>();
            sesion.setAttribute("Articulos", articulos);           
        }
        //Procesar articulo
        String articuloNuevo = request.getParameter("articulo");
        
        //revisasmos y agregamos articulos nuevos
        if(articuloNuevo != null && !articuloNuevo.trim().equals("")){
            articulos.add(articuloNuevo);
        }
        
        try (PrintWriter out = response.getWriter()) 
        {
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br>");
            //iterar articulos
            for(String articulo: articulos){
                out.print("<li>"+articulo+"</li>");
            }
            out.print("<br>");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al incio</a>");
        }
                
    }
}
