package untref.aydoo.tierramedia.test.promocion;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.promocion.PromocionAbsoluta;

public class PromocionAbsolutaTest {

	private final static double DELTA = 0.001;

	private Atraccion atraccionPorDefecto;

	@Before
	public void before() {

		atraccionPorDefecto = new Atraccion();
		atraccionPorDefecto.setCoordenadas(new Coordenada(0, 0));
		atraccionPorDefecto.setCosto(700);
		atraccionPorDefecto.setCupoDeVisitantesDiarios(10);
		atraccionPorDefecto.setMinutosNecesarios(20);
		atraccionPorDefecto.setNombre("Atraccion por defecto");
		atraccionPorDefecto.setTipo(TipoDeAtraccion.AVENTURA);
	}

	@Test
	public void getCostoDeberiaRetornarValorPromocion() throws Exception {

		PromocionAbsoluta promocion = new PromocionAbsoluta();
		promocion.setPeriodoVigencia(new Date());

		promocion.setValor(250);
		promocion.getAtracciones().add(atraccionPorDefecto);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		paquete.add(atraccionPorDefecto);

		Assert.assertEquals(250, Math.round(promocion.getCosto(paquete)));

	}

	@Test
	public void getCostoDeberiaRetornarLaSumaTotalDeTodasLasAtraccionesYaQueNoAplicaPromocion() {

		PromocionAbsoluta promocion = new PromocionAbsoluta();
		promocion.setPeriodoVigencia(new Date());

		promocion.setValor(250);
		promocion.getAtracciones().add(atraccionPorDefecto);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		Atraccion atraccionNueva = new Atraccion();
		atraccionNueva.setCoordenadas(new Coordenada(0, 0));
		atraccionNueva.setCosto(500);
		atraccionNueva.setCupoDeVisitantesDiarios(10);
		atraccionNueva.setMinutosNecesarios(20);
		atraccionNueva.setNombre("Atraccion por defecto");
		atraccionNueva.setTipo(TipoDeAtraccion.AVENTURA);
		paquete.add(atraccionNueva);

		Assert.assertEquals(500.0, promocion.getCosto(paquete), DELTA);
	}

	@Test
	public void vencidaDeberiaRetornarTrueSiPromocionEstaVencida() {

		PromocionAbsoluta promocion = new PromocionAbsoluta();
		promocion.setPeriodoVigencia(new Date(2014, 04, 24));

		Assert.assertTrue(promocion.vencida());

	}

}
