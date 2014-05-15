package untref.aydoo.tierramedia.promocion;

import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;

public class PromocionPorcentual extends Promocion {

	private int descuentoPorcentual;

	public void setDescuentoPorcentual(int descuentoPorcentual) {
		this.descuentoPorcentual = descuentoPorcentual;
	}

	public double getCosto(Atraccion atraccion) {

		double descuento = 0;
		double costoAtraccion = atraccion.getCosto();

		if (getAtracciones().contains(atraccion)) {

			descuento = costoAtraccion * descuentoPorcentual / 100;
		}

		return costoAtraccion - descuento;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

}
