package untref.aydoo.tierramedia.test;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;

public class AtraccionTest {

	@Test
	public void testSettersGetters() {

		Atraccion atraccion = new Atraccion();

		String setString = "String.";
		int setInteger = 5;

		atraccion.setNombre(setString);
		atraccion.setCupoDeVisitantesDiarios(setInteger);

		Assert.assertEquals(setString, atraccion.getNombre());
		Assert.assertEquals(setInteger, atraccion.getCupoDeVisitantesDiarios());
	}

}
