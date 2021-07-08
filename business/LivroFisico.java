package business;

public class LivroFisico implements IProduto{
	private static final double ADIC_PAGINA = 0.03;
	private double valorEncadernado;
	
	public LivroFisico(double v) {
		this.setValorEncadernado(v);
	}
	
	public double getValorEncadernado() {
		return valorEncadernado;
	}
	public void setValorEncadernado(double valorEncadernado) {
		this.valorEncadernado = valorEncadernado;
	}
	public static double getAdicPagina() {
		return ADIC_PAGINA;
	}
	
	@Override
	public double precoVenda(Livro livro) {
		return (livro.getPrecoBase() + (livro.getPaginas() * ADIC_PAGINA) + this.valorEncadernado);
	}

}
