package untref.aydoo.tierramedia.promocion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;

public class PromocionAxB extends Promocion {

	private List<Atraccion> bonificadas;

	public PromocionAxB() {

		super();
		bonificadas = new LinkedList<Atraccion>();
	}

	public List<Atraccion> getNecesarias() {
		return getAtracciones();
	}

	public List<Atraccion> getBonificadas() {
		return bonificadas;
	}

	public double getCosto(List<Atraccion> paquete) {

		double costo = 0;

		Iterator<Atraccion> iterator = paquete.iterator();

		if (paquete.containsAll(getAtracciones())) {

			while (iterator.hasNext()) {

				Atraccion atraccion = iterator.next();

				if (!bonificadas.contains(atraccion))
					costo = costo + atraccion.getCosto();
			}

		} else {

			while (iterator.hasNext()) {

				Atraccion atraccion = iterator.next();

				costo = costo + atraccion.getCosto();
			}
		}

		return costo;
	}

}
