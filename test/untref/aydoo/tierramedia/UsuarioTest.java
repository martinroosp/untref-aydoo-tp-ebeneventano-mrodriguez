package untref.aydoo.tierramedia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario usuario;

	@Before
	public void before() {

		usuario = new Usuario();

	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiPresupuestoEsSuficiente() {

		Atraccion atraccion = new Atraccion();
		atraccion.setCosto(1000);

		usuario.setPresupuesto(2000);

		Assert.assertTrue(usuario.puedeVisitar(atraccion));

	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiPresupuestoEsInsuficiente() {

		Atraccion atraccion = new Atraccion();
		atraccion.setCosto(1000);

		usuario.setPresupuesto(500);

		Assert.assertFalse(usuario.puedeVisitar(atraccion));

	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiDistanciaEsAlcanzable() {

		Atraccion atraccion = new Atraccion();
		atraccion.setCoordenadasGlobalesDePosicionamiento(new Coordenada(0, 0));

		usuario.setUbicacion(new Coordenada(0, 0));

		Assert.assertTrue(usuario.puedeVisitar(atraccion));

	}

}
