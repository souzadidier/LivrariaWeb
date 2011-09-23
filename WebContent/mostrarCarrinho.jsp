<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.usp.cce.nucwww.modelo.Carrinho"%>
<%@ page import="br.usp.cce.nucwww.modelo.Livro"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Web</title>
</head>
<body>

<center><h1><b>Itens Incluidos no Pedido</b></h1></center>
<%
   Carrinho cesta = (Carrinho) session.getAttribute("carrinho");

   for(Livro livroCesta : cesta.obterItems()){
	   out.print("<b>"+livroCesta.getISBN()+" - "+livroCesta.getTitulo()+" - "+livroCesta.getQuantidade()+"</b><br>");
   }
%>

<form action="comprarLivro.jsp">
<input type="submit" value="Efetuar Compra">
</form>

<form action="index.jsp">
<input type="submit" value="Continuar Comprando">
</form>
</body>
</html>