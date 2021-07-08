
public class Produto {
	private int id;
	private double volume;

	public Produto(String str) {

		String campos[] = str.split(";");
		this.id = Integer.parseInt(campos[0]);
		this.volume = Double.parseDouble(campos[1]);

	}

	public double getVolume() {
		return this.volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public int getid() {
		return this.id;
	}

}
