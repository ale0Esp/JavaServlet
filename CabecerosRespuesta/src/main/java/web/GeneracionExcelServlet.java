package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //tipo de respuesta
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition","atachment;filename=excelEjemplo.xls");
        //poi.apache.org excel
        
        //no cache
        response.setHeader("Pragma", "no-cache");
        response.setHeader("cache-control", "no-store");
        response.setDateHeader("Expire",-1);
        //desplegar info
        PrintWriter out = response.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("\t3");
        out.println("Total\t=SUMA(b2:b4)");
        out.close();
    }
}
