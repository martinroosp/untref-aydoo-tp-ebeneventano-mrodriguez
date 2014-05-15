package untref.aydoo.tierramedia.promocion;

import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;

public class PromocionPorcentual extends Promocion {

	private double descuentoPorcentual;

	public void setDescuentoPorcentual(double descuentoPorcentual) {
		this.descuentoPorcentual = descuentoPorcentual;
	}

	public double getCosto(List<Atraccion> paquete) {

		double descuento = 0;
		double costoTotal = 0;

		for (Atraccion unaAtraccion : paquete) {
			costoTotal += unaAtraccion.getCosto();
		}
		
		if (paquete.containsAll(atracciones)) {

			descuento = costoTotal * descuentoPorcentual;
		}

		return costoTotal - descuento;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

}
