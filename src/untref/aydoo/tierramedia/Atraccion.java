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

	public int calcularDistanciaAUsuarioEnMts(double latUsuario, double longUsuario){
		int radius = 6371000; //Radio de la tierra
		double latitudAtraccion = this.getCoordenadas().getLatitud() / 1E6;
		double latitudUsuario = latUsuario / 1E6;
		double longitudAtraccion = this.getCoordenadas().getLongitud() / 1E6;
		double longitudUsuario = longUsuario / 1E6;
		double dLat = Math.toRadians(latitudUsuario - latitudAtraccion);
		double dLon = Math.toRadians(longitudUsuario - longitudAtraccion);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + 
			Math.cos(Math.toRadians(latitudAtraccion)) * Math.cos(Math.toRadians(latitudUsuario)) * 
			Math.sin(dLon /2) * Math.sin(dLon/2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return (int) (radius * c);  
	}
}
