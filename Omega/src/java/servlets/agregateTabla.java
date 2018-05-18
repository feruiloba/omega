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

/**
 *
 * @author PLEVERG
 */
public class agregateTabla extends HttpServlet {

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
            out.println("<title>Servlet agregateTabla</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession mySession = request.getSession();
            String usuario = mySession.getAttribute("username").toString();
            out.println("<label id=\"usuario\" hidden=true>"+usuario+"</label>");
            String nextJSP = "/include2.jsp";
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.include(request, response);
            
            out.println();
            out.println("</html>");
        }
    }
    public String scriptAgregaFila(){
    return "<SCRIPT language=\"javascript\">\n" +
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
"        cell2.innerHTML = rowCount ;\n" +
"\n" +
"        var cell3 = row.insertCell(2);\n" +
"        var element2 = document.createElement(\"input\");\n" +
"        element2.type = \"text\";\n" +
"        element2.name = \"txtbox[]\";\n" +
"        cell3.appendChild(element2);\n" +
"\n" +
"\n" +
"        var cell4 = row.insertCell(3);\n" +
"        var element3 = document.createElement(\"select\");\n" +
"        element3.name = \"tipos\";\n" +
"        var option = document.createElement('option');\n"+
"        var option1 = document.createElement('option');\n"+
"        var option2 = document.createElement('option');\n"+
"        var option3 = document.createElement('option');\n"+
"        var option4 = document.createElement('option');\n"+
"        option.text   = \"varchar25\" ;\n"+
"        option.value  = \"varchar25\";\n"+
"        option1.text  = \"varchar50\" ;\n"+
"        option1.value = \"varchar50\" ;\n"+
"        option2.text  = \"Integer\" ;\n"+
"        option2.value = \"Integer\" ;\n"+
"        option3.text  = \"Double\" ;\n"+
"        option3.value = \"Double\" ;\n"+
"        option4.text  = \"boolean\" ;\n"+
"        option4.value = \"boolean\" ;\n"+
"        element3.add (option,0);\n" +
"        element3.add (option1,1);\n" +
"        element3.add (option2,2);\n" +
"        element3.add (option3,3);\n" +
"        element3.add (option4,4);\n" +
"        cell4.appendChild(element3);\n" +

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
            
 "function createStrings(tableID){\n"+
"        try {\n" + 
"var table = document.getElementById('dataTable'); "+
"var params = [];"+
"var types = []; "+

"for(var r in table.rows){ "+
"	if(['length', 'item', 'namedItem'].indexOf(r) == -1 && r > 0){  "+
"        if(table.rows[r].cells[2].childNodes[0].value && table.rows[r].cells[3].childNodes[0].value){ "+
"		params.push(table.rows[r].cells[2].childNodes[0].value); "+
"		types.push(table.rows[r].cells[3].childNodes[0].value); "+
"    	} "+
"   	} "+
"    } "+
"console.log(params, types); "+
"}catch(e){ alert(e);}"+
            " }"+
           
 ""+
            
"</SCRIPT>\n" ;
            
            
    
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
