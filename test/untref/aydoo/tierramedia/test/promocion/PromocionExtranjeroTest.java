package untref.aydoo.tierramedia.test.promocion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.Usuario;
import untref.aydoo.tierramedia.promocion.PromocionExtranjero;

public class PromocionExtranjeroTest {
	
	private Atraccion atraccionA;
	private Atraccion atraccionB;
	private Atraccion atraccionC;

	@Before
	public void before() {

		atraccionA = new Atraccion();
		atraccionB = new Atraccion();
		atraccionC = new Atraccion();

		atraccionA.setCosto(100);
		//Coordenadas temaiken
		atraccionA.setCoordenadas(new Coordenada(-34.365953, -58.806653));
		atraccionA.setNombre("Temaiken");
		
		atraccionB.setCosto(200);
		//Coordenadas glaciar perito moreno
		atraccionB.setCoordenadas(new Coordenada(-32.9271118, -68.7838236));
		atraccionB.setNombre("Glaciar Perito Moreno");
		
		atraccionC.setCosto(300);
		//Coordenadas aeroparque jorge newbery
		atraccionC.setCoordenadas(new Coordenada(-34.55803, -58.417009));
		atraccionC.setNombre("Aeroparque Jorge Newbery");
	}

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
	
	@Test
	public void aeroparqueJorgeNewberyEsLaAtraccionMasCercanaAlUsuario(){
		Usuario usuario = new Usuario();
		//Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -34.603711;
		double longitudUsuario = -58.381585;
		
		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario, longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);
		
		int distanciaUsuarioAJorgeNewbery = atraccionC.calcularDistanciaAUsuario(latitudUsuario, longitudUsuario, 'K');
		
		PromocionExtranjero promocionExt = new PromocionExtranjero();
		promocionExt.setAtraccionAPromocion(atraccionA);
		promocionExt.setAtraccionAPromocion(atraccionB);
		promocionExt.setAtraccionAPromocion(atraccionC);
		
		Assert.assertEquals(distanciaUsuarioAJorgeNewbery, 
				promocionExt.obtenerDistanciaMasCercanaAUsuario(usuario));
	}
	
	@Test
	public void costoAtraccionDebeSerElMismoSiElUsuarioEstaAMenosDe200Km(){
		Usuario usuario = new Usuario();
		//Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -34.603711;
		double longitudUsuario = -58.381585;
		
		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario, longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);
		
		PromocionExtranjero promocionExt = new PromocionExtranjero();
		promocionExt.setAtraccionAPromocion(atraccionA);
		promocionExt.setAtraccionAPromocion(atraccionB);
		promocionExt.setAtraccionAPromocion(atraccionC);
		
		double precio = atraccionC.getCosto();
		Assert.assertEquals(precio, promocionExt.getCosto(atraccionC, usuario),0);
	}
	
	@Test
	public void costoAtraccionDebeSerEl50PorcientoMenosSiElUsuarioEstaAMenosDe200Km(){
		Usuario usuario = new Usuario();
		//Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -23.1934449;
		double longitudUsuario = -65.6961709;
		
		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario, longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);
		
		PromocionExtranjero promocionExt = new PromocionExtranjero();
		promocionExt.setAtraccionAPromocion(atraccionA);
		promocionExt.setAtraccionAPromocion(atraccionB);
		promocionExt.setAtraccionAPromocion(atraccionC);
		
		double precio = atraccionC.getCosto() / 2;
		Assert.assertEquals(precio, promocionExt.getCosto(atraccionC, usuario),0);
	}
}
