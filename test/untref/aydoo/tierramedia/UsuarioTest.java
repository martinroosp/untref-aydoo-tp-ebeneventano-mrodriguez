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
	public void puedeVisitarDeberiaRetornarVerdaderoSiCumpleCondiciones() {
		
		Atraccion atraccion = new Atraccion();
		
		Assert.assertTrue(usuario.puedeVisitar(atraccion));

	}
}
