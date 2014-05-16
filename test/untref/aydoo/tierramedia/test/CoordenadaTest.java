package untref.aydoo.tierramedia.test;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tierramedia.Coordenada;

public class CoordenadaTest {

	@Test
	public void distancia() {

		Coordenada origen = new Coordenada(41.57879, 1.617221);
		Coordenada destino = new Coordenada(37.176487, -3.597929);

		Assert.assertEquals(664, Math.round(origen.distancia(destino)), 1);
	}

}
