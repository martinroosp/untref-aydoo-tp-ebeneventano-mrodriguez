package untref.aydoo.tierramedia.promocion;

import java.util.Iterator;
import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;
import untref.aydoo.tierramedia.Usuario;

public class PromocionExtranjero extends Promocion {

	// Devuelve la distacia mas cercana del usuario a una atraccion
	public int obtenerDistanciaMasCercanaAUsuario(Usuario usuario) {
		int distancia = ((Atraccion) getAtracciones().get(0))
				.calcularDistanciaAUsuario(usuario.getCoordenadas()
						.getLatitud(), usuario.getCoordenadas().getLongitud(),
						'K');
		Iterator<Atraccion> it = getAtracciones().iterator();
		while (it.hasNext()) {
			Atraccion unaAtraccion = (Atraccion) it.next();
			int distanciaAUsuario = unaAtraccion.calcularDistanciaAUsuario(
					usuario.getCoordenadas().getLatitud(), usuario
							.getCoordenadas().getLongitud(), 'K');
			if (distanciaAUsuario < distancia) {
				distancia = distanciaAUsuario;
			}
		}
		return distancia;
	}

	public void setAtraccionAPromocion(Atraccion atraccion) {
		this.getAtracciones().add(atraccion);
	}

	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public double getCosto(List<Atraccion> paquete, Usuario usuario) {

		double descuento = 0;
		double costoTotal = 0;

		for (Atraccion unaAtraccion : paquete) {
			costoTotal += unaAtraccion.getCosto();
		}
		
		if (this.obtenerDistanciaMasCercanaAUsuario(usuario) > 200) {

			descuento = costoTotal * 50 / 100;
		}

		return costoTotal - descuento;
	}
}
