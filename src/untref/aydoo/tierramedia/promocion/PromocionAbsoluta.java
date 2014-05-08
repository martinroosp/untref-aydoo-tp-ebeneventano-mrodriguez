package untref.aydoo.tierramedia.promocion;

import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;

public class PromocionAbsoluta extends Promocion {

	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public double getCosto(List<Atraccion> paquete) {

		super.getCosto();

		double costo = 0;

		if (paquete.containsAll(getAtracciones())) {
			costo = valor;
		} else {
			for (Atraccion unaAtraccion : paquete) {
				costo += unaAtraccion.getCosto();
			}
		}
		return costo;
	}

}
