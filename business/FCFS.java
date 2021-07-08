import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FCFS {

	private Leitura le;

	private Pedido[] pedidos = new Pedido[1000];
	private Produto[] produtos = new Produto[1000];
	private Container[] containers = new Container[4];
	private List<Container> containersReserva = new ArrayList<>();
	private static int cont = 0;
	private double tempoTotal = 0;
	private static int TEMPO_EXTRA = 30;

	public FCFS() {
		for(int i=0;i<containers.length;i++) {
			containers[i]=new Container(i);//vai criar 4 conteiners
		}
		
		le = new Leitura();
	}

	public void leArquivo(String arquivo) throws IOException {

		le.abrirArquivo(arquivo);
		String aux = le.ler();

		String[] temp = new String[4];//-->Voltar pra 319 Quando tiver OS DOIS TXTS(esse e do professor)
		for (int i = 0; i < 4; i++) {
			temp[i] = le.ler();
			cont++;
			this.pedidos[i] = new Pedido(temp[i]);

		}
		le.fecharArquivo();
	}

	public void leArquivoProdutos(String arquivo) throws IOException {// To chamando na aplicacao
		le.abrirArquivo(arquivo);
		String aux = le.ler();

		String[] temp = new String[10]; // So verifica o tamanho do txt(Quando tiver) e Muda isso<--
		for (int i = 0; i < 10; i++) {
			temp[i] = le.ler();
			cont++;
			this.produtos[i] = new Produto(temp[i]);
			if(i>3) {
				this.containersReserva.add(new Container(i));
				//Acrescentei-->A partir da quarta linha ele vai criar os outros containers Reservas(Do 5 em diante é Reserva)
			}
		}
		le.fecharArquivo();
	}

	public double trocarConteiner(Produto prod) {
		for (int i = 0; i < containers.length; i++) {
			if (containers[i].getTipo() == prod.getid()) {
				return 0;// O produto passado ta nos containers proximos
			}
		}
		Container containersaux = containers[containers.length-1];// Meu criterio é substtiuir o ultimo container
		Optional<Container> containerRequisitado = containersReserva.stream().filter(c -> c.getTipo() == prod.getid())
				.findFirst();
		if (containerRequisitado.isPresent()) {// se tiver algo la
			Container containerEncontrado = containerRequisitado.get();// pegamos o container
			containersReserva.remove(containerEncontrado);// removemos o container

			tempoTotal = tempoTotal + TEMPO_EXTRA;

			containers[containers.length-1] = containerEncontrado;
			
			containersReserva.add(containersaux);// Fiz a troca

		}
		else {
			System.out.println("Container requisitado nao presente");
		}
		return tempoTotal;
	}

	public void orgFCFS() {

		int i;
		int aux;
		for (int j = 1; j < cont; j++) {

			Pedido temp = pedidos[j];
			if (temp == null) {
				break;
			}
			for (i = j - 1; (i >= 0) && (pedidos[i].getChegada() > temp.getChegada()); i--) {

				pedidos[i + 1] = pedidos[i];

			}
			pedidos[i + 1] = temp;

		}
	}

	public void printPedidosAtendidos() {
		int cont = 0;
		for (int i = 0; i < FCFS.cont; i++) {
			if (pedidos[i]!=null && pedidos[i].isAtendimento()) {//ALTEREI(so coloquei o null)
				cont++;
			}
		}
		System.out.println("Quantidade atendida: " + cont);
		this.media();

	}

	public void media() {
		double soma = 0;
		int i;
		for (i = 0; i < cont; i++) {
			if (pedidos[i]!=null && pedidos[i].isAtendimento()) {//ALTEREI
				soma += pedidos[i].getTempo();
			}
		}
		double media = (double) soma / i;
		System.out.println("Tempo médio de retorno: " + media);
	}

	public void printAteMeioDia() {
		int cont = 0;
		System.out.println("Pedidos concluidos ate meio dia: ");
		for (int i = 0; i < FCFS.cont; i++) {
			if (pedidos[i]!=null && pedidos[i].isAtendimento() && pedidos[i].getTempo() <= 240.0) {
				System.out.println(pedidos[i]);
				cont++;
			}
		}
		System.out.println("Quantidade ate meio dia: " + cont);
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public static int getCont() {
		return cont;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

}