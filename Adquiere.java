import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
* Clase Publicacion
* Tabla PUBLICACION
*
* Se refiere a la publicacion de un anuncio 'x' de una promocion 'y'
* por una empresa 'z'
*/
@Entity
@Table(name="ADQUIERE")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Adquiere {
	// Código único que sirve para identificar a una adquisición o compra 
    @Id
    @Column(name="CODIGOCOMPRA", nullable = false)
    @GeneratedValue
    private int CodigoCompra;
    
    @Column(name= "CALIFICACION")
    @Min(1)
    @Max(5)
    private int Calificacion;
    
    @Column(name= "COMENTARIO")
    @Size(
    		max = 500)
    private String Comentario;
    
    @OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne (orphanRemoval = true) //Promocion publicada por una empresa
	private Usuario usuario;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne (orphanRemoval = true) //Empresa que publica la promocion
	private Promocion promocion;

	// Getters and Setters *****************************************************// 
	public int getCodigoCompra() {
		return CodigoCompra;
	}

	public void setCodigoCompra(int codigoCompra) {
		CodigoCompra = codigoCompra;
	}

	public int getCalificacion() {
		return Calificacion;
	}

	public void setCalificacion(int calificacion) {
		Calificacion = calificacion;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		if (!promocion.isValida()) {
			throw new IllegalArgumentException("No se puede adquirir una promoción cancelada o eliminada");
		}
		this.promocion = promocion;
	}
	
	

}
