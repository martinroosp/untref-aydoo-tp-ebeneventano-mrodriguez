package untref.aydoo.tierramedia.test.usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.Usuario;

public class UsuarioPuedeVisitarTest {

	private Usuario usuario;
	private Atraccion atraccion;

	@Before
	public void before() {

		usuario = new Usuario();
		atraccion = new Atraccion();

		usuario.setPresupuesto(2000);
		usuario.setCoordenadas(new Coordenada(0, 0));
		usuario.setMinutosDisponibles(60);
		usuario.setVelocidadDeTraslado(5); // Una persona promedio camina a 5 km/h

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
