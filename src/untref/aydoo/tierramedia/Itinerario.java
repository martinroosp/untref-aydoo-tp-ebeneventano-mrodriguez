package untref.aydoo.tierramedia;

import java.util.LinkedList;
import java.util.List;

public class Itinerario {

	// Tal vez sería mejor implementar una cola.
	private List<Atraccion> atracciones;

	public Itinerario() {

		this.atracciones = (new LinkedList<Atraccion>());
	}

	public List<Atraccion> getAtracciones() {
		
		return atracciones;
	}

}
