/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import soapreference.Zote_Service;

/**
 *
 * @author FRUILOBAP
 */
public class editar extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Zote/Zote.wsdl")
    private Zote_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession mySession = request.getSession();
            String usuario = mySession.getAttribute("username").toString();
            String tabla = mySession.getAttribute("editar").toString();
            
            if(usuario==null){
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
            else{
                out.println("<h2>Bienvenido "+usuario+"</h2><br>");
            }
            
            if(tabla==null){
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/scroll.jsp");
                dispatcher.forward(request, response);
            }
            else{
                out.println("<h2>Editar tabla "+tabla+"</h2><br>");
                String tablaInfo = getTabla(tabla);
                
                String nextJSP = "/include.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.include(request, response); 
                
                String[] aux=tablaInfo.split("&");
                String[] columnNames = aux[0].split(",");
                String[] data = aux[1].split(",");
                out.println("<table id=\"tabla\" border=\"1\">");
                out.println("<thead id=\"header\">");
                out.println("<tr>");
                for(int i=0; i<columnNames.length; i++){
                    out.println("<th>"+columnNames[i]+"</th>");
                }
                out.println("<th>Cambiar</th>");
                out.println("</tr></thead>");
                out.println("<tbody>");
                
                for(int i=0; i<data.length; i=i+columnNames.length){
                    out.println("<tr id=\""+i+"\">");
                    for(int j=0; j<columnNames.length; j++){
                        out.println("<td><input type=\"text\" value='"+data[i+j]+"'"+"/></td>");
                    }
                    out.println("<td><input type=\"submit\" onclick=\"editaTabla('"+tabla+"',"+i+")\" value=\""+i+"\"</td>");
                    out.println("</tr>");
                }
                //out.println("<tr><td>Hola</td><td>Hola</td></tr>");
                out.println("</tbody>");
                out.println("</table>");
            }
            
            
            
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

    private String getTabla(java.lang.String nombre) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        soapreference.Zote port = service.getZotePort();
        return port.getTabla(nombre);
    }

}
