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
            out.println("<canvas id=\"myCanvas\" width=\"600\" height=\"400\" style=\"border:5px solid blue;\">");
            
            out.println("<script>"
                    + "var c = document.getElementById(\"myCanvas\");\n"
                    + "var ctx = c.getContext(\"2d\");");
                    
            
            switch(tag) {                                            
                case "text": {                    
                    out.println("ctx.font = \"30px Arial\";\n"
                    + "ctx.fillText(\"Hello World\",10,50);");
                }
                break;
                case "text-stroke": {
                    out.println("ctx.font = \"60px Georgia\";\n"
                            + "ctx.strokeText(\"Hello World!\", 100, 150);");
                }
                break;        
                case "circular-gradient": {
                    out.println("var grd = ctx.createRadialGradient(75, 50, 5, 90, 60, 100);\n" +
                    "grd.addColorStop(0, \"red\");\n" +
                    "grd.addColorStop(1, \"white\");\n" +
                    "\n" +                    
                    "ctx.fillStyle = grd;\n" +
                    "ctx.fillRect(10, 10, 150, 100);");        
                }
                break;                          
                default: {
                    out.println("<h3>No seleccionaste ninguna etiqueta.</h3>");
                }
            }
            out.println("</script>");
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
