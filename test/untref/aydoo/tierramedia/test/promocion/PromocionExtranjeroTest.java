package untref.aydoo.tierramedia.test.promocion;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.Usuario;
import untref.aydoo.tierramedia.promocion.PromocionExtranjero;

public class PromocionExtranjeroTest {

	private final static double DELTA = 0.001;

	private Atraccion atraccionA;
	private Atraccion atraccionB;
	private Atraccion atraccionC;

	@Before
	public void before() {

		this.atraccionA = new Atraccion();
		this.atraccionB = new Atraccion();
		this.atraccionC = new Atraccion();

		this.atraccionA.setCosto(100);
		// Coordenadas temaiken
		this.atraccionA.setCoordenadas(new Coordenada(-34.365953, -58.806653));
		this.atraccionA.setNombre("Temaiken");

		this.atraccionB.setCosto(200);
		// Coordenadas glaciar perito moreno
		this.atraccionB
				.setCoordenadas(new Coordenada(-32.9271118, -68.7838236));
		this.atraccionB.setNombre("Glaciar Perito Moreno");

		this.atraccionC.setCosto(300);
		// Coordenadas aeroparque jorge newbery
		this.atraccionC.setCoordenadas(new Coordenada(-34.55803, -58.417009));
		this.atraccionC.setNombre("Aeroparque Jorge Newbery");
	}

	@Test
	public void testLocacionDelClienteMayorA200Km() {
		Usuario usuario = new Usuario();
		// Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -34.603711;
		double longitudUsuario = -58.381585;

		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario,
				longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);

		Atraccion atraccion = new Atraccion();

		// Latitud y longitud de la estatua de la libertad
		double latitudAtraccion = 40.689249;
		double longitudAtraccion = -74.0445;
		Coordenada coordenadaAtraccion = new Coordenada(latitudAtraccion,
				longitudAtraccion);
		atraccion.setCoordenadas(coordenadaAtraccion);

		Assert.assertTrue(atraccion.getCoordenadas().distancia(
				usuario.getCoordenadas()) > 200);
	}

	@Test
	public void aeroparqueJorgeNewberyEsLaAtraccionMasCercanaAlUsuario() {
		Usuario usuario = new Usuario();
		// Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -34.603711;
		double longitudUsuario = -58.381585;

		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario,
				longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);

		double distanciaUsuarioAJorgeNewbery = this.atraccionC.getCoordenadas()
				.distancia(usuario.getCoordenadas());

		PromocionExtranjero promocionExt = new PromocionExtranjero();
		promocionExt.setAtraccionAPromocion(this.atraccionA);
		promocionExt.setAtraccionAPromocion(this.atraccionB);
		promocionExt.setAtraccionAPromocion(this.atraccionC);

		Assert.assertEquals(distanciaUsuarioAJorgeNewbery,
				promocionExt.obtenerDistanciaMasCercanaAUsuario(usuario), DELTA);
	}

	@Test
	public void costoAtraccionDebeSerElMismoSiElUsuarioEstaAMenosDe200Km() {
		Usuario usuario = new Usuario();
		// Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -34.603711;
		double longitudUsuario = -58.381585;

		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario,
				longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);

		PromocionExtranjero promocionExt = new PromocionExtranjero();

		promocionExt.setAtraccionAPromocion(this.atraccionA);
		promocionExt.setAtraccionAPromocion(this.atraccionB);
		promocionExt.setAtraccionAPromocion(this.atraccionC);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		paquete.add(this.atraccionA);
		paquete.add(this.atraccionB);
		paquete.add(this.atraccionC);

		Assert.assertEquals(600, promocionExt.getCosto(paquete, usuario), 0);
	}

	@Test
	public void costoAtraccionDebeSerEl50PorcientoMenosSiElUsuarioEstaAMenosDe200Km() {
		Usuario usuario = new Usuario();
		// Latitud y longitud de la ubicacion del obelisco
		double latitudUsuario = -23.1934449;
		double longitudUsuario = -65.6961709;

		Coordenada coordenadaUsuario = new Coordenada(latitudUsuario,
				longitudUsuario);
		usuario.setCoordenadas(coordenadaUsuario);

		PromocionExtranjero promocionExt = new PromocionExtranjero();

		promocionExt.setAtraccionAPromocion(this.atraccionA);
		promocionExt.setAtraccionAPromocion(this.atraccionB);
		promocionExt.setAtraccionAPromocion(this.atraccionC);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		paquete.add(this.atraccionA);
		paquete.add(this.atraccionB);
		paquete.add(this.atraccionC);

		Assert.assertEquals(300, promocionExt.getCosto(paquete, usuario), 0);
	}

}
