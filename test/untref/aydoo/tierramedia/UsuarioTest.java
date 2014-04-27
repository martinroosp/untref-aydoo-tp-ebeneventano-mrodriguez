package untref.aydoo.tierramedia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario usuario;
	private Atraccion atraccion;

	@Before
	public void before() {

		usuario = new Usuario();
		atraccion = new Atraccion();

		usuario.setPresupuesto(2000);
		usuario.setCoordenadas(new Coordenada(0, 0));
		usuario.setMinutosDisponibles(60);
		
		// Una persona promedio camina a 5 km/h
		usuario.setVelocidadDeTraslado(5);

		atraccion.setCosto(1000);
		atraccion.setCoordenadas(new Coordenada(0, 0));

	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiPresupuestoEsSuficiente() {

		Assert.assertTrue(usuario.puedeVisitar(atraccion));

	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiPresupuestoEsInsuficiente() {

		usuario.setPresupuesto(500);

		Assert.assertFalse(usuario.puedeVisitar(atraccion));

	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiDistanciaEsAlcanzable() {

		Assert.assertTrue(usuario.puedeVisitar(atraccion));

	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiDistanciaEsInalcanzable() {

		usuario.setCoordenadas(new Coordenada(100, 0));

		Assert.assertFalse(usuario.puedeVisitar(atraccion));

	}
	
	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiTiempoEsSuficiente() {

		atraccion.setMinutosNecesarios(10);

		Assert.assertTrue(usuario.puedeVisitar(atraccion));

	}
	
	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiTiempoEsInsuficiente() {

		atraccion.setMinutosNecesarios(100);

		Assert.assertFalse(usuario.puedeVisitar(atraccion));

	}
	
	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiTiempoDelUsuarioEsInsuficiente() {

		atraccion.setMinutosNecesarios(10);
		usuario.setMinutosDisponibles(0);

		Assert.assertFalse(usuario.puedeVisitar(atraccion));

	}

}
