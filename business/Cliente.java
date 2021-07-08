package business;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nome;
	private List<Avaliacao> Avaliacoes;
	
	public Cliente(String nome) {
		this.setNome(nome);
		this.Avaliacoes = new ArrayList<>();
	}

	public void addAvaliacao(Avaliacao a) {
		this.getAvaliacoes().add(a);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Avaliacao> getAvaliacoes() {
		return Avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		Avaliacoes = avaliacoes;
	}
	
}
