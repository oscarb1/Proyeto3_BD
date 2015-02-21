// Librerías a utilizar *********************************

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
 
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
 
	// Código único que sirve para identificar a una promoción
    @Id
    @Column(name="PROMOCOD")
    @GeneratedValue
    private int promoCod;
 
    // Breve descripción del bien o producto que se está ofertando
	@Column(name="DESCRIPCION")
    private String descripcion;
    
	// Monto que tendría el bien o servicio de no ser por la promoción ofertada
    @Column(name="MONTO_ORIGINAL")
    private int monto_original;
    
    // Monto que ofrece la promoción durante un tiempo limitado.
    @Column(name="MONTO_OFERTADO")
    private int monto_ofertado;
    
    // Fecha en la que comienza la promoción
    @Column(name="FECHA_INI")
    private Date fecha_ini;
    
    // Fecha en la que culmina la promoción.
    @Column(name="FECHA_FIN")
    private Date fecha_fin;
    
    // Descripción de algunas condiciones que se deben 
    // cumplir para poder optar por la oferta.
    @Column(name="CONDICIONES")
    private String condiciones;
    
    // Cantidad de bienes o servicios disponibles para ofertar.
    @Column(name="CANTIDAD_TOTAL")
    private int cantidad_total;
    
    // Límite de veces que un mismo usuario puede adquirir la promoción
    @Column(name="CANTIDAD_USUARIO")
    private int cantidad_usuario;
    
    // Imagen asociadas al bien o producto que se está ofertando
    @Column(name="IMAGEN")
    private String imagen;
    
    // Enlace a alguna página web o red social que contiene más 
    // información de la promoción
    @Column(name="LINK_INFORMACION")
    @URL(
    		message = "Debe ingresar una dirección URL válida (http://direccion.dominio)")
    private String link_informacion;
    
    // Etiqueta(s) de búsqueda que facilita(n) la posibilidad de encontrar 
    // la oferta desde un buscador.
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
    	if (fecha_ini.after(fecha_fin)) {
    		throw new IllegalArgumentException("La fecha final no puede ser antes de la fecha inicial");
    	}
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
 		if (cantidad_total < 0) {
 			throw new IllegalArgumentException("La cantidad de promociones no puede ser negativa");
 		}
 		this.cantidad_total = cantidad_total;
 	}


 	public void setCantidad_usuario(int cantidad_usuario) {
 		if (cantidad_usuario < 0) {
 			throw new IllegalArgumentException("La cantidad de promociones por usuario no puede ser negativa");
 		}
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
		if (monto_original < 0) {
			throw new IllegalArgumentException("El monto original de una promocion no puede ser negativo");
		}
		this.monto_original = monto_original;
	}

	public int getMonto_ofertado() {
		return monto_ofertado;
	}

	public void setMonto_ofertado(int monto_ofertado) {
		if (monto_ofertado < 0) {
			throw new IllegalArgumentException("El monto ofertado de una promocion no puede ser negativo");
		}
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