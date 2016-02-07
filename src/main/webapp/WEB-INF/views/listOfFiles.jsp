<%-- 
    Document   : listOfFiles
    Created on : 11 Jan, 2016, 8:01:07 PM
    Author     : SARAT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/myscript.js"></script>
    </head>
    <body>
        <table id="fileUploads">
            <tr>
                    <th>File   Name </th>
                    <th>Price</th>
                    <th>Logo</th>
                    
                </tr>
            <c:forEach items="${listOfFileUploads}" var="fileUpload">
                <tr>
                    <td>
                         ${fileUpload.fileName}
                    </td>

                    <td>
                          ${fileUpload.price}
                    </td>

                    <td>
                        <img src="myImage/imageDisplay?id=${fileUpload.id}"/>
                    </td>
                    <td>
                        <a href="#">Edit</a>
                    </td>
                    <td>
                        <a href="#" onclick="deleteRow(this,${fileUpload.id})">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
