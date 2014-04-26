package untref.aydoo.tierramedia;

public class GeneradorDeSugerencias {

	private double distanciaMaximaEnMetros;

	public Visita sugerirVisita(Usuario usuario) {
		return new Visita();
	}

	public double getDistanciaMaximaEnMetros() {
		return distanciaMaximaEnMetros;
	}

	public void setDistanciaMaximaEnMetros(double distanciaMaximaEnMetros) {
		this.distanciaMaximaEnMetros = distanciaMaximaEnMetros;
	}

}
