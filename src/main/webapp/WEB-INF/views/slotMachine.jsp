<%-- 
    Document   : slotMachine
    Created on : 12 Jan, 2016, 10:14:54 PM
    Author     : SARAT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"  href="css/style.css">
        <link rel="stylesheet" type="text/css"  href="css/jquery.fancybox.css">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.js"></script>
        <script type="text/javascript" src="js/myscript.js"></script>
        
    </head>
    <body>
        <h1> Welcome to slot machine </h1>

        <div >
            <p><a id="myLinkID" class="modalbox" href="#inline"></a></p>
        </div>

        <!-- hidden inline form -->
        <div id="inline">
            <h2>Winning</h2>



            <form id="contact" name="contact" action="#" method="post">
                <label >Email</label>
                <input type="text" id="email" name="email" size="32" class="txt"/> <h4 id="id1"></h4>
                <button id="send">Send</button>

            </form>
        </div>


        <div id="show1" align="center">

            <c:forEach items="${imageIds}" var="imageId">
                <img src="myImage/imageDisplay?id=${imageId}"/> 
            </c:forEach>

        </div>
        <input type="button" value="start" onclick="startTimer()">

        <input type="button" value="stop" onclick="clearTimer()">
    </body>
</html>
