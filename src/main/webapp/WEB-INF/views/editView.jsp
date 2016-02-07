<%-- 
    Document   : editview
    Created on : 12 Jan, 2016, 3:14:11 PM
    Author     : SARAT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/myscript.js"></script>
    </head>
    <body>
        <form action="updateLogo" method="POST" enctype="multipart/form-data" onsubmit="return editValidation()">
            <br/>
            <table>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" value="${data.id}" name="id"/>
                    </td>
                </tr>
                <tr>

                    <td>File Name</td>
                    <td><input type="text" name="fileName"  value="${data.fileName}" id="fileName"/> </td>
                </tr>

                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="${data.price}" id="price"/> </td>
                </tr>
                
                

                <tr>
                    <td>Logo</td>
                    <td><img src="myImage/imageDisplay?id=${data.id}"/> <input type="file" name="logo" id="logo"/></td>
                </tr>

            </table>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
