package br.usp.cce.nucwww.modelo;

import java.util.*;

public class Carrinho {

	private Map<Long, Livro> CestaLivro = new HashMap<Long, Livro>();

	public void Inserir(Livro livro) {
	   if(CestaLivro.containsKey(livro.getISBN())){
		   AtualizarQuantidade(livro.getISBN());
	   } else
		CestaLivro.put(livro.getISBN(), livro);
	}

	public void Remover(long ISBN) {
		CestaLivro.remove(ISBN);
	}

	public Livro Procurar(long ISBN) {
		return CestaLivro.get(ISBN);
	}

	public void listar() {
		for (Livro livro : CestaLivro.values()) {
			System.out.println("ISBN: " + livro.getISBN() + " | Título: "
					+ livro.getTitulo() + " | Autor: " + livro.getAutor()
					+ " | Quantidade: " + livro.getQuantidade());
		}
	}
	
	public Collection<Livro> obterItems(){
		return CestaLivro.values();
	}

	public void QtdLivroCarrinho() {
		System.out.println(CestaLivro.size());
	}

	public void AtualizarQuantidade(long ISBN) {
		Livro livro = CestaLivro.get(ISBN);
		if (livro != null)
			livro.setQuantidade();
	}

	public void EsvaziarCarrinho() {
		CestaLivro.clear();
	}

}
