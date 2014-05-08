package untref.aydoo.tierramedia;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Promocion {

	private Date periodoVigencia;
	protected List<Atraccion> atracciones;

	public Promocion() {

		atracciones = new LinkedList<Atraccion>();
	}

	public Date getPeriodoVigencia() {

		return periodoVigencia;
	}

	public void setPeriodoVigencia(Date periodoVigencia) {

		this.periodoVigencia = periodoVigencia;
	}

	public void getCosto() {

	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public boolean vencida() {

		// Si ha pasado el dia de vencimiento
		return (this.periodoVigencia.compareTo(new Date()) > 0);
	}

}
