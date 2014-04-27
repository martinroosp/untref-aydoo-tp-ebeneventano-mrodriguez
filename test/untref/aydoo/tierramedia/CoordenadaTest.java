package untref.aydoo.tierramedia;

import junit.framework.Assert;

import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void distancia() {

		Coordenada origen = new Coordenada(41.57879, 1.617221);
		Coordenada destino = new Coordenada(37.176487, -3.597929);

		Assert.assertEquals(664, Math.round(origen.distancia(destino)), 1);
	}

}
