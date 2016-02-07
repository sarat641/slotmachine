<%-- 
    Document   : home
    Created on : 1 Aug, 2015, 4:51:58 PM
    Author     : SARAT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/myscript.js"></script>
    </head>
    <body>
        <h1>Hello World! From Spring MVC</h1>

        <br/>

        <form action="uploadLogo" method="POST" enctype="multipart/form-data" onsubmit="return  validation()">
            <br/>
            <table>
                <tr>
                    <td>File Name</td>
                    <td><input type="text" name="fileName" id="fileName"/> </td>
                </tr>

                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" id="price"/> </td>
                </tr>


                <tr>
                    <td>Logo</td>
                    <td><input type="file" name="logo" id="logo"/></td>
                </tr>

            </table>
            <input type="submit" value="Save" />
        </form>

        <c:if test="${listOfFileUploads.size() > 0}">
            <br><br><br>



            <h1> List of Uploaded Files </h1>
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
                            <a href="edit?id=${fileUpload.id}">Edit</a>
                        </td>
                        <td>
                            <a href="#" onclick="deleteRow(this,${fileUpload.id})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
