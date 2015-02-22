// Librerías a utilizar **********************************

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;

/**
* Clase Publica
* Tabla Publica
*
* Se refiere a la publicacion de un anuncio 'x' de una promocion 'y'
* por una empresa 'z'
*/
@Entity
@Table(name="PUBLICACION")
public class Publicacion {
// Atributos ********************************************************//
	
		// Código único que sirve para identificar a una publicacion
	    @Id
	    @Column(name="PUBLICOD", nullable = false)
	    @GeneratedValue
	    private int PUBLICOD;

		@OneToOne //Promocion publicada por una empresa
		private Promocion promocion;
		@OneToOne //Empresa que publica la promocion
		private Empresa empresa;
		@OneToOne //Una promocion puede tener solo un Anuncio
		private Anuncio anuncio;
		
// Getters and Setters *******************************************	
		public Promocion getPromocion() {
			return promocion;
		}
		public void setPromocion(Promocion promocion) {
			this.promocion = promocion;
		}
		public Empresa getEmpresa() {
			return empresa;
		}
		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}
		public Anuncio getAnuncio() {
			return anuncio;
		}
		public void setAnuncio(Anuncio anuncio) {
			this.anuncio = anuncio;
		}

}
	

	
