package untref.aydoo.tierramedia.test.promocion;
import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.Usuario;

public class PromocionExtranjeroTest {

	@Test
	public void testLocacionDelClienteMayorA200Km(){
		Usuario usuario = new Usuario();
		//Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -34.603711;
		double longitudUsuario = -58.381585;
		
		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario, longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);
		
		Atraccion atraccion = new Atraccion();
		
		//Latitud y longitud de la estatua de la libertad
		double latitudAtraccion = 40.689249;
		double longitudAtraccion = -74.0445;
		Coordenada coordenadaAtraccion = new Coordenada(latitudAtraccion, longitudAtraccion);
		atraccion.setCoordenadas(coordenadaAtraccion);
		
		Assert.assertTrue(atraccion.calcularDistanciaAUsuario(usuario.getCoordenadas().getLatitud(), 
				usuario.getCoordenadas().getLongitud(), 'K') > 200);
	}
}
