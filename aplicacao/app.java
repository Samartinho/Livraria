package aplicacao;

import business.Autor;
import business.Avaliacao;
import business.Cliente;
import business.Livro;
import business.LivroDigital;
import business.LivroFisico;

public class app {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Jaguncio");
		Cliente cliente2 = new Cliente("Jaguncia");
		Autor autor1 = new Autor("Tolkien");
		Autor autor2 = new Autor("Poe");
		Livro livro1 = new Livro("Diario de um Banana", autor2, new LivroDigital(), 217, 69.9);
		Livro livro2 = new Livro("Diario de um Banana 5", autor1, new LivroFisico(3.9), 217, 89.9);
		autor2.add(livro1);
		autor1.add(livro2);
		Avaliacao avaliacao1 = new Avaliacao(cliente1, livro1, 4, "Infantil");
		Avaliacao avaliacao2 = new Avaliacao(cliente2, livro2, 5, "Bem escrito");
		livro1.addAvaliacao(avaliacao1);
		livro2.addAvaliacao(avaliacao2);
		cliente1.addAvaliacao(avaliacao1);
		cliente2.addAvaliacao(avaliacao2);
		System.out.println(cliente1.getAvaliacoes().get(0).getLivros().direitosAutorais());
		System.out.println(cliente1.getAvaliacoes().get(0).getLivros().avaliacaoMedia());
		System.out.println(cliente1.getAvaliacoes().get(0).getLivros().precoVenda());
		System.out.println(cliente2.getAvaliacoes().get(0).getLivros().direitosAutorais());
		System.out.println(cliente2.getAvaliacoes().get(0).getLivros().avaliacaoMedia());
		System.out.println(cliente2.getAvaliacoes().get(0).getLivros().precoVenda());

	}
}
