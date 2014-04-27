package untref.aydoo.tierramedia;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Itinerario {

	private List<Atraccion> atracciones;

	public Itinerario() {

		this.atracciones = (new LinkedList<Atraccion>());
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

	public void sortAtraccionesPorPreferencia(final TipoDeAtraccion tipo) {

		Collections.sort(atracciones, new Comparator<Atraccion>() {
			public int compare(Atraccion o1, Atraccion o2) {
				if (o1.getTipo() == o2.getTipo())
					return 0;
				else if (o1.getTipo() == tipo)
					return -1;
				return 1;
			}
		});
	}

}
