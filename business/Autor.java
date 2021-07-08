package business;

import java.util.ArrayList;
import java.util.List;

public class Autor {
	public String nome;
	private List<Livro> livros;
	
	public Autor(String nome) {
		this.setNome(nome);
		this.livros = new ArrayList<>();
	}
	
	public void add(Livro l) {
		this.getLivros().add(l);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}
