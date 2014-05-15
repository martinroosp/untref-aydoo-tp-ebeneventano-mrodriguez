package untref.aydoo.tierramedia.test.promocion;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.promocion.PromocionAbsoluta;
import untref.aydoo.tierramedia.promocion.PromocionPorcentual;

public class PromocionPorcentualTest {

	private final static double DELTA = 0.001;

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
	public void getValorRetornaCostoConDescuentoSiPaqueteTieneAtraccionesNecesarias() {

		PromocionPorcentual promocion = new PromocionPorcentual();
		promocion.setPeriodoVigencia(new Date());
		promocion.setDescuentoPorcentual(0.25);

		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();

		atraccion1.setCosto(150);
		atraccion2.setCosto(80);

		promocion.getAtracciones().add(atraccion1);
		promocion.getAtracciones().add(atraccion2);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		paquete.add(atraccion1);
		paquete.add(atraccion2);

		Assert.assertEquals(172.5, promocion.getCosto(paquete), DELTA);
	}

	@Test
	public void getValorRetornaCostoDeLasAtraccionesSiPaqueteNoTieneAtraccionesNecesarias() {

		PromocionPorcentual promocion = new PromocionPorcentual();
		promocion.setPeriodoVigencia(new Date());
		promocion.setDescuentoPorcentual(0.25);

		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		Atraccion atraccion3 = new Atraccion();
		
		atraccion1.setCosto(150);
		atraccion2.setCosto(80);
		atraccion3.setCosto(120);

		promocion.getAtracciones().add(atraccion1);
		promocion.getAtracciones().add(atraccion2);
		promocion.getAtracciones().add(atraccion3);

		List<Atraccion> paquete = new LinkedList<Atraccion>();
		paquete.add(atraccion1);
		paquete.add(atraccion2);

		Assert.assertEquals(230, promocion.getCosto(paquete), DELTA);
	}

}
