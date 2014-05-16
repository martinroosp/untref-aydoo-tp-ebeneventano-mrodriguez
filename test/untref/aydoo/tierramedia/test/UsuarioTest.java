package untref.aydoo.tierramedia.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.Itinerario;
import untref.aydoo.tierramedia.Promocion;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.Usuario;
import untref.aydoo.tierramedia.Visita;
import untref.aydoo.tierramedia.promocion.PromocionAxB;

public class UsuarioTest {

	private final static double DELTA = 0.001;

	private Usuario usuario;
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;
	private Atraccion atraccionCara;
	private Atraccion atraccionBarata;
	private Atraccion atraccionPorDefecto;

	@Before
	public void before() {

		this.usuario = new Usuario();
		this.atracciones = new LinkedList<Atraccion>();
		this.promociones = new LinkedList<Promocion>();

		this.usuario.setCoordenadas(new Coordenada(0, 0));
		this.usuario.setMinutosDisponibles(60);
		this.usuario.setPresupuesto(5000);
		this.usuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.DEGUSTACION);
		this.usuario.setVelocidadDeTraslado(5);

		/*
		 * Llenado de atracciones.
		 */
		this.atraccionPorDefecto = new Atraccion();
		this.atraccionPorDefecto.setCoordenadas(new Coordenada(0, 0));
		this.atraccionPorDefecto.setCosto(700);
		this.atraccionPorDefecto.setCupoDeVisitantesDiarios(10);
		this.atraccionPorDefecto.setMinutosNecesarios(20);
		this.atraccionPorDefecto.setNombre("Atraccion por defecto");
		this.atraccionPorDefecto.setTipo(TipoDeAtraccion.AVENTURA);

		this.atraccionCara = new Atraccion();
		this.atraccionCara.setCoordenadas(new Coordenada(0, 0));
		this.atraccionCara.setCosto(1000);
		this.atraccionCara.setCupoDeVisitantesDiarios(10);
		this.atraccionCara.setMinutosNecesarios(20);
		this.atraccionCara.setNombre("Atraccion cara");
		this.atraccionCara.setTipo(TipoDeAtraccion.DEGUSTACION);

		this.atraccionBarata = new Atraccion();
		this.atraccionBarata.setCoordenadas(new Coordenada(0, 0));
		this.atraccionBarata.setCosto(500);
		this.atraccionBarata.setCupoDeVisitantesDiarios(10);
		this.atraccionBarata.setMinutosNecesarios(20);
		this.atraccionBarata.setNombre("Atraccion barata");
		this.atraccionBarata.setTipo(TipoDeAtraccion.PAISAJE);

