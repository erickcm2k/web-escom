package homework;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTMLTags extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
                
        try (PrintWriter out = response.getWriter()) {
                     
            String tag = request.getParameter("tag");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Etiquetas dinámicas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mostrando la etiqueta " + tag + "</h1>");
            
            switch(tag) {
                case "header": {
                    out.println("<header style=\"color:blue;\">Hola, soy un header.</header>");        
                }
                break;
                case "nav": {
                    out.println("<nav style=\"color:red;\">Hola, soy un nav.</nav>");        
                }
                break;   
                case "article": {
                    out.println("<article style=\"color:pink;\">Hola, soy un article.</article>");        
                }
                break;   
                case "aside": {
                    out.println("<aside style=\"color:green;\">Hola, soy un aside.</aside>");        
                }
                break;   
                case "section": {
                    out.println("<section style=\"color:brown;\">Hola, soy un section.</section>");        
                }
                break;    
                case "footer": {
                    out.println("<footer style=\"color:turquoise;\">Hola, soy un footer.</footer>");        
                }
                break;   
                default: {
                    out.println("<h3>No seleccionaste ninguna etiqueta.</h3>");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
                            
               
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
