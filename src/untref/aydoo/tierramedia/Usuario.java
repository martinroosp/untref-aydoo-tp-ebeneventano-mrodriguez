package untref.aydoo.tierramedia;

import java.util.Iterator;
import java.util.List;

public class Usuario {

	private double presupuesto;
	private int minutosDisponibles;
	private double velocidadDeTraslado; // en km/hora
	private TipoDeAtraccion tipoDeAtraccionPreferida;
	private Coordenada coordenadas;
	private Perfil perfil;

	public boolean puedeVisitar(Atraccion atraccion) {

		boolean presupuestoSuficiente = this.getPresupuesto() >= atraccion
				.getCosto();
		boolean tiempoSuficiente = (this.minutosDisponibles - this
				.tiempoParaLlegar(atraccion)) >= atraccion
				.getMinutosNecesarios();

		return presupuestoSuficiente && tiempoSuficiente;

	}

	public boolean puedeVisitar(List<Atraccion> atracciones) {

		double costoTotal = 0;
		int minutosNecesarios = 0;

		Iterator<Atraccion> iterator = atracciones.iterator();

		while (iterator.hasNext()) {

			Atraccion atraccion = iterator.next();

			costoTotal += atraccion.getCosto();
			minutosNecesarios += atraccion.getMinutosNecesarios();
		}

		boolean presupuestoSuficiente = this.getPresupuesto() >= costoTotal;
		boolean tiempoSuficiente = (this.minutosDisponibles) >= minutosNecesarios;

		return presupuestoSuficiente && tiempoSuficiente;

	}

	private int tiempoParaLlegar(Atraccion atraccion) {

		return (int) (coordenadas.distancia(atraccion.getCoordenadas()) / (velocidadDeTraslado / 60));
	}

	public Visita getVisitaSugerida(List<Atraccion> atracciones) {

		Visita visita = new Visita();

		if (this.puedeVisitar(atracciones)) {

			visita.getItinerario().getAtracciones().addAll(atracciones);
		}

		return visita;
	}

	public double getPresupuesto() {

		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {

		this.presupuesto = presupuesto;
	}

	public Coordenada getCoordenadas() {

		return coordenadas;
	}

	public void setCoordenadas(Coordenada ubicacion) {

		this.coordenadas = ubicacion;
	}

	public double getVelocidadDeTraslado() {

		return velocidadDeTraslado;
	}

	public void setVelocidadDeTraslado(double velocidadDeTraslado) {

		this.velocidadDeTraslado = velocidadDeTraslado;
	}

	public int getMinutosDisponibles() {

		return minutosDisponibles;
	}

	public void setMinutosDisponibles(int minutosDisponibles) {

		this.minutosDisponibles = minutosDisponibles;
	}

	public TipoDeAtraccion getTipoDeAtraccionPreferida() {
		return tipoDeAtraccionPreferida;
	}

	public void setTipoDeAtraccionPreferida(
			TipoDeAtraccion tipoDeAtraccionPreferida) {
		this.tipoDeAtraccionPreferida = tipoDeAtraccionPreferida;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
