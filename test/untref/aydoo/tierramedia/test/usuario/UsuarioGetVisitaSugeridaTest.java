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

public class UsuarioGetVisitaSugeridaTest {

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
		visitaSugerida.getItinerario().ordenarAtraccionesPorPreferencia(usuario.getTipoDeAtraccionPreferida());

		Assert.assertEquals(usuario.getTipoDeAtraccionPreferida(),
				visitaSugerida.getItinerario().getAtracciones().get(0)
						.getTipo());
	}

}
