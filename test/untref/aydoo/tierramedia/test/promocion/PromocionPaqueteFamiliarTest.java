package untref.aydoo.tierramedia.test.promocion;

import junit.framework.Assert;

import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.promocion.PromocionPaqueteFamiliar;

public class PromocionPaqueteFamiliarTest {
	
	@Test
	public void comprarTresEntradasDeLaMismaAtraccionDebeSalirCostoPorTres(){
		Atraccion unaAtraccion = new Atraccion();
		unaAtraccion.setCosto(100.0);
		
		PromocionPaqueteFamiliar promoFamilia = new PromocionPaqueteFamiliar();
		promoFamilia.getAtracciones().add(unaAtraccion);

		Assert.assertEquals(300.0, promoFamilia.getCosto(unaAtraccion, 3));
	}

	@Test
	public void comprarCuatroEntradasDeUnaAtraccionDebeAplicar10PorcientoDeDescuento(){
		Atraccion unaAtraccion = new Atraccion();
		unaAtraccion.setCosto(100.0);
		
		PromocionPaqueteFamiliar promoFamilia = new PromocionPaqueteFamiliar();
		promoFamilia.getAtracciones().add(unaAtraccion);

		Assert.assertEquals(360.0, promoFamilia.getCosto(unaAtraccion, 4));
	}
	
	@Test
	public void comprarCincoEntradasDeUnaAtraccionDebeAplicar10PorcientoACuatroY30PorcientoALaQuinta(){
		Atraccion unaAtraccion = new Atraccion();
		unaAtraccion.setCosto(100.0);
		
		PromocionPaqueteFamiliar promoFamilia = new PromocionPaqueteFamiliar();
		promoFamilia.getAtracciones().add(unaAtraccion);

		Assert.assertEquals(430.0, promoFamilia.getCosto(unaAtraccion, 5));
	}
	
	@Test
	public void comprarSieteEntradasDeUnaAtraccionDebeAplicar10PorcientoACuatroY30PorcientoALasDemas(){
		Atraccion unaAtraccion = new Atraccion();
		unaAtraccion.setCosto(100.0);

		PromocionPaqueteFamiliar promoFamilia = new PromocionPaqueteFamiliar();
		promoFamilia.getAtracciones().add(unaAtraccion);
		
		Assert.assertEquals(570.0, promoFamilia.getCosto(unaAtraccion, 7));
	}
	
	@Test
	public void comprar10EntradasDeAtraccionQueNoEstaEnPromoDevuelveCostoPor10(){
		Atraccion unaAtraccion = new Atraccion();
		unaAtraccion.setCosto(100.0);

		PromocionPaqueteFamiliar promoFamilia = new PromocionPaqueteFamiliar();
		
		Assert.assertEquals(1000.0, promoFamilia.getCosto(unaAtraccion, 10));		
	}
}
