package untref.aydoo.tierramedia.promocion;

import java.util.LinkedList;
import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;
import untref.aydoo.tierramedia.exception.PromocionNoAplicaException;

public class PromocionAbsoluta extends Promocion {

	private List<Atraccion> atracciones;
	private double valor;

	public PromocionAbsoluta() {

		atracciones = new LinkedList<Atraccion>();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public double getCosto(List<Atraccion> paquete) throws Exception {

		if (paquete.containsAll(atracciones)) {

			return valor;

		} else {

			throw new PromocionNoAplicaException();
		}
	}

}
