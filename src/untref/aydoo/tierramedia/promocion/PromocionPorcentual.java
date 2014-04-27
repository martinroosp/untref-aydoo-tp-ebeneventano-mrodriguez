package untref.aydoo.tierramedia.promocion;

import java.util.LinkedList;
import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;

public class PromocionPorcentual extends Promocion {

	private List<Atraccion> atracciones;
	private int descuento;

	public PromocionPorcentual() {

		atracciones = new LinkedList<Atraccion>();
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getCosto(Atraccion atraccion) {

		double costoAtraccion = atraccion.getCosto();

		return costoAtraccion - costoAtraccion * descuento / 100;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

}
