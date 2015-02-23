// Librerías a utilizar **********************************

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;

/**
* Clase Recomienda
* Tabla RECOMIENDA
*
* Se refiere a la recomendendacion que hace un usuario a otro 
* sobre una promocion
*/
@Entity
@Table(name="RECOMENDACION")
public class Recomendacion {
// Atributos ********************************************************//
	
		// Código único que sirve para identificar a una recomendacion
	    @Id
	    @Column(name="RECOMCOD", nullable = false)
	    @GeneratedValue
	    private int RECOMCOD;

		@OneToOne //Usuario que recomienda la promocion
		private Usuario recomienda;
		@OneToOne //Usuario recomendado
		private Usuario recomendado;
		@OneToOne //Promocion recomendada
		private Promocion promocion;
		
// Getters and Setters *******************************************
		public int getRECOMCOD() {
			return RECOMCOD;
		}
		public void setRECOMCOD(int rECOMCOD) {
			RECOMCOD = rECOMCOD;
		}
		public Usuario getRecomienda() {
			return recomienda;
		}
		public void setRecomienda(Usuario recomienda) {
			this.recomienda = recomienda;
		}
		public Usuario getRecomendado() {
			return recomendado;
		}
		public void setRecomendado(Usuario recomendado) {
			this.recomendado = recomendado;
		}
		public Promocion getPromocion() {
			return promocion;
		}
		public void setPromocion(Promocion promocion) {
			this.promocion = promocion;
		}
		
	


}
	

	
