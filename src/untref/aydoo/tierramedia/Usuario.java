package untref.aydoo.tierramedia;

import java.util.Iterator;
import java.util.List;

public class Usuario {

	private double presupuesto;
	private int minutosDisponibles;
	private double velocidadDeTraslado; // en km/hora
	private TipoDeAtraccion tipoDeAtraccionPreferida;
	private Coordenada coordenadas;

	public boolean puedeVisitar(Atraccion atraccion) {

		boolean presupuestoSuficiente = this.getPresupuesto() >= atraccion
				.getCosto();
		boolean tiempoSuficiente = (this.minutosDisponibles - this
				.tiempoParaLlegar(atraccion)) >= atraccion
				.getMinutosNecesarios();

		return presupuestoSuficiente && tiempoSuficiente;

	}

	public boolean puedeVisitar(Itinerario itinerario) {

		double costoTotal = 0;
		int minutosNecesarios = 0;

		Iterator<Atraccion> iterator = itinerario.getAtracciones().iterator();

		while (iterator.hasNext()) {

			Atraccion atraccion = iterator.next();

			costoTotal += atraccion.getCosto();
			minutosNecesarios += atraccion.getMinutosNecesarios()
					+ this.tiempoParaLlegar(atraccion);
		}

		boolean presupuestoSuficiente = this.getPresupuesto() >= costoTotal;
		boolean tiempoSuficiente = (this.minutosDisponibles) >= minutosNecesarios;

		return presupuestoSuficiente && tiempoSuficiente;

	}

	private int tiempoParaLlegar(Atraccion atraccion) {

		return (int) (coordenadas.distancia(atraccion.getCoordenadas()) / (velocidadDeTraslado / 60));
	}

	/**
	 * @pre Recibe la lista de atracciones y promociones existentes.
	 * @post Devuelve una visita con un itinerario posible y promociones.
	 * @param atracciones
	 * @param promociones
	 * @return
	 */
	public Visita getVisitaSugerida(List<Atraccion> atracciones,
			List<Promocion> promociones) {

		Visita visita = new Visita();

		/*
		 * Itera las promociones e intenta agregar las posibles.
		 * De momento la prioridad está dada por el órden de lista de entrada.
		 */
		Iterator<Promocion> iteradorPromociones = promociones.iterator();

		while (iteradorPromociones.hasNext()) {

			Promocion promocion = iteradorPromociones.next();

			if (!promocion.vencida()) {

				visita.getItinerario().getAtracciones()
						.addAll(promocion.getAtracciones());

				if (!puedeVisitar(visita.getItinerario())) {

					visita.getItinerario().getAtracciones()
							.removeAll(promocion.getAtracciones());
				} else {

					visita.getPromociones().add(promocion);
				}
			}
		}

		/*
		 * Itera las atracciones e intenta agregar las posibles.
		 * De momento la prioridad está dada por el órden de lista de entrada.
		 */
		Iterator<Atraccion> iteradorAtracciones = atracciones.iterator();

		while (iteradorAtracciones.hasNext()) {

			Atraccion atraccion = iteradorAtracciones.next();

			visita.getItinerario().getAtracciones().add(atraccion);

			if (!puedeVisitar(visita.getItinerario())) {

				visita.getItinerario().getAtracciones().remove(atraccion);
			}
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

}
