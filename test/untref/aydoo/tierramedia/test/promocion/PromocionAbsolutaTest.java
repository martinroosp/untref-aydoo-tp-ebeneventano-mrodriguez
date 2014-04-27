package untref.aydoo.tierramedia.test.promocion;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.promocion.PromocionAbsoluta;

public class PromocionAbsolutaTest {

	private Atraccion atraccionPorDefecto;

	@Before
	public void before() {

		atraccionPorDefecto = new Atraccion();
		atraccionPorDefecto.setCoordenadas(new Coordenada(0, 0));
		atraccionPorDefecto.setCosto(700);
		atraccionPorDefecto.setCupoDeVisitantesDiarios(10);
		atraccionPorDefecto.setMinutosNecesarios(20);
		atraccionPorDefecto.setNombre("Atracción por defecto");
		atraccionPorDefecto.setTipo(TipoDeAtraccion.AVENTURA);
	}

	@Test
	public void getCostoDeberiaRetornarValorPromocion() throws Exception {

		PromocionAbsoluta promocion = new PromocionAbsoluta();

		promocion.setValor(250);
		promocion.getAtracciones().add(atraccionPorDefecto);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		paquete.add(atraccionPorDefecto);

		Assert.assertEquals(250, Math.round(promocion.getCosto(paquete)));

	}

	@Test(expected = Exception.class)
	public void getCostoDeberiaRetornarExcepcionSiPromocionNoContemplaPaquete()
			throws Exception {

		PromocionAbsoluta promocion = new PromocionAbsoluta();

		promocion.setValor(250);
		promocion.getAtracciones().add(atraccionPorDefecto);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		// paquete.add(atraccionPorDefecto);

		promocion.getCosto(paquete);

	}

}
