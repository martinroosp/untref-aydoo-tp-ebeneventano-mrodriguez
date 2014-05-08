package untref.aydoo.tierramedia.promocion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;
import untref.aydoo.tierramedia.exception.PromocionNoAplicaException;

public class PromocionAxB extends Promocion {

	private List<Atraccion> bonificadas;

	public PromocionAxB() {

		super();
		bonificadas = new LinkedList<Atraccion>();
	}

	public List<Atraccion> getNecesarias() {
		return atracciones;
	}

	public List<Atraccion> getBonificadas() {
		return bonificadas;
	}

	public double getCosto(List<Atraccion> paquete) throws Exception {

		double costo = 0;

		if (paquete.containsAll(atracciones)) {

			Iterator<Atraccion> iterator = paquete.iterator();

			while (iterator.hasNext()) {

				Atraccion atraccion = iterator.next();
				if (!bonificadas.contains(atraccion))
					costo = costo + atraccion.getCosto();

			}

			return costo;

		} else {

			throw new PromocionNoAplicaException();
		}
	}

}
