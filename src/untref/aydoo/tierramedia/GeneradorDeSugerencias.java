package untref.aydoo.tierramedia;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneradorDeSugerencias {

	private double distanciaMaximaEnMetros;
	private List<Atraccion> atracciones;

	public GeneradorDeSugerencias() {

		this.atracciones = new LinkedList<Atraccion>();
	}

	public Visita sugerirVisita(Usuario usuario) {

		Visita visita = new Visita();

		Iterator<Atraccion> iterator = this.atracciones.iterator();

		while (iterator.hasNext()) {

			Atraccion atraccion = iterator.next();

			if (usuario.puedeVisitar(atraccion)) {

				visita.getItinerario().getAtracciones().add(atraccion);
			}
		}
		
	System.out.println(visita.getItinerario().getAtracciones().size());

		return visita;
	}

	public double getDistanciaMaximaEnMetros() {
		return distanciaMaximaEnMetros;
	}

	public void setDistanciaMaximaEnMetros(double distanciaMaximaEnMetros) {
		this.distanciaMaximaEnMetros = distanciaMaximaEnMetros;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void sortAtraccionesPorCosto() {

		Collections.sort(atracciones, new Comparator<Atraccion>() {
			public int compare(Atraccion o1, Atraccion o2) {
				if (o1.getCosto() == o2.getCosto())
					return 0;
				return o1.getCosto() > o2.getCosto() ? -1 : 1;
			}
		});
	}

}
