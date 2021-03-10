package calculator;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick
 */
public class Calculator extends HttpServlet {

    
    protected float[] getResult(float x1, float x2, float y1, float y2, float c1, float c2) {
         float result[];
         result = new float[2];
        
        
        float deltaS = (x1 * y2) - (x2 * y1);
        float deltaX = (y1 * c2) - (y2 * c1);
        float deltaY = (x1 * c2) - (x2 * c1);
                
        float x = deltaX / deltaS;
        float y = deltaY / deltaS;
        
        result[0] = x;
        result[1] = y;
      
        
        return result;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            float x1 = parseFloat(request.getParameter("x1"));
            float x2 = parseFloat(request.getParameter("x2"));
            
            float y1 = parseFloat(request.getParameter("y1"));
            float y2 = parseFloat(request.getParameter("y2"));
            
            float c1 = parseFloat(request.getParameter("c1"));
            float c2 = parseFloat(request.getParameter("c2"));
            
            float[] result = getResult(x1, x2, y1, y2, c1, c2);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>x1 = "+ x1 +"</p>");
            out.println("<p>y1 = "+ y1 +"</p>");
            out.println("<p>c1 = "+ c1 +"</p>");
            out.println("<p>x2 = "+ x2 +"</p>");
            out.println("<p>y2 = "+ y2 +"</p>");
            out.println("<p>c2 = "+ c2 +"</p>");
            out.println("<hr>");
            out.println("<h3>El valor de X es: "+ result[0] +"</h3>");
            out.println("<h3>El valor de Y es: "+ result[1] +"</h3>");
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
