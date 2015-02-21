// Librerías a utilizar **********************************

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

/**
* Clase Empresa 
* Tabla EMPRESA
*
* Se refiere a las compañías que utilizan el portal para 
* publicar las promociones ofrecidas por las mismas.
*/
@Entity
@Table(name="EMPRESA")
public class Empresa {
 	
// Atributos de la clase *******************************
	
	// Registro de identificación fiscal de la empresa
	// Atributo clave que no puede ser NULL.
    @Id 
    @Column(name="RIF", nullable= false)
    private int rif;
    
    // Correo electrónico de la empresa 
    // No puede tomar valor NULL.
    @Column(name="CORREO", nullable= false)
    @Email( // Verifica que la dirección de correo sea válida
			message = "La dirección de correo '${validatedValue}' debe ser válida")
	@Size(
			min = 13, 
			max = 30, 
			message = "La dirección de correo '${validatedValue}' debe estar entre {min} y {max} caracteres")
    private String correo;
     
    // Nombre de la empresa.
    // No puede tomar valor NULL.
	@Column(name="NOMBRE", nullable= false)
	@Size(
			max = 50,
			message = "El nombre de la empresa debe tener menos de {max} caracteres")
    private String nombre;
    
	// Número telefónico de contacto de la empresa.
	// No puede tomar valor NULL.
	@Column(name="TELEFONO", nullable= false)
	private int telefono;
	
	// Nombre oficial por el que se conoce colectivamente 
	// a la empresa. No puede tomar valor NULL.
	@Column(name="RAZON_SOCIAL", nullable= false)
	@Size(
			max = 50,
			message = "La razón social de la empresa debe tener menos de {max} caracteres")
    private String razon_social;
    
	@Column(name="NUM_CLIENTES")
	private int num_clientes;
	
// Getters and Setters ***********************************
	
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
   
}