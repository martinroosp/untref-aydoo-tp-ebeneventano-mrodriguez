package untref.aydoo.tierramedia.test.usuario;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.Usuario;
import untref.aydoo.tierramedia.Visita;

public class UsuarioTest {

	final double DELTA = 0.001;

	private Usuario usuario;
	List<Atraccion> atracciones;
	private Atraccion atraccionCara;
	private Atraccion atraccionBarata;
	private Atraccion atraccionPorDefecto;

	@Before
	public void before() {

		usuario = new Usuario();
		atracciones = new LinkedList<Atraccion>();

		usuario.setCoordenadas(new Coordenada(0, 0));
		usuario.setMinutosDisponibles(60);
		usuario.setPresupuesto(5000);
		usuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.DEGUSTACION);
		usuario.setVelocidadDeTraslado(5);

		/*
		 * Llenado de atracciones.
		 */
		atraccionPorDefecto = new Atraccion();
		atraccionPorDefecto.setCoordenadas(new Coordenada(0, 0));
		atraccionPorDefecto.setCosto(700);
		atraccionPorDefecto.setCupoDeVisitantesDiarios(10);
		atraccionPorDefecto.setMinutosNecesarios(20);
		atraccionPorDefecto.setNombre("Atraccion por defecto");
		atraccionPorDefecto.setTipo(TipoDeAtraccion.AVENTURA);

		atraccionCara = new Atraccion();
		atraccionCara.setCoordenadas(new Coordenada(0, 0));
		atraccionCara.setCosto(1000);
		atraccionCara.setCupoDeVisitantesDiarios(10);
		atraccionCara.setMinutosNecesarios(20);
		atraccionCara.setNombre("Atraccion cara");
		atraccionCara.setTipo(TipoDeAtraccion.DEGUSTACION);

		atraccionBarata = new Atraccion();
		atraccionBarata.setCoordenadas(new Coordenada(0, 0));
		atraccionBarata.setCosto(500);
		atraccionBarata.setCupoDeVisitantesDiarios(10);
		atraccionBarata.setMinutosNecesarios(20);
		atraccionBarata.setNombre("Atraccion barata");
		atraccionBarata.setTipo(TipoDeAtraccion.PAISAJE);

