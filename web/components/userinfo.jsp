<%-- 
    Document   : userCard
    Created on : Dec 7, 2019, 10:32:09 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%  String username = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("username")) {
                            username = cookie.getValue();
                        }
                    }
                }%>
            <% if (username != null) {%> <div class="user-info" >Welcome <%=username%> </div> <% }%>
</html>
