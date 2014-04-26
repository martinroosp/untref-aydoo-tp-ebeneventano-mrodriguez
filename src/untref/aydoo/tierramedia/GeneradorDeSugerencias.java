package untref.aydoo.tierramedia;

import java.util.LinkedList;
import java.util.List;

public class GeneradorDeSugerencias {

	private double distanciaMaximaEnMetros;
	private List<Atraccion> atracciones;

	public GeneradorDeSugerencias() {

		this.atracciones = new LinkedList<Atraccion>();
	}

	public Visita sugerirVisita(Usuario usuario) {
		return new Visita();
	}

	public double getDistanciaMaximaEnMetros() {
		return distanciaMaximaEnMetros;
	}

	public void setDistanciaMaximaEnMetros(double distanciaMaximaEnMetros) {
		this.distanciaMaximaEnMetros = distanciaMaximaEnMetros;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

}
