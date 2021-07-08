import java.io.*;

public class Leitura {
	private static BufferedReader entrada;
	private static BufferedReader entrada2;

	public void abrirArquivo(String nomeArquivo) throws FileNotFoundException{
			entrada = new BufferedReader(new FileReader(nomeArquivo));
	}
	
	public void fecharArquivo() throws IOException {
			entrada.close();	
	}
	
	public String ler() throws IOException {
		String textoEntrada;
		textoEntrada = entrada.readLine();
		return textoEntrada;
	}

	public void abrirArquivo2Produto(String nomeArquivo) throws FileNotFoundException{//Pode manter esse parametro sim
			entrada2 = new BufferedReader(new FileReader(nomeArquivo));
	}
}
