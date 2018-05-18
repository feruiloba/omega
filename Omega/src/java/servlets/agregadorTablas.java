/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FRUILOBAP
 */
public class agregadorTablas extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet agregadorTablas</title>");            
            out.println("</head>");
            out.println("<body><TITLE> Add/Remove dynamic rows in HTML table </TITLE>\n" +
"<SCRIPT language=\"javascript\">\n" +
"    function addRow(tableID) {\n" +
"\n" +
"        var table = document.getElementById(tableID);\n" +
"\n" +
"        var rowCount = table.rows.length;\n" +
"        var row = table.insertRow(rowCount);\n" +
"\n" +
"        var cell1 = row.insertCell(0);\n" +
"        var element1 = document.createElement(\"input\");\n" +
"        element1.type = \"checkbox\";\n" +
"        element1.name=\"chkbox[]\";\n" +
"        cell1.appendChild(element1);\n" +
"\n" +
"        var cell2 = row.insertCell(1);\n" +
"        cell2.innerHTML = rowCount + 1;\n" +
"\n" +
"        var cell3 = row.insertCell(2);\n" +
"        var element2 = document.createElement(\"input\");\n" +
"        element2.type = \"text\";\n" +
"        element2.name = \"txtbox[]\";\n" +
"        cell3.appendChild(element2);\n" +
"\n" +
"\n" +
"    }\n" +
"\n" +
"    function deleteRow(tableID) {\n" +
"        try {\n" +
"        var table = document.getElementById(tableID);\n" +
"        var rowCount = table.rows.length;\n" +
"\n" +
"        for(var i=0; i<rowCount; i++) {\n" +
"            var row = table.rows[i];\n" +
"            var chkbox = row.cells[0].childNodes[0];\n" +
"            if(null != chkbox && true == chkbox.checked) {\n" +
"                table.deleteRow(i);\n" +
"                rowCount--;\n" +
"                i--;\n" +
"            }\n" +
"\n" +
"\n" +
"        }\n" +
"        }catch(e) {\n" +
"            alert(e);\n" +
"        }\n" +
"    }\n" +
"\n" +
"</SCRIPT>\n" +
"</HEAD>\n" +
"<BODY>\n" +
"\n" +
"<INPUT type=\"button\" value=\"Add Row\" onclick=\"addRow('dataTable')\" />\n" +
"\n" +
"<INPUT type=\"button\" value=\"Delete Row\" onclick=\"deleteRow('dataTable')\" />\n" +
"\n" +
"<TABLE id=\"dataTable\" width=\"350px\" border=\"1\">\n" +
"    <TR>\n" +
"        <TD><INPUT type=\"checkbox\" name=\"chk\"/></TD>\n" +
"        <TD> 1 </TD>\n" +
"        <TD> <INPUT type=\"text\" /> </TD>\n" +
"    </TR>\n" +
"</TABLE>\n" +
"\n" +
"</BODY>"
                    + "");
            out.println("<h1>Servlet agregadorTablas at " + request.getContextPath() + "</h1>");
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
