package untref.aydoo.tierramedia;

import java.util.Date;

import untref.aydoo.tierramedia.exception.PromocionVencidaException;

public abstract class Promocion {

	private Date periodoVigencia;

	public Date getPeriodoVigencia() {
		return periodoVigencia;
	}

	public void setPeriodoVigencia(Date periodoVigencia) {
		this.periodoVigencia = periodoVigencia;
	}

	public void getCosto() throws PromocionVencidaException {
		// Si ha pasado el dia de vencimiento
		if (this.periodoVigencia.compareTo(new Date()) > 0) {
			throw new PromocionVencidaException();
		}

	}

}
