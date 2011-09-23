package br.usp.cce.nucwww.modelo;

public class Livro {

	private long ISBN;
	private String Titulo;
	private String Autor;
	private int Quantidade=1;

	public Livro(long ISBN, String Titulo, String Autor) {
		this.ISBN = ISBN;
		this.Titulo = Titulo;
		this.Autor = Autor;
	}

	public Long getISBN() {
		return this.ISBN;
	}

	public String getTitulo() {
		return this.Titulo;
	}

	public String getAutor() {
		return this.Autor;
	}

	public int getQuantidade() {
		return this.Quantidade;
	}

	public void setQuantidade() {
		this.Quantidade++;
	}
}
