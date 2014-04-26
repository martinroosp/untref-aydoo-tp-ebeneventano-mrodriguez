package untref.aydoo.tierramedia;

public class Usuario {

	private double presupuesto;
	private int minutosDisponibles;
	private double velocidadDeTraslado;
	private TipoDeAtraccion tipoDeAtraccionPreferida;
	private Coordenada ubicacion;
	private Perfil perfil;

	public boolean puedeVisitar(Atraccion atraccion) {

		return this.getPresupuesto() >= atraccion.getCosto();
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

}
