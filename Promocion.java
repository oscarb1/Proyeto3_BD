import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
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
    

	//Mapeando desde Meeting, y meeting tiene un set de empleados 
    @ManyToMany(mappedBy="promociones") //Se debe colocar el nombre del set de meetings que se creo en Employee
    private Set<Usuario> usuarios = new HashSet<Usuario>();
     
    public Promocion(String descripcion) {
 		this.descripcion = descripcion;
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


	public Set<Usuario> getUsuario() {
		return usuarios;
	}

	public void setUsuario(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
   
}