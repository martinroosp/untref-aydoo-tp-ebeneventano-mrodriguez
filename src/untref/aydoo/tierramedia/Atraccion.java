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

}
