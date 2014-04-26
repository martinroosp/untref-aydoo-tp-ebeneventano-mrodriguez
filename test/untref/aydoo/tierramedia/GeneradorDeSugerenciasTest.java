package untref.aydoo.tierramedia;

import org.junit.Test;

public class GeneradorDeSugerenciasTest {

	@Test
	public void generarSugerencia() {
		
		GeneradorDeSugerencias generadorDeSugerencias = new GeneradorDeSugerencias();
		Usuario usuario = new Usuario();
				
		Visita visitaSugerida = generadorDeSugerencias.sugerirVisita(usuario);

	}

}
