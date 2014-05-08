package untref.aydoo.tierramedia;

import java.util.LinkedList;
import java.util.List;

public class Visita {

	private Itinerario itinerario;
	private List<Promocion> promociones;

	public Visita() {

		this.itinerario = new Itinerario();
		this.promociones = new LinkedList<Promocion>();
	}

	public Itinerario getItinerario() {

		return itinerario;
	}

	public List<Promocion> getPromociones() {

		return promociones;
	}

}
