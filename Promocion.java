// Librerías a utilizar *********************************

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
 
/**
* Clase Promocion 
* Tabla PROMOCION
*
* Ofertas de bienes o servicios publicados por las empresas 
* en el portal.
*/
@Entity
@Table(name="PROMOCION")
public class Promocion {
 
    @Id
    @Column(name="PROMOCOD")
    @GeneratedValue
    private int promoCod;
 
	@Column(name="DESCRIPCION")
    private String descripcion;
     
    @Column(name="MONTO_ORIGINAL")
    private int monto_original;
    
    @Column(name="MONTO_OFERTADO")
    private int monto_ofertado;
    
    @Column(name="FECHA_INI")
    private Date fecha_ini;
    
    @Column(name="FECHA_FIN")
    private Date fecha_fin;
    
    @Column(name="CONDICIONES")
    private String condiciones;
    
    @Column(name="CANTIDAD_TOTAL")
    private int cantidad_total;
    
    @Column(name="CANTIDAD_USUARIO")
    private int cantidad_usuario;
    
    @Column(name="IMAGEN")
    private String imagen;
    
    @Column(name="LINK_INFORMACION")
    private String link_informacion;
    
    @Column(name="ETIQUETAS")
    private String etiquetas;
    

	//Mapeando desde Meeting, y meeting tiene un set de empleados 
    @ManyToMany(mappedBy="promociones") //Se debe colocar el nombre del set de meetings que se creo en Employee
    private Set<Usuario> usuarios = new HashSet<Usuario>();
     

    
    // Constructor de la clase 
    public Promocion(String descripcion, int monto_original,
			int monto_ofertado, Date fecha_ini, Date fecha_fin,
			String condiciones, int cantidad_total, int cantidad_usuario,
			String imagen, String link_informacion, String etiquetas) {
		this.descripcion = descripcion;
		this.monto_original = monto_original;
		this.monto_ofertado = monto_ofertado;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.condiciones = condiciones;
		this.cantidad_total = cantidad_total;
		this.cantidad_usuario = cantidad_usuario;
		this.imagen = imagen;
		this.link_informacion = link_informacion;
		this.etiquetas = etiquetas;
	} // Cierre del constructor


// Getters and Setters **********************************
    
 	public String getCondiciones() {
 		return condiciones;
 	}
 	
 	public int getCantidad_total() {
 		return cantidad_total;
 	}

 	public int getCantidad_usuario() {
 		return cantidad_usuario;
 	}

 	public String getImagen() {
 		return imagen;
 	}

 	public Set<Usuario> getUsuarios() {
 		return usuarios;
 	}


 	public void setCondiciones(String condiciones) {
 		this.condiciones = condiciones;
 	}


 	public void setCantidad_total(int cantidad_total) {
 		this.cantidad_total = cantidad_total;
 	}


 	public void setCantidad_usuario(int cantidad_usuario) {
 		this.cantidad_usuario = cantidad_usuario;
 	}


 	public void setImagen(String imagen) {
 		this.imagen = imagen;
 	}

 	
 	public void setUsuarios(Set<Usuario> usuarios) {
 		this.usuarios = usuarios;
 	}
	public String getLink_informacion() {
		return link_informacion;
	}


	public void setLink_informacion(String link_informacion) {
		this.link_informacion = link_informacion;
	}


	public String getEtiquetas() {
		return etiquetas;
	}


	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}


	public int getPromoCod() {
		return promoCod;
	}

	public void setPromoCod(int promoCod) {
		this.promoCod = promoCod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMonto_original() {
		return monto_original;
	}

	public void setMonto_original(int monto_original) {
		this.monto_original = monto_original;
	}

	public int getMonto_ofertado() {
		return monto_ofertado;
	}

	public void setMonto_ofertado(int monto_ofertado) {
		this.monto_ofertado = monto_ofertado;
	}

	public Date getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


   
}