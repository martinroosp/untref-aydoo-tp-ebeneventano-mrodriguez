package untref.aydoo.tierramedia;

public class Coordenada {

	// Se suele redondear un grado de latitud a 111,12 km
	private double latitud;
	private double longitud;

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
