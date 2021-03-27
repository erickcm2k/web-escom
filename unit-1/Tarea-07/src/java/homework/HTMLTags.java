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
                case "area": {
                    
                    out.println("<h2>Usando la etiqueta area junto con map, esto puede ser útil para secciones interactivas.</h2>"
                            + "<h3>Haga click en el teléfono, computadora o café.</h3>"
                            + "<img src=\"image.jpg\" alt=\"Workplace\" usemap=\"#workmap\" width=\"400\" height=\"379\">"
                            + "<map name=\"workmap\">"
                            + "  <area shape=\"rect\" coords=\"34,44,270,350\" alt=\"Computer\" href=\"https://www.apple.com/mx/\">"
                            + "  <area shape=\"rect\" coords=\"290,172,333,250\" alt=\"Phone\" href=\"https://www.apple.com/mx/\">"
                            + "  <area shape=\"circle\" coords=\"337,300,44\" alt=\"Cup of coffee\" href=\"https://www.starbucks.com.mx\">"
                            + "</map>");        
                }
                break;
                case "article": {
                    out.println("<article>Hola, soy un article.</article>");        
                }
                break;   
                case "audio": {
                    out.println("<h2>Reproduciendo audio</h2>"
                            + "<audio controls>"
                            + "  <source src=\"music.mp3\" type=\"audio/ogg\">"
                            + "</audio>");        
                }
                break;   
                case "video": {
                    out.println("<h2>Reproduciendo video</h2>"
                            + "<video width=\"320\" height=\"240\" controls>"
                            + "  <source src=\"video.mp4\" type=\"video/mp4\">"                           
                            + "</video>");        
                }
                break;   
                case "cite": {
                    out.println("<cite>Esto es una cita.</cite>"
                            + "<img src=\"scream.jpg\" width=\"220\" height=\"277\" alt=\"The Scream\">"
                            + "<p><cite>The Scream</cite> by Edward Munch. Painted in 1893.</p>");        
                }
                break;    
                case "command": {
                    out.println("<h2>La etiqueta command ya no es soportada en HTML 5.</h2>");        
                }
                break;   
                case "div": {
                    out.println("<div>Hola, soy un div.</div>");          
                }
                break; 
                case "embed": {
                    out.println("<h2>Mostrando un sito web embebido. No se recomienda seguir usando la etiqueta embed.</h2>"
                            + "<embed type=\"text/html\" src=\"https://www.apple.com/mx/\"  width=\"500\" height=\"200\">");        
                }
                break; 
                case "img": {
                    out.println("<h2>Mostrando una imagen.</h2>"
                            + "<img src=\"image.jpg\" alt=\"Workplace\" usemap=\"#workmap\" width=\"400\" height=\"379\">");        
                }
                break;                 
                case "menu": {
                    out.println("<h2>La etiqueta menu ya no es soportada por navegadores modernos.</h2>");        
                }
                break;                                     
                case "object": {
                    out.println("<h2>Se recomienda reemplazar esta etiqueta por otras más modernas.</h2>"
                            + "<object data=\"image.jpg\" alt=\"Workplace\" usemap=\"#workmap\" width=\"400\" height=\"379\"></object>");        
                }
                break; 
                case "progress": {
                    out.println("<h2>Simulando un progreso completado al 50%</h2>"
                            + "<label for=\"file\">Descargando...</label>"
                            + "<progress id=\"file\" value=\"50\" max=\"100\"> 32% </progress>");        
                }
                break;                    
                case "source": {
                    out.println("<h2>Usando la etiqueta source con un clip de audio.</h2>"
                            + "<audio controls>"
                            + "  <source src=\"music.mp3\" type=\"audio/ogg\">"
                            + "</audio>");        
                }
                break;  
                case "textarea": {
                    out.println("<h2>Mostrando una textarea editable.</h2>"
                            + "<textarea id=\"w3review\" name=\"w3review\" rows=\"4\" cols=\"50\">"
                            + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a malesuada magna, ut tincidunt libero. Sed vitae laoreet ipsum, sed porta dolor. Curabitur rutrum, purus vitae placerat varius, mauris elit fringilla nisi, dictum cursus ipsum neque at sem. Vestibulum in quam nulla. Proin volutpat metus in libero ultricies pellentesque."
                            + "</textarea>");        
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
