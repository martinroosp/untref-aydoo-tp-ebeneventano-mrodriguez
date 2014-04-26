package untref.aydoo.tierramedia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneradorDeSugerenciasTest {

	private GeneradorDeSugerencias generadorDeSugerencias;
	private Usuario usuario;
	private double distanciaMaximaEnMetros;

	@Before
	public void before() {

		generadorDeSugerencias = new GeneradorDeSugerencias();
		usuario = new Usuario();
		distanciaMaximaEnMetros = 1000;
		generadorDeSugerencias
				.setDistanciaMaximaEnMetros(distanciaMaximaEnMetros);

	}

	@Test
	public void generarSugerencia() {

		Visita visitaSugerida = generadorDeSugerencias.sugerirVisita(usuario);

		Assert.assertNotNull(visitaSugerida);

	}

	@Test
	public void sugerirVisitaDeberiaRetornarVisitaConDistanciaMaximaMenorAMaximaSugerida() {

		Visita visitaSugerida = generadorDeSugerencias.sugerirVisita(usuario);

		Assert.assertTrue(visitaSugerida.getDistanciaMaxima() <= generadorDeSugerencias
				.getDistanciaMaximaEnMetros());

	}

}
