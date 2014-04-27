package untref.aydoo.tierramedia.test.usuario;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.Usuario;
import untref.aydoo.tierramedia.Visita;

public class UsuarioGetVisitaSugeridaTest {

	private Usuario usuario;
	List<Atraccion> atracciones;
	private Atraccion atraccionCara;
	private Atraccion atraccionBarata;

	@Before
	public void before() {

		usuario = new Usuario();
		atracciones = new LinkedList<Atraccion>();

		usuario.setPresupuesto(5000);
		usuario.setCoordenadas(new Coordenada(0, 0));

		/*
		 * Llenado de atracciones.
		 */
		atraccionCara = new Atraccion();
		atraccionCara.setNombre("Atracción cara");
		atraccionCara.setCosto(1000);
		atraccionCara.setCoordenadas(new Coordenada(0, 0));

		atraccionBarata = new Atraccion();
		atraccionBarata.setNombre("Atracción barata");
		atraccionBarata.setCosto(500);
		atraccionBarata.setCoordenadas(new Coordenada(0, 0));

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
		visitaSugerida.getItinerario().sortAtraccionesPorCosto();

		Assert.assertSame(atraccionCara, visitaSugerida.getItinerario()
				.getAtracciones().get(0));
	}

}
