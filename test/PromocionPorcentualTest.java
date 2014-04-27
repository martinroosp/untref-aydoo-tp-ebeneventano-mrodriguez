import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tierramedia.Atraccion;
import untref.aydoo.tierramedia.Coordenada;
import untref.aydoo.tierramedia.TipoDeAtraccion;
import untref.aydoo.tierramedia.Usuario;
import untref.aydoo.tierramedia.promocion.PromocionPorcentual;

public class PromocionPorcentualTest {

	private Usuario usuario;
	List<Atraccion> atracciones;
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
		atraccionPorDefecto.setNombre("Atracción por defecto");
		atraccionPorDefecto.setTipo(TipoDeAtraccion.AVENTURA);

		atracciones.add(atraccionPorDefecto);

	}

	@Test
	public void getCostoDeberiaRetornarCostoConDescuento() {

		PromocionPorcentual promocion = new PromocionPorcentual();

		promocion.setDescuento(25);
		promocion.getAtracciones().add(atraccionPorDefecto);

		Assert.assertEquals(525, Math.round(promocion.getCosto(atraccionPorDefecto)));

	}

}
