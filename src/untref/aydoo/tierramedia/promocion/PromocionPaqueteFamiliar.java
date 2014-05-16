package untref.aydoo.tierramedia.promocion;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;

public class PromocionPaqueteFamiliar extends Promocion{
	
	public PromocionPaqueteFamiliar(){
		super();
	}

	public double getCosto(Atraccion unaAtraccion, int cantidadDeEntradas) {
		double costo = 0.0;
		if(this.atracciones.contains(unaAtraccion)){
			if(cantidadDeEntradas < 4){
				costo = unaAtraccion.getCosto() * cantidadDeEntradas;
			}else{
				int cantidadCon30Porciento = cantidadDeEntradas - 4;
				costo = unaAtraccion.getCosto()*4 - unaAtraccion.getCosto()*4/10 + 
					this.getCostoEntradasCon30Porciento(cantidadCon30Porciento, unaAtraccion.getCosto());
			}
		}else{
			costo = unaAtraccion.getCosto() * cantidadDeEntradas;
		}
		return costo;
	}

	private double getCostoEntradasCon30Porciento(int cantidadCon30Porciento, double costo) {
		double costoTotalEntradasCon30Porciento = 0.0;
		if(cantidadCon30Porciento > 0){
			costoTotalEntradasCon30Porciento = costo*cantidadCon30Porciento - costo*cantidadCon30Porciento*3/10;
		}
		return costoTotalEntradasCon30Porciento;
	}

}