		this.atracciones.add(this.atraccionPorDefecto);
		this.atracciones.add(this.atraccionCara);
		this.atracciones.add(this.atraccionBarata);
	}

	@Test
	public void getPresupuesto() {

		double presupuesto = 1000;
		this.usuario.setPresupuesto(presupuesto);
		Assert.assertEquals(presupuesto, this.usuario.getPresupuesto(), DELTA);
	}

	@Test
	public void getVelocidadDeTraslado() {

		double velocidadDeTraslado = 1000;
		this.usuario.setVelocidadDeTraslado(velocidadDeTraslado);
		Assert.assertEquals(velocidadDeTraslado,
				this.usuario.getVelocidadDeTraslado(), DELTA);
	}

	@Test
	public void getMinutosDisponibles() {

		int minutosDisponibles = 120;
		this.usuario.setMinutosDisponibles(minutosDisponibles);
		Assert.assertEquals(minutosDisponibles,
				this.usuario.getMinutosDisponibles());
	}

	@Test
	public void getCoordenadas() {

		Coordenada coordenadas = new Coordenada(100, 150);
		this.usuario.setCoordenadas(coordenadas);
		Assert.assertEquals(coordenadas, this.usuario.getCoordenadas());
	}

	@Test
	public void getTipoDeAtraccionPreferida() {

		TipoDeAtraccion tipoDeAtraccionPreferida = TipoDeAtraccion.AVENTURA;
		this.usuario.setTipoDeAtraccionPreferida(tipoDeAtraccionPreferida);
		Assert.assertEquals(tipoDeAtraccionPreferida,
				this.usuario.getTipoDeAtraccionPreferida());
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornarVisita() {

		Visita visitaSugerida = this.usuario.getVisitaSugerida(
				this.atracciones, this.promociones);

		Assert.assertNotNull(visitaSugerida);
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornarVisitaConPrimerAtraccionCara() {

		Visita visitaSugerida = this.usuario.getVisitaSugerida(
				this.atracciones, this.promociones);
		visitaSugerida.getItinerario().ordenarAtraccionesPorCosto();

		Assert.assertSame(this.atraccionCara, visitaSugerida.getItinerario()
				.getAtracciones().get(0));
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornar2VisitasPosibles() {

		Visita visitaSugerida = this.usuario.getVisitaSugerida(
				this.atracciones, this.promociones);
		visitaSugerida.getItinerario().ordenarAtraccionesPorCosto();

		Assert.assertEquals(3, visitaSugerida.getItinerario().getAtracciones()
				.size());
	}

	@Test
	public void getVisitaSugeridaDeberiaRetornarVisitaConPrimerAtraccionPreferida() {

		Visita visitaSugerida = this.usuario.getVisitaSugerida(
				this.atracciones, this.promociones);
		visitaSugerida.getItinerario().ordenarAtraccionesPorPreferencia(
				this.usuario.getTipoDeAtraccionPreferida());

		Assert.assertEquals(this.usuario.getTipoDeAtraccionPreferida(),
				visitaSugerida.getItinerario().getAtracciones().get(0)
						.getTipo());
	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiPresupuestoEsSuficiente() {

		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);

		Assert.assertTrue(this.usuario.puedeVisitar(itinerario));
	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiPresupuestoEsInsuficiente() {

		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);

		this.usuario.setPresupuesto(500);

		Assert.assertFalse(this.usuario.puedeVisitar(itinerario));
	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiDistanciaEsAlcanzable() {

		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);

		Assert.assertTrue(this.usuario.puedeVisitar(itinerario));
	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiDistanciaEsInalcanzable() {

		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);

		this.usuario.setCoordenadas(new Coordenada(100, 0));

		Assert.assertFalse(this.usuario.puedeVisitar(itinerario));
	}

	@Test
	public void puedeVisitarDeberiaRetornarVerdaderoSiTiempoEsSuficiente() {

		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);

		this.atraccionPorDefecto.setMinutosNecesarios(10);

		Assert.assertTrue(this.usuario.puedeVisitar(itinerario));
	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiTiempoEsInsuficiente() {

		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);

		this.atraccionPorDefecto.setMinutosNecesarios(100);

		Assert.assertFalse(this.usuario.puedeVisitar(itinerario));
	}

	@Test
	public void puedeVisitarDeberiaRetornarFalsoSiTiempoDelUsuarioEsInsuficiente() {

		Itinerario itinerario = new Itinerario();
		itinerario.getAtracciones().add(this.atraccionPorDefecto);

		this.atraccionPorDefecto.setMinutosNecesarios(10);
		this.usuario.setMinutosDisponibles(0);

		Assert.assertFalse(this.usuario.puedeVisitar(itinerario));
	}

	@Test
	public void getVisitaSugeridaNoDeberiaExcederElTiempoDisponibleDelUsuario() {

		Atraccion atraccion;
		this.usuario = new Usuario();
		this.atracciones = new LinkedList<Atraccion>();

		this.usuario.setCoordenadas(new Coordenada(0, 0));
		this.usuario.setMinutosDisponibles(10);
		this.usuario.setPresupuesto(5000);
		this.usuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.DEGUSTACION);
		this.usuario.setVelocidadDeTraslado(5);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(5);
		atraccion.setNombre("A1");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		this.atracciones.add(atraccion);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(5);
		atraccion.setNombre("A2");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		this.atracciones.add(atraccion);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(5);
		atraccion.setNombre("A3");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		this.atracciones.add(atraccion);

		Visita visitaSugerida = this.usuario.getVisitaSugerida(
				this.atracciones, this.promociones);

		Assert.assertTrue(visitaSugerida.getItinerario().getAtracciones()
				.size() < 3);
		Assert.assertEquals(2, visitaSugerida.getItinerario().getAtracciones()
				.size());
	}

	@Test
	public void getVisitaSugeridaNoDeberiaExcederDistanciaAlcanzable() {

		Atraccion atraccion;
		this.usuario = new Usuario();
		this.atracciones = new LinkedList<Atraccion>();

		this.usuario.setCoordenadas(new Coordenada(0, 0));
		this.usuario.setMinutosDisponibles(10);
		this.usuario.setPresupuesto(5000);
		this.usuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.DEGUSTACION);
		this.usuario.setVelocidadDeTraslado(5);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(0);
		atraccion.setNombre("A1");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		this.atracciones.add(atraccion);

		atraccion = new Atraccion();
		atraccion.setCoordenadas(new Coordenada(0, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(0);
		atraccion.setNombre("A2");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		this.atracciones.add(atraccion);

		atraccion = new Atraccion();
		// Atracción inalcanzable.
		atraccion.setCoordenadas(new Coordenada(1000, 0));
		atraccion.setCosto(1);
		atraccion.setCupoDeVisitantesDiarios(10);
		atraccion.setMinutosNecesarios(0);
		atraccion.setNombre("A3");
		atraccion.setTipo(TipoDeAtraccion.AVENTURA);
		this.atracciones.add(atraccion);

		Visita visitaSugerida = this.usuario.getVisitaSugerida(
				this.atracciones, this.promociones);

		Assert.assertTrue(visitaSugerida.getItinerario().getAtracciones()
				.size() < 3);
		Assert.assertEquals(2, visitaSugerida.getItinerario().getAtracciones()
				.size());
	}

	@Test
	public void getVisitaSugeridaDeberiaDevolverVisitaConPromocion() {

		this.usuario = new Usuario();
		this.usuario.setCoordenadas(new Coordenada(0, 0));

		Atraccion atraccionA = new Atraccion();
		Atraccion atraccionB = new Atraccion();
		Atraccion atraccionC = new Atraccion();

		atraccionA.setCoordenadas(new Coordenada(0, 0));
		atraccionB.setCoordenadas(new Coordenada(0, 0));
		atraccionC.setCoordenadas(new Coordenada(0, 0));

		PromocionAxB promocion = new PromocionAxB();

		promocion.setPeriodoVigencia(new Date());

		promocion.getNecesarias().add(atraccionA);
		promocion.getNecesarias().add(atraccionB);
		promocion.getBonificadas().add(atraccionC);

		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(atraccionA);
		atracciones.add(atraccionB);
		atracciones.add(atraccionC);

		List<Promocion> promociones = new LinkedList<Promocion>();
		promociones.add(promocion);

		Visita visitaSugerida = this.usuario.getVisitaSugerida(atracciones,
				promociones);

		Assert.assertFalse(promocion.vencida());
		Assert.assertTrue(visitaSugerida.getPromociones().contains(promocion));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getVisitaSugeridaNoContienePromocionSiEstaVencida() {

		this.usuario = new Usuario();
		this.usuario.setCoordenadas(new Coordenada(0, 0));

		Atraccion atraccionA = new Atraccion();
		Atraccion atraccionB = new Atraccion();
		Atraccion atraccionC = new Atraccion();

		atraccionA.setCoordenadas(new Coordenada(0, 0));
		atraccionB.setCoordenadas(new Coordenada(0, 0));
		atraccionC.setCoordenadas(new Coordenada(0, 0));

		PromocionAxB promocion = new PromocionAxB();

		promocion.setPeriodoVigencia(new Date(1900, 01, 01));

		promocion.getNecesarias().add(atraccionA);
		promocion.getNecesarias().add(atraccionB);
		promocion.getBonificadas().add(atraccionC);

		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(atraccionA);
		atracciones.add(atraccionB);
		atracciones.add(atraccionC);

		List<Promocion> promociones = new LinkedList<Promocion>();
		promociones.add(promocion);

		Visita visitaSugerida = this.usuario.getVisitaSugerida(atracciones,
				promociones);

		Assert.assertTrue(promocion.vencida());
		Assert.assertFalse(visitaSugerida.getPromociones().contains(promocion));
	}

}
