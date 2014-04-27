package untref.aydoo.tierramedia.promocion;

import java.util.LinkedList;
import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;

public class PromocionPorcentual extends Promocion {

	private List<Atraccion> atracciones;
	private int descuentoPorcentual;

	public PromocionPorcentual() {

		atracciones = new LinkedList<Atraccion>();
	}

	public int getDescuentoPorcentual() {
		return descuentoPorcentual;
	}

	public void setDescuentoPorcentual(int descuentoPorcentual) {
		this.descuentoPorcentual = descuentoPorcentual;
	}

	public double getCosto(Atraccion atraccion) {

		double descuento = 0;
		double costoAtraccion = atraccion.getCosto();

		if(atracciones.contains(atraccion)){
			
			descuento = costoAtraccion * descuentoPorcentual / 100;
		}
		
		return costoAtraccion - descuento;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

}
