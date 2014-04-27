package untref.aydoo.tierramedia.test.promocion;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.promocion.PromocionAxB;

public class PromocionAxBTest {

	private Atraccion atraccionA;
	private Atraccion atraccionB;
	private Atraccion atraccionC;

	@Before
	public void before() {

		atraccionA = new Atraccion();
		atraccionB = new Atraccion();
		atraccionC = new Atraccion();

		atraccionA.setCosto(100);
		atraccionB.setCosto(200);
		atraccionC.setCosto(300);
	}

	@Test
	public void getCostoDeberiaRetornarCostoBonificado() throws Exception {

		PromocionAxB promocion = new PromocionAxB();

		promocion.getNecesarias().add(atraccionA);
		promocion.getNecesarias().add(atraccionB);
		promocion.getBonificadas().add(atraccionC);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		paquete.add(atraccionA);
		paquete.add(atraccionB);
		paquete.add(atraccionC);

		Assert.assertEquals(300, Math.round(promocion.getCosto(paquete)));

	}

}
