package business;

public class LivroDigital implements IProduto{
	
	@Override
	public double precoVenda(Livro livro) {
		return livro.getPrecoBase();
	}
	
}