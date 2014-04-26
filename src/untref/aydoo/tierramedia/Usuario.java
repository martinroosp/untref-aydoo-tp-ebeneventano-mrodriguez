package untref.aydoo.tierramedia;

public class Usuario {

	private double presupuesto;
	private int minutosDisponibles;
	private double velocidadDeTraslado; // en km/hora
	private TipoDeAtraccion tipoDeAtraccionPreferida;
	private Coordenada ubicacion;
	private Perfil perfil;

	public boolean puedeVisitar(Atraccion atraccion) {

		boolean presupuestoSuficiente = this.getPresupuesto() >= atraccion
				.getCosto();
		boolean distanciaAlcanzable = getVelocidadDeTraslado() / 60
				* getMinutosDisponibles() >= getDistancia(atraccion);
		boolean tiempoSuficiente = (this.minutosDisponibles - this
				.tiempoParaLlegar(atraccion)) >= atraccion
				.getMinutosNecesarios();

		return presupuestoSuficiente && distanciaAlcanzable && tiempoSuficiente;
	}

	private int tiempoParaLlegar(Atraccion atraccion) {

		return (int) ((int) getDistancia(atraccion) / (velocidadDeTraslado / 60));
	}

	public double getDistancia(Atraccion atraccion) {

		double catetoLatitud = (ubicacion.getLatitud() - atraccion
				.getCoordenadas().getLatitud());
		double catetoLongitud = (ubicacion.getLongitud() - atraccion
				.getCoordenadas().getLongitud());
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
