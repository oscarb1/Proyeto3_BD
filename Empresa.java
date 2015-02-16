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
@Table(name="EMPRESA")
public class Empresa {
 
    @Id
    @Column(name="RIF")
    private int rif;
    
    @Id
    @Column(name="CORREO")
    private String correo;
     
	@Column(name="NOMBRE")
    private String nombre;
    
	@Column(name="TELEFONO")
	private int telefono;
	
	@Column(name="RAZON_SOCIAL")
    private String razon_social;
    
	public int getRif() {
		return rif;
	}

	public void setRif(int rif) {
		this.rif = rif;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public int getNum_clientes() {
		return num_clientes;
	}

	public void setNum_clientes(int num_clientes) {
		this.num_clientes = num_clientes;
	}

	@Column(name="NUM_CLIENTES")
	private int num_clientes;
         
   
}