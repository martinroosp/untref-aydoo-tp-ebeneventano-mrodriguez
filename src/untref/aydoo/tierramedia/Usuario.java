package untref.aydoo.tierramedia;

public class Usuario {

	private double presupuesto;
	private int minutosDisponibles;
	private double velocidadDeTraslado; // en Km/hora
	private TipoDeAtraccion tipoDeAtraccionPreferida;
	private Coordenada ubicacion;
	private Perfil perfil;

	public boolean puedeVisitar(Atraccion atraccion) {

		boolean presupuestoSuficiente = this.getPresupuesto() >= atraccion
				.getCosto();
		boolean distanciaAlcanzable = getVelocidadDeTraslado() / 60
				* getMinutosDisponibles() >= getDistancia(atraccion);

		return presupuestoSuficiente && distanciaAlcanzable;
	}

	public double getDistancia(Atraccion atraccion) {

		double catetoLatitud = (ubicacion.getLatitud() - atraccion
				.getCoordenadasGlobalesDePosicionamiento().getLatitud());
		double catetoLongitud = (ubicacion.getLongitud() - atraccion
				.getCoordenadasGlobalesDePosicionamiento().getLongitud());
		double hipotenusa = Math.sqrt(Math.pow(catetoLatitud, 2)
				+ Math.pow(catetoLongitud, 2));

		return hipotenusa;

	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Coordenada getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Coordenada ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getVelocidadDeTraslado() {
		return velocidadDeTraslado;
	}

	public void setVelocidadDeTraslado(double velocidadDeTraslado) {
		this.velocidadDeTraslado = velocidadDeTraslado;
	}

	public int getMinutosDisponibles() {
		return minutosDisponibles;
	}

	public void setMinutosDisponibles(int minutosDisponibles) {
		this.minutosDisponibles = minutosDisponibles;
	}

}
