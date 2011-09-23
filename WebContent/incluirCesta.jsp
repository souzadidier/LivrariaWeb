<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.usp.cce.nucwww.bd.bancoLivro"%>
<%@page import="br.usp.cce.nucwww.modelo.Carrinho"%>
<%@page import="br.usp.cce.nucwww.modelo.Livro"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Web</title>
</head>
<body>
<%
    bancoLivro livroBD = (bancoLivro) session.getAttribute("LivroBD");
    Carrinho cesta     = (Carrinho) session.getAttribute("carrinho");
    long ISBN = Long.parseLong(request.getParameter("ISBN"));
    
    if (cesta == null) {
        cesta = new Carrinho();
        session.setAttribute("carrinho", cesta);
    }
    
    Livro livro = livroBD.getLivro(new Long(request.getParameter("ISBN")));
    
    if(livro != null){        
        cesta.Inserir(livro);        	
    } else { out.println("Não consegui incluir o Livro");}
        
%>
<center><h1><b>Itens Incluidos na Cesta</b></h1></center>
    <%
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