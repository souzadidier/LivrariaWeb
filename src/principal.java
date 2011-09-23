import java.util.Random;

import br.usp.cce.nucwww.bd.bancoLivro;
import br.usp.cce.nucwww.modelo.Carrinho;
import br.usp.cce.nucwww.modelo.Cliente;
import br.usp.cce.nucwww.modelo.Livro;

public class principal {

	public static void main(String args[]) {

		/*
		bancoLivro bd = new bancoLivro();
		Cliente cliente = new Cliente("Alessandro", "35632-3256");
		Carrinho cesta = new Carrinho();

		for (Livro livro : bd.getLivro()) {
			cesta.Inserir(livro);
		}

		//cesta.AtualizarQuantidade(10520);
		//cesta.AtualizarQuantidade(12345);
		//cesta.AtualizarQuantidade(12345);

		//cesta.listar();
		//cesta.QtdLivroCarrinho();

		//bd.ComprarLivros(cliente, cesta);

		//cesta.listar();
		
		Livro livro = bd.getLivro(12345);		
		System.out.println(livro.getAutor());
		
		for(Livro _livro : cesta.obterItems()){
			System.out.println(_livro.getAutor());
		}

*/

		
		int x = 1, y = 0, z = 0;
	    x = (-x + y++) * ++z ;
	    System.out.println(x);
		
	    Random r = new Random();
	    int i = Math.abs(r.nextInt()) % 5 + 4;
	    System.out.println(i);
	    
	    
	    
		
		
		
	}
}
