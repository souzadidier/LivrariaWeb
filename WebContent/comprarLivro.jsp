<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@page import="br.usp.cce.nucwww.modelo.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Web</title>
</head>
<body>
<form action="concluir.jsp">
<center><h1><b>Informações sobre o Cliente</b></h1></center>
<p>
   <b>Nome Cliente</b><br>     
   <input type="text" name="nome" size="40"><br>
   <b>Telefone</b><br>
   <input type="text" name="telefone" size="10">
</p>
<center><h1><b>Itens Incluidos no Pedido</b></h1></center>
<%
   Carrinho cesta = (Carrinho) session.getAttribute("carrinho");

   for(Livro livroCesta : cesta.obterItems()){
	   out.print("<b>"+livroCesta.getISBN()+" - "+livroCesta.getTitulo()+" - "+livroCesta.getQuantidade()+"</b><br>");
   }
%>
<input type="submit" value="Finalizar Compra"> 
cccccccc
</form>

<form action="cancelar.jsp">
<input type="submit" value="Cancelar">
</form>


</body>
</html>