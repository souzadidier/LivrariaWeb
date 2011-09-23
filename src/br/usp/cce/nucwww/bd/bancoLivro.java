package br.usp.cce.nucwww.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import br.usp.cce.nucwww.modelo.*;

public class bancoLivro {

	public static final String URL_My = "jdbc:mysql://localhost:3306/Livraria";
	public static final String DRIVER_NAME_My = "com.mysql.jdbc.Driver";
	private static final String USER_My = "root";
	private static final String PASSWD_My = "e46511";

	private Connection conexao;
	protected Statement stmt;   
	protected ResultSet rs;
	private List<Livro> Livros;

	java.util.Date dataAtual = new java.util.Date();

	public bancoLivro() {
		try {
			Class.forName(DRIVER_NAME_My);
			conexao = DriverManager.getConnection(URL_My, USER_My, PASSWD_My);
		} catch (SQLException ex) {
			System.out.println(dataAtual + " : Erro SQLException : "
					+ ex.getMessage() + "\n");
		} catch (ClassNotFoundException e) {
			System.out.println(dataAtual + " : Nao pode carregar o driver "
					+ e.getMessage() + "\n");
		}
	}

	private Connection getConexao() {
		return conexao;
	}

	public Collection<Livro> getLivro() {
		Livros = new ArrayList<Livro>();
		try {
			getConexao();
			String sql = "select * from Livro";
			PreparedStatement prepStmt = conexao.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				Livro livro = new Livro(rs.getLong("ISBN"), rs
						.getString("Titulo"), rs.getString("Autor"));
				Livros.add(livro);
			}
			prepStmt.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return Livros;
	}

	public Livro getLivro(long ISBN) {
		Livro _livro = null;
		for (Livro livro : getLivro()) {
			if (livro.getISBN().equals(ISBN)) {
				_livro = livro;
			}
		}
		return (Livro) _livro;
	}

	public void ComprarLivros(Cliente cliente, Carrinho carrinho) {
		try {
			for (Livro livro : carrinho.obterItems()) {
				ComprarLivro(cliente.getNome(), cliente.getTelefone(), livro
						.getISBN(), livro.getQuantidade());
			}
		} catch (Exception ex) {
		}
		carrinho.EsvaziarCarrinho();
	}

	private void ComprarLivro(String nomeCliente, String telefone, long ISBN,
			int Quantidade) {
		try {
			getConexao();
			PreparedStatement prepStmt;
			String sql = "select * from Livro where ISBN = ? ";
			prepStmt = conexao.prepareStatement(sql);
			prepStmt.setLong(1, ISBN);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				int inventario = rs.getInt("inventario");
				System.out.println(rs.getString(4));

				if ((inventario - Quantidade) >= 0) {
					String sqlUpdate = "update Livro set inventario = inventario - ? where ISBN = ?";
					PreparedStatement prepStmt1 = conexao
							.prepareStatement(sqlUpdate);
					prepStmt1.setInt(1, Quantidade);
					prepStmt1.setLong(2, ISBN);
					prepStmt1.executeUpdate();

					String sqlUpdatePedido = "insert into Pedido values(?, ?, ?, ?)";
					PreparedStatement prepStmt2 = conexao
							.prepareStatement(sqlUpdatePedido);
					prepStmt2.setString(1, nomeCliente);
					prepStmt2.setString(2, telefone);
					prepStmt2.setLong(3, ISBN);
					prepStmt2.setInt(4, Quantidade);
					prepStmt2.executeUpdate();

				} else
					System.out.println("Não há livros " + ISBN
							+ " no estoque para efetuar a venda.");
			}
			prepStmt.close();
		} catch (Exception ex) {
			System.out.println("Não foi possivel concluir a compra: " + ISBN
					+ ex.getMessage());
		}
	}

}
