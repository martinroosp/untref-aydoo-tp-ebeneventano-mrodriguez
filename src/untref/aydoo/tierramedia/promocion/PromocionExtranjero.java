package untref.aydoo.tierramedia.promocion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Promocion;
import untref.aydoo.tierramedia.Usuario;

public class PromocionExtranjero extends Promocion{

	private List<Atraccion> listaAtracciones;
	
	public PromocionExtranjero (){
		listaAtracciones = new ArrayList<Atraccion>();
	}
	
	//Devuelve la distacia mas cercana del usuario a una atraccion
	public int obtenerDistanciaMasCercanaAUsuario(Usuario usuario){
		int distancia = ((Atraccion)listaAtracciones.get(0)).calcularDistanciaAUsuario(usuario.getCoordenadas().getLatitud(), 
				usuario.getCoordenadas().getLongitud(), 'K');
		Iterator<Atraccion> it = listaAtracciones.iterator();
		while (it.hasNext()){
			Atraccion unaAtraccion = (Atraccion) it.next();
			int distanciaAUsuario = unaAtraccion.calcularDistanciaAUsuario(usuario.getCoordenadas().getLatitud(), 
					usuario.getCoordenadas().getLongitud(), 'K');
			if(distanciaAUsuario < distancia){
				distancia = distanciaAUsuario;
			}
		}
		return distancia;
	}
	
	public void setAtraccionAPromocion(Atraccion atraccion){
		this.listaAtracciones.add(atraccion);
	}
	
	public List<Atraccion> getAtracciones(){
		return this.listaAtracciones;
	}
}
