package untref.aydoo.tierramedia;

public class Atraccion {

	private String nombre;
	private Coordenada coordenadas;
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

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(
			Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}

	public int getMinutosNecesarios() {
		return minutosNecesarios;
	}

	public void setMinutosNecesarios(int minutosNecesarios) {
		this.minutosNecesarios = minutosNecesarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupoDeVisitantesDiarios() {
		return cupoDeVisitantesDiarios;
	}

	public void setCupoDeVisitantesDiarios(int cupoDeVisitantesDiarios) {
		this.cupoDeVisitantesDiarios = cupoDeVisitantesDiarios;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeAtraccion tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve la distancia al usuario, en distintas unidades
	 * 
	 * @param latUsuario - latitud de donde se encuentra el usuario
	 * @param longUsuario - longitud de donde se encuentra el usuario
	 * @param unit - unidad que deseo obtener la distancia (K = km, M = millas, N = millas nauticas)
	 * @return
	 */
	public int calcularDistanciaAUsuario(double latUsuario, double longUsuario, char unit){
		double theta = longUsuario - this.getCoordenadas().getLongitud();
		double dist = Math.sin(deg2rad(latUsuario)) * Math.sin(deg2rad(this.getCoordenadas().getLatitud())) + 
			Math.cos(deg2rad(latUsuario)) * Math.cos(deg2rad(this.getCoordenadas().getLatitud())) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (int) dist;
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
