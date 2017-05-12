<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body {
    background-image:
        url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar Obra</title>
</head>
<body>
    <%if (request.getAttribute("mensaje")=="ok") {%>
        <script>alert("Se agregó correctamente");</script>
    <%}else{%>
        <script>alert("Se agregó correctamente");</script>
    <%}%>
    <div align="center" style="margin-top: 50px;">
        <form action="ServletQuiz">
           Nombre: <input type="text" name="nombre"> <br>
           Decripción: <input type="text" name="descripcion"> <br>
           Estilo: <input type="text" name="estilo"> <br>
           Valor: <input type="text" name="valor"> <br>
           Usuario: <input type="text" name="usuario"> <br>
        <input type="submit" value="submit">
        </form>
     </div>
    
    <img src="ChartServlet" />
    <!--Descargar Excel <a href="HSSFCreate">Descargar</a> -->
    
</body>
</html>
