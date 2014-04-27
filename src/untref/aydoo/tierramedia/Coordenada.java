package untref.aydoo.tierramedia;

public class Coordenada {

	static final int radioTierraKilometros = 6371;

	private double latitud;
	private double longitud;

	public double distancia(Coordenada coordenada) {

		double deltaLatitud = radianes(this.latitud - coordenada.getLatitud());
		double deltaLongitud = radianes(this.longitud - coordenada.getLongitud());

		double a = Math.pow(Math.sin(deltaLatitud / 2), 2)
				+ Math.cos(radianes(this.latitud))
				* Math.cos(radianes(coordenada.getLatitud()))
				* Math.pow(Math.sin(deltaLongitud / 2), 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return radioTierraKilometros * c;
	}

	public double radianes(double coordenada) {

		return (Math.PI / 180) * coordenada;
	}

	public Coordenada(double latitud, double longitud) {
		
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		
		return latitud;
	}

	public void setLatitud(double latitud) {
		
		this.latitud = latitud;
	}

	public double getLongitud() {
		
		return longitud;
	}

	public void setLongitud(double longitud) {
		
		this.longitud = longitud;
	}

}
