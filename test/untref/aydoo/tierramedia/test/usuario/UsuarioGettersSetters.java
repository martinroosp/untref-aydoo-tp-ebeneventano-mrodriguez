package untref.aydoo.tierramedia.test.usuario;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.Usuario;

public class UsuarioGettersSetters {

	private Usuario usuario;

	@Before
	public void test() {

		usuario = new Usuario();
	}

	@Test
	public void getPresupuesto() {

		double presupuesto = 1000;
		usuario.setPresupuesto(presupuesto);
		Assert.assertEquals(presupuesto, usuario.getPresupuesto());
	}
	
	@Test
	public void getVelocidadDeTraslado() {

		double velocidadDeTraslado = 1000;
		usuario.setVelocidadDeTraslado(velocidadDeTraslado);
		Assert.assertEquals(velocidadDeTraslado, usuario.getVelocidadDeTraslado());
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
		Assert.assertEquals(tipoDeAtraccionPreferida, usuario.getTipoDeAtraccionPreferida());
	}
	
}
