package untref.aydoo.tierramedia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneradorDeSugerenciasTest {

	private GeneradorDeSugerencias generadorDeSugerencias;
	private Usuario usuario;
	private Atraccion atraccionCara;
	private Atraccion atraccionBarata;

	@Before
	public void before() {

		generadorDeSugerencias = new GeneradorDeSugerencias();
		usuario = new Usuario();

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

		generadorDeSugerencias.getAtracciones().add(atraccionCara);
		generadorDeSugerencias.getAtracciones().add(atraccionBarata);

	}

	@Test
	public void generarSugerencia() {

		Visita visitaSugerida = generadorDeSugerencias.sugerirVisita(usuario);

		Assert.assertNotNull(visitaSugerida);

	}

	@Test
	public void sugerirVisitaDeberiaRetornarVisitaConPrimerAtraccionCara() {

		generadorDeSugerencias.sortAtraccionesPorCosto();
		Visita visitaSugerida = generadorDeSugerencias.sugerirVisita(usuario);

		Assert.assertSame(atraccionCara, visitaSugerida.getItinerario()
				.getAtracciones().get(0));

	}

}
