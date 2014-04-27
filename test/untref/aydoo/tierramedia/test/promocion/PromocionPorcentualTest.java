package untref.aydoo.tierramedia.test.promocion;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.promocion.PromocionPorcentual;

public class PromocionPorcentualTest {

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
	public void getCostoDeberiaRetornarCostoConDescuento() {

		PromocionPorcentual promocion = new PromocionPorcentual();

		promocion.setDescuentoPorcentual(25);
		promocion.getAtracciones().add(atraccionPorDefecto);

		Assert.assertEquals(525,
				Math.round(promocion.getCosto(atraccionPorDefecto)));

	}

}
