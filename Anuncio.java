// Librerías a utilizar **********************************

import javax.validation.constraints.*;
import javax.persistence.*;

/**
* Clase Anuncio
* Tabla ANUNCIO
*
* Se refiere a las compañías que utilizan el portal para 
* publicar las promociones ofrecidas por las mismas.
*/
@Entity
@Table(name="ANUNCIO")
public class Anuncio {
 
	// Nivel del anuncio. Puede ser Oro, Plata o Bronce
	@Id
	@Enumerated(EnumType.STRING)
    @Column(name="NIVEL", nullable = false)
    private Nivel nivel;
    
	// Monto que corresponde a realizar dicho anuncio con dicho nivel.
    @Column(name="TARIFA", nullable = false)
    @Min(
    		value = 0,
    		message = "La tarifa de un anuncio debe ser positiva")
    private int tarifa;
    
    // Descripción de los beneficios otorgados por el nivel de anuncio.
	@Column(name="DESCRIPCION", nullable = false)
	@Size(
			max = 500,
			message = "La descripción del anuncio puede contener hasta 500 caracteres")
    private String descripcion;
	
	public Anuncio(Nivel nivel, int tarifa, String descripcion) {
		this.nivel = nivel;
		this.tarifa = tarifa;
		this.descripcion = descripcion;
	}
	
// Getters and Setters *******************************************
	
    public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}