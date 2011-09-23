<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.usp.cce.nucwww.bd.bancoLivro"%>
<%@ page import="br.usp.cce.nucwww.modelo.Livro"%>
<html>
<head>     
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Web</title>
</head>
<body>

<center><h1><b>Livraria Web</b></h1></center>
<%
	bancoLivro bd = new bancoLivro();
	session.setAttribute("LivroBD", bd);

	for (Livro livro : bd.getLivro()) {
%>
<FORM ACTION="./incluirCesta.jsp" METHOD="POST">
<p>
      <INPUT TYPE="hidden" NAME="ISBN" VALUE="<%=livro.getISBN()%>">
      <b><%=livro.getTitulo()%> 
         <%=livro.getAutor()%>
      </b>
      <input type="submit" value="Incluir">
</p>   
</FORM>
<%
}
%>

<form action="mostrarCarrinho.jsp">
<input type="submit" value="Ver Itens no Carrinho">
</form>

</body>
</html>