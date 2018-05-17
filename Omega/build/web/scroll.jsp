<%-- 
    Document   : scroll
    Created on : 5/03/2018, 07:26:25 PM
    Author     : sdist
--%>

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
            if (mySession.getAttribute("myResultSet") != null) {
                Object[][] myResultSet = (Object[][]) (mySession.getAttribute("myResultSet"));
                Object row = mySession.getAttribute("row");
                int row1 = Integer.parseInt(row.toString());
                if (request.getParameter("left") != null) {
                    if (row1 > 0) {
                        row1 = row1 - 1;
                        
                        mySession.setAttribute("row", row1);
                        out.println("<input type=\"submit\" value=\"left\" name=\"left\"/>");
                        out.println("<input type=\"submit\" value=\"right\" name=\"right\"/>");
                        out.println(" <br> LEFT");
                        out.println("ID: " + myResultSet[row1][0]);
                        out.println("NAME: " + myResultSet[row1][1]);
                       
                    }else {
                       out.println("<input type=\"submit\" value=\"left\" name=\"left\" disabled=\"disabled\"/>");
                       out.println("<input type=\"submit\" value=\"right\" name=\"right\"/>");
                    }
                } else {
                    if (request.getParameter("right") != null) {
                        if (row1 < myResultSet.length - 1) {
                            
                            row1 = row1 + 1;
                            out.println("<input type=\"submit\" value=\"left\" name=\"left\"/>");
                            out.println("<input type=\"submit\" value=\"right\" name=\"right\"/>");
                            out.println("<br> RIGHT");
                            out.println("ID: " + myResultSet[row1][0]);
                            out.println("NAME: " + myResultSet[row1][1]);
                            mySession.setAttribute("row", row1);
                        }else {
                            out.println("<input type=\"submit\" value=\"left\" name=\"left\"/>");
                            out.println("<input type=\"submit\" value=\"right\" name=\"right\" disabled=\"disabled\"/>");
                        }
                    }else{
                        out.println("<input type=\"submit\" value=\"left\" name=\"left\" diabled = \"disabled\"/>");
                        out.println("<input type=\"submit\" value=\"right\" name=\"right\"/>");
                    }
                    }

            }
        %>         
        <br> 

        </form>
    </body>
</html>
