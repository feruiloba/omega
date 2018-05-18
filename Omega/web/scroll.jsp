<%-- 
    Document   : scroll
    Created on : 5/03/2018, 07:26:25 PM
    Author     : sdist
--%>

<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SCROLLING DATABASE</h1>
        
        <form action="scroll.jsp">

        <%
            HttpSession mySession = request.getSession();
            String usuario = mySession.getAttribute("username").toString();
            if(usuario==null){
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/scroll.jsp");
                dispatcher.forward(request, response);
            }
            else{
                out.println("Bienvenido "+usuario+"<br>");
            }
            
            if (mySession.getAttribute("myResultSet") != null) {
                Object[][] myResultSet = (Object[][]) (mySession.getAttribute("myResultSet"));
                Object row = mySession.getAttribute("row");
                int row1 = Integer.parseInt(row.toString());
                
                if (request.getParameter("left") != null) {
                    if (row1 > 0) {
                        
                        row1 = row1 - 1;
                        mySession.setAttribute("row", row1);
                    }
                }
                else {
                    if (request.getParameter("right") != null) {
                        if (row1 < myResultSet.length-1) {

                            row1 = row1 + 1;
                            mySession.setAttribute("row", row1);
                        }
                    }
                }
                
                out.println("ID: " + myResultSet[row1][0]+"<br>");
                out.println("NAME: " + myResultSet[row1][1]+"<br>");
                if(row1==0){
                    out.println("<input type=\"submit\" value=\"left\" name=\"left\" disabled=\"disabled\"/>");
                    out.println("<input type=\"submit\" value=\"right\" name=\"right\"/>");
                }
                else{
                    if(row1==myResultSet.length - 1){
                        out.println("<input type=\"submit\" value=\"left\" name=\"left\"/>");
                        out.println("<input type=\"submit\" value=\"right\" name=\"right\" disabled=\"disabled\"/>");
                    }
                    else{
                        out.println("<input type=\"submit\" value=\"left\" name=\"left\"/>");
                        out.println("<input type=\"submit\" value=\"right\" name=\"right\"/>");
                    }
                }
            }
        %>
        <br>
        
        <form>
            <%
                
            %>
        </form>

        </form>
    </body>
</html>
