package untref.aydoo.tierramedia.test;

import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.Itinerario;
import untref.aydoo.tierramedia.TipoDeAtraccion;

public class ItinerarioTest {
	
	private Atraccion atraccionPorDefecto;
	private Atraccion otraAtraccionPorDefecto;
	private List<Atraccion> atraccionesItinerario;

	@Before
	public void crearAtraccionPorDefecto(){
		atraccionPorDefecto = new Atraccion();
		atraccionPorDefecto.setCoordenadas(new Coordenada(0, 0));
		atraccionPorDefecto.setCosto(1700);
		atraccionPorDefecto.setCupoDeVisitantesDiarios(10);
		atraccionPorDefecto.setMinutosNecesarios(20);
		atraccionPorDefecto.setNombre("Atraccion por defecto");
		atraccionPorDefecto.setTipo(TipoDeAtraccion.AVENTURA);
		
		otraAtraccionPorDefecto = new Atraccion();
		otraAtraccionPorDefecto.setCoordenadas(new Coordenada(10, 0));
		otraAtraccionPorDefecto.setCosto(1000);
		otraAtraccionPorDefecto.setCupoDeVisitantesDiarios(20);
		otraAtraccionPorDefecto.setMinutosNecesarios(40);
		otraAtraccionPorDefecto.setNombre("Otra Atraccion por defecto");
		otraAtraccionPorDefecto.setTipo(TipoDeAtraccion.DEGUSTACION);
		
		atraccionesItinerario = new ArrayList<Atraccion>();
		atraccionesItinerario.add(atraccionPorDefecto);
		atraccionesItinerario.add(otraAtraccionPorDefecto);
	}

	@Test
	public void ordenarAtraccionesPorCostoDebeDevolverLaAtraccionPorDefectoPrimero(){
		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(atraccionPorDefecto);
		itinerario.getAtracciones().add(otraAtraccionPorDefecto);
		
		itinerario.ordenarAtraccionesPorCosto();
		
		Assert.assertEquals(atraccionPorDefecto, itinerario.getAtracciones().get(0));
	}
	
	@Test
	public void ordenarAtraccionesPorPreferenciaDebeDevolverLaOtraAtraccionPorDefectoPrimero(){
		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(atraccionPorDefecto);
		itinerario.getAtracciones().add(otraAtraccionPorDefecto);
		
		itinerario.ordenarAtraccionesPorPreferencia(TipoDeAtraccion.DEGUSTACION);
		
		Assert.assertEquals(otraAtraccionPorDefecto, itinerario.getAtracciones().get(0));
	}
}