		atracciones.add(atraccionPorDefecto);
		atracciones.add(atraccionCara);
		atracciones.add(atraccionBarata);
	}

	@Test
	public void getPresupuesto() {

		double presupuesto = 1000;
		usuario.setPresupuesto(presupuesto);
		Assert.assertEquals(presupuesto, usuario.getPresupuesto(), DELTA);
	}

	@Test
	public void getVelocidadDeTraslado() {

		double velocidadDeTraslado = 1000;
		usuario.setVelocidadDeTraslado(velocidadDeTraslado);
		Assert.assertEquals(velocidadDeTraslado,
				usuario.getVelocidadDeTraslado(), DELTA);
	}

	@Test
	public void getMinutosDisponibles() {

		int minutosDisponibles = 120;
		usuario.setMinutosDisponibles(minutosDisponibles);
		Assert.assertEquals(minutosDisponibles, usuario.getMinutosDisponibles());
	}

	@Test
	public void getCoordenadas() {

		Coordenada coordenadas = new Coordenada(100, 150);
		usuario.setCoordenadas(coordenadas);
		Assert.assertEquals(coordenadas, usuario.getCoordenadas());
	}

	@Test
	public void getTipoDeAtraccionPreferida() {

		TipoDeAtraccion tipoDeAtraccionPreferida = TipoDeAtraccion.AVENTURA;
		usuario.setTipoDeAtraccionPreferida(tipoDeAtraccionPreferida);
		Assert.assertEquals(tipoDeAtraccionPreferida,
				usuario.getTipoDeAtraccionPreferida());
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornarVisita() {

		Visita visitaSugerida = usuario.getVisitaSugerida(atracciones);

		Assert.assertNotNull(visitaSugerida);
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornarVisitaConPrimerAtraccionCara() {

		Visita visitaSugerida = usuario.getVisitaSugerida(atracciones);
		visitaSugerida.getItinerario().ordenarAtraccionesPorCosto();

		Assert.assertSame(atraccionCara, visitaSugerida.getItinerario()
				.getAtracciones().get(0));
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornar2VisitasPosibles() {

		Visita visitaSugerida = usuario.getVisitaSugerida(atracciones);
		visitaSugerida.getItinerario().ordenarAtraccionesPorCosto();

		Assert.assertEquals(3, visitaSugerida.getItinerario().getAtracciones()
				.size());
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornarVisitaConPrimerAtraccionPreferida() {

		Visita visitaSugerida = usuario.getVisitaSugerida(atracciones);
		visitaSugerida.getItinerario().ordenarAtraccionesPorPreferencia(
				usuario.getTipoDeAtraccionPreferida());

		Assert.assertEquals(usuario.getTipoDeAtraccionPreferida(),
				visitaSugerida.getItinerario().getAtracciones().get(0)
						.getTipo());
	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiPresupuestoEsSuficiente() {

		Assert.assertTrue(usuario.puedeVisitar(atraccionPorDefecto));
	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiPresupuestoEsInsuficiente() {

		usuario.setPresupuesto(500);

		Assert.assertFalse(usuario.puedeVisitar(atraccionPorDefecto));
	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiDistanciaEsAlcanzable() {

		Assert.assertTrue(usuario.puedeVisitar(atraccionPorDefecto));

	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiDistanciaEsInalcanzable() {

		usuario.setCoordenadas(new Coordenada(100, 0));

		Assert.assertFalse(usuario.puedeVisitar(atraccionPorDefecto));
	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiTiempoEsSuficiente() {

		atraccionPorDefecto.setMinutosNecesarios(10);

		Assert.assertTrue(usuario.puedeVisitar(atraccionPorDefecto));
	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiTiempoEsInsuficiente() {

		atraccionPorDefecto.setMinutosNecesarios(100);

		Assert.assertFalse(usuario.puedeVisitar(atraccionPorDefecto));
	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiTiempoDelUsuarioEsInsuficiente() {

		atraccionPorDefecto.setMinutosNecesarios(10);
		usuario.setMinutosDisponibles(0);

		Assert.assertFalse(usuario.puedeVisitar(atraccionPorDefecto));
	}

	@Test
	public void getVisitaSugeridaNoDeberiaExcederElTiempoDisponibleDelUsuario() {

		Atraccion atraccion;
		usuario = new Usuario();
		atracciones = new LinkedList<Atraccion>();

		usuario.setCoordenadas(new Coordenada(0, 0));
		usuario.setMinutosDisponibles(10);
		usuario.setPresupuesto(5000);
		usuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.DEGUSTACION);
		usuario.setVelocidadDeTraslado(5);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(5);
		atraccion.setNombre("A1");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		atracciones.add(atraccion);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(5);
		atraccion.setNombre("A2");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		atracciones.add(atraccion);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(5);
		atraccion.setNombre("A3");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		atracciones.add(atraccion);

		Visita visitaSugerida = usuario.getVisitaSugerida(atracciones);

		Assert.assertTrue(visitaSugerida.getItinerario().getAtracciones()
				.size() < 3);
		Assert.assertEquals(2, visitaSugerida.getItinerario().getAtracciones()
				.size());
	}

	@Test
	public void getVisitaSugeridaNoDeberiaExcederDistanciaAlcanzable() {

		Atraccion atraccion;
		usuario = new Usuario();
		atracciones = new LinkedList<Atraccion>();

		usuario.setCoordenadas(new Coordenada(0, 0));
		usuario.setMinutosDisponibles(10);
		usuario.setPresupuesto(5000);
		usuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.DEGUSTACION);
		usuario.setVelocidadDeTraslado(5);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(0);
		atraccion.setNombre("A1");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		atracciones.add(atraccion);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(0);
		atraccion.setNombre("A2");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		atracciones.add(atraccion);

		atraccion = new Atraccion();
		// Atracción inalcanzable.
		atraccion.setCoordenadas(new Coordenada(1000, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(0);
		atraccion.setNombre("A3");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		atracciones.add(atraccion);

		Visita visitaSugerida = usuario.getVisitaSugerida(atracciones);

		Assert.assertTrue(visitaSugerida.getItinerario().getAtracciones()
				.size() < 3);
		Assert.assertEquals(2, visitaSugerida.getItinerario().getAtracciones()
				.size());
	}

}
