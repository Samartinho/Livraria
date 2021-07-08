package business;

public class Avaliacao {
	public static final int MAX_AVAL = 5;
	private Cliente cliente;
	private Livro livros;
	private int nota;
	private String comentario;
	
	public Avaliacao(Cliente cliente, Livro livros, int nota, String comentario) {
		super();
		this.setCliente(cliente);
		this.setLivros(livros);
		this.setNota(nota);
		this.setComentario(comentario);
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Livro getLivros() {
		return livros;
	}
	public void setLivros(Livro livros) {
		this.livros = livros;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public static int getMaxAval() {
		return MAX_AVAL;
	}
	
}
