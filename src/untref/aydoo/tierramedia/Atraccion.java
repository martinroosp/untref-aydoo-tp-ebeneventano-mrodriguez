package untref.aydoo.tierramedia;

public class Atraccion {

	private Coordenada coordenadasGlobalesDePosicionamiento;
	private double costo;
	private int minutosNecesarios;
	private int cupoDeVisitantesDiarios;
	private TipoDeAtraccion tipo;

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Coordenada getCoordenadasGlobalesDePosicionamiento() {
		return coordenadasGlobalesDePosicionamiento;
	}

	public void setCoordenadasGlobalesDePosicionamiento(
			Coordenada coordenadasGlobalesDePosicionamiento) {
		this.coordenadasGlobalesDePosicionamiento = coordenadasGlobalesDePosicionamiento;
	}

}
