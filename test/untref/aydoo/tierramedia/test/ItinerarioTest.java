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
	public void crearAtraccionPorDefecto() {
		this.atraccionPorDefecto = new Atraccion();
		this.atraccionPorDefecto.setCoordenadas(new Coordenada(0, 0));
		this.atraccionPorDefecto.setCosto(1700);
		this.atraccionPorDefecto.setCupoDeVisitantesDiarios(10);
		this.atraccionPorDefecto.setMinutosNecesarios(20);
		this.atraccionPorDefecto.setNombre("Atraccion por defecto");
		this.atraccionPorDefecto.setTipo(TipoDeAtraccion.AVENTURA);

		this.otraAtraccionPorDefecto = new Atraccion();
		this.otraAtraccionPorDefecto.setCoordenadas(new Coordenada(10, 0));
		this.otraAtraccionPorDefecto.setCosto(1000);
		this.otraAtraccionPorDefecto.setCupoDeVisitantesDiarios(20);
		this.otraAtraccionPorDefecto.setMinutosNecesarios(40);
		this.otraAtraccionPorDefecto.setNombre("Otra Atraccion por defecto");
		this.otraAtraccionPorDefecto.setTipo(TipoDeAtraccion.DEGUSTACION);

		this.atraccionesItinerario = new ArrayList<Atraccion>();
		this.atraccionesItinerario.add(this.atraccionPorDefecto);
		this.atraccionesItinerario.add(this.otraAtraccionPorDefecto);
	}

	@Test
	public void ordenarAtraccionesPorCostoDebeDevolverLaAtraccionPorDefectoPrimero() {
		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);
		itinerario.getAtracciones().add(this.otraAtraccionPorDefecto);

		itinerario.ordenarAtraccionesPorCosto();

		Assert.assertEquals(this.atraccionPorDefecto, itinerario
				.getAtracciones().get(0));
	}

	@Test
	public void ordenarAtraccionesPorCostoDebeMantenerOrdenSiAtraccionesIguales() {

		Itinerario itinerario = new Itinerario();

		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		Atraccion atraccion3 = new Atraccion();

		itinerario.getAtracciones().add(atraccion1);
		itinerario.getAtracciones().add(atraccion2);
		itinerario.getAtracciones().add(atraccion3);

		itinerario.ordenarAtraccionesPorCosto();

		Assert.assertEquals(atraccion1, itinerario.getAtracciones().get(0));
		Assert.assertEquals(atraccion2, itinerario.getAtracciones().get(1));
		Assert.assertEquals(atraccion3, itinerario.getAtracciones().get(2));
	}

	@Test
	public void ordenarAtraccionesPorPreferenciaDebeDevolverLaOtraAtraccionPorDefectoPrimero() {
		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);
		itinerario.getAtracciones().add(this.otraAtraccionPorDefecto);

		itinerario
				.ordenarAtraccionesPorPreferencia(TipoDeAtraccion.DEGUSTACION);

		Assert.assertEquals(this.otraAtraccionPorDefecto, itinerario
				.getAtracciones().get(0));
	}

	@Test
	public void ordenarAtraccionesPorPreferenciaDebeMantenerOrdenSiAtraccionesIguales() {

		Itinerario itinerario = new Itinerario();

		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		Atraccion atraccion3 = new Atraccion();

		itinerario.getAtracciones().add(atraccion1);
		itinerario.getAtracciones().add(atraccion2);
		itinerario.getAtracciones().add(atraccion3);

		itinerario.ordenarAtraccionesPorPreferencia(TipoDeAtraccion.AVENTURA);

		Assert.assertEquals(atraccion1, itinerario.getAtracciones().get(0));
		Assert.assertEquals(atraccion2, itinerario.getAtracciones().get(1));
		Assert.assertEquals(atraccion3, itinerario.getAtracciones().get(2));
	}

	@Test
	public void ordenarAtraccionesPorCercaniaDebeDevolverLaOtraAtraccionPorDefectoPrimero() {
		
		Itinerario itinerario = new Itinerario();
		
		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		Atraccion atraccion3 = new Atraccion();
		
		atraccion1.setCoordenadas(new Coordenada(10, 0));
		atraccion2.setCoordenadas(new Coordenada(20, 0));
		atraccion3.setCoordenadas(new Coordenada(5, 0));
	
		itinerario.getAtracciones().add(atraccion1);
		itinerario.getAtracciones().add(atraccion2);
		itinerario.getAtracciones().add(atraccion3);

		itinerario.ordenarAtraccionesPorCercania(new Coordenada(0, 0));

		Assert.assertEquals(atraccion3, itinerario
				.getAtracciones().get(0));
	}

	@Test
	public void ordenarAtraccionesPorCercaniaDebeMantenerOrdenSiAtraccionesIguales() {

		Itinerario itinerario = new Itinerario();

		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		Atraccion atraccion3 = new Atraccion();

		atraccion1.setCoordenadas(new Coordenada(0, 0));
		atraccion2.setCoordenadas(new Coordenada(0, 0));
		atraccion3.setCoordenadas(new Coordenada(0, 0));

		itinerario.getAtracciones().add(atraccion1);
		itinerario.getAtracciones().add(atraccion2);
		itinerario.getAtracciones().add(atraccion3);

		itinerario.ordenarAtraccionesPorCercania(new Coordenada(0, 0));

		Assert.assertEquals(atraccion1, itinerario.getAtracciones().get(0));
		Assert.assertEquals(atraccion2, itinerario.getAtracciones().get(1));
		Assert.assertEquals(atraccion3, itinerario.getAtracciones().get(2));
	}

}
