package business;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private static final double PCT_DIREITOS = 0.05;
	private String titulo;
	private Autor autor;
	private IProduto modalidade;
	private int paginas;
	private double precoBase;
	List<Avaliacao> avaliacoes;
	
	public Livro(String titulo, Autor autor, IProduto modalidade, int paginas, double precoBase) {
		super();
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setModalidade(modalidade);
		this.setPaginas(paginas);
		this.setPrecoBase(precoBase);
		this.avaliacoes = new ArrayList<>();;
	}
	
	public double precoVenda() {
		return this.getModalidade().precoVenda(this) + this.direitosAutorais();
	}
	public double direitosAutorais() {
		return this.getModalidade().precoVenda(this) * PCT_DIREITOS;
	}
	public double avaliacaoMedia() {
		return this.getAvaliacoes().stream().mapToDouble((m) -> m.getNota()).average().getAsDouble();
	}
	public void addAvaliacao(Avaliacao a) {
		this.getAvaliacoes().add(a);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public IProduto getModalidade() {
		return modalidade;
	}
	public void setModalidade(IProduto modalidade) {
		this.modalidade = modalidade;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public double getPrecoBase() {
		return precoBase;
	}
	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public static double getPctDireitos() {
		return PCT_DIREITOS;
	}
}
