<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.usp.cce.nucwww.bd.bancoLivro"%>
<%@ page import="br.usp.cce.nucwww.modelo.*"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Web</title>
</head>
<body>
<%
       bancoLivro bd = (bancoLivro) session.getAttribute("LivroBD");
       Cliente cliente = new Cliente(request.getParameter("nome"), request.getParameter("telefone"));
       Carrinho cesta  = (Carrinho) session.getAttribute("carrinho");
       
       try {
          bd.ComprarLivros(cliente, cesta);
       } catch (NullPointerException e){
    	   out.print("Erro na compra do Livro!");
       } catch (Exception e){
    	   out.print("Erro na compra do Livro!");
       } 
%>

       <center><h1><b>Pedido</b></h1></center><br>
       <center>Parabéns, seu pedido esta em nosso banco de dados e em breve você receberá os itens adquiriodos!</center><br>
       <center><a href= "javascript:window.location='index.jsp'">voltar para loja </a></center>
          
</body>
</html>