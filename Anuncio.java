// Librerías a utilizar **********************************

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
    @Column(name="NIVEL")
    private String nivel;
    
	// Monto que corresponde a realizar dicho anuncio con dicho nivel.
    @Column(name="TARIFA")
    @Min(0)
    private int tarifa;
    
    // Descripción de los beneficios otorgados por el nivel de anuncio.
	@Column(name="DESCRIPCION")
    private String descripcion;
	
// Getters and Setters *******************************************
	
    public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
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