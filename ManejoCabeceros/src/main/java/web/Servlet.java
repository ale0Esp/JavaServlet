package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String metodoHttp = request.getMethod();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Headers http</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>headers http</h1>");
        out.print("<br>");
        out.print("metodo http: "+ metodoHttp);
        String uri= request.getRequestURI();
        out.print("<br>");
        out.print("metodo uri: "+ uri);
        
        //imprimir cabecers
         out.print("<br>");
        Enumeration cabecero= request.getHeaderNames();
        while(cabecero.hasMoreElements()){
            String nombreCaberero= (String) cabecero.nextElement();
            out.print("<br><b>"+nombreCaberero+"<b/>");
            out.print(request.getHeader(nombreCaberero));
            out.print("<br>");
        }
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
