package untref.aydoo.tierramedia;

public class Atraccion {

	private String nombre;
	private Coordenada coordenadas;
	private double costo;
	private int minutosNecesarios;
	private int cupoDeVisitantesDiarios;
	private TipoDeAtraccion tipo;

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Coordenada getCoordenadas() {
		return this.coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}

	public int getMinutosNecesarios() {
		return this.minutosNecesarios;
	}

	public void setMinutosNecesarios(int minutosNecesarios) {
		this.minutosNecesarios = minutosNecesarios;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupoDeVisitantesDiarios() {
		return this.cupoDeVisitantesDiarios;
	}

	public void setCupoDeVisitantesDiarios(int cupoDeVisitantesDiarios) {
		this.cupoDeVisitantesDiarios = cupoDeVisitantesDiarios;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoDeAtraccion tipo) {
		this.tipo = tipo;
	}

}
