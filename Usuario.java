// Librerías a utilizar **********************************

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
* Clase Usuario 
* Tabla USUARIO
* 
* Se refiere a la persona que se registra en el portal 
* para conocer y adquirir promociones ofrecidas por las 
* empresas.
*/
@Entity
@Table(name="USUARIO")
public class Usuario {
	
// Atributos de la clase ***************************************
	
	// Nombre del usuario en el portal. ****
    @Id
    @Column(name="USERNAME", nullable = false)
    @Size(
    		min = 3, 
    		max = 15, 
    		message = "El nombre de usuario debe estar entre 3 y 15 caracteres")
    private String username;
    
    // Correo electrónico del usuario. *****
	@Column(name="CORREO", nullable = false)
	@Email( // Verifica que la dirección de correo sea válida
			message = "La dirección de correo '${validatedValue}' debe ser válida")
	@Size(
			min = 13, 
			max = 30, 
			message = "La dirección de correo '${validatedValue}' debe estar entre {min} y {max} caracteres")
    private String correo;
     
	// Primer nombre del usuario. *********
    @Column(name="NOMBRE", nullable = false)
    @Size(
    		min = 2, 
    		max = 17, 
    		message = "El nombre del usuario '${validatedValue}' debe estar entre {min} y {max} caracteres.")
    private String nombre;
    
    // Primer apellido del usuario. *******
    @Column(name="APELLIDO", nullable = false)
    @Size(
    		min = 2, 
    		max = 17, 
    		message = "El apellido del usuario '${validatedValue}' debe estar entre {min} y {max} caracteres")
    private String apellido;
    
    // Cantidad de dinero virtual que ha ganado el usuario.
    @Column(name="DINERO_PROMOCION", nullable = false)
    @Min(
    		value = 0, 
    		message = "El dinero promoción debe ser positivo")
    private int dinero_promocion;
    
    // Constructor de la clase
    public Usuario(String username, String correo, String nombre, String apellido) {
        this.username = username;
        this.correo = correo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dinero_promocion = 0;
    } // Cierre del constructor

    
// Asociaciones ****************************************************
    
	/*
     * @ManyToMany – Is used to create many-to-many relationship between Employee and Meeting entities. 
     * If the Collection is defined using generics to specify the element type, the associated target 
     * entity class does not need to be specified; otherwise it must be specified. Every many-to-many 
     * association has two sides, the owning side and the non-owning, or inverse, side. The join table 
     * is specified on the owning side. 
     * If the association is bidirectional, either side may be designated as the owning side.
     * 
     */
    @ManyToMany(cascade = {CascadeType.ALL})
    
    /*
     * @JoinTable – Is used to define the join table (link table) for many-to-many relationship.
     * It is specified on the owning side of a many-to-many association, or in a unidirectional 
     * one-to-many association. 
     * In this case the join table is EMPLOYEE_MEETING.
     * @JoinColumn – Is used to define the join column (linking column) in both main tables.
     */
    @JoinTable(name="ADQUIERE", //Tabla intermedia
                joinColumns={@JoinColumn(name="USERNAME")}, //username USUARIO
                inverseJoinColumns={@JoinColumn(name="PROMOCOD")}) //ID de la PROMOCION
   


    //Lista de promociones que ha adquirido el usuario
    private Set<Promocion> promociones = new HashSet<Promocion>();
    
    // Un usuario tiene varios usuarios amigos
    // Así como puede ser amigo de varios usuarios.
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="AMIGOS",
        joinColumns={@JoinColumn(name="USERNAME")},
        inverseJoinColumns={@JoinColumn(name="USERNAME_AMIGO")})
    private Set<Usuario> amigos = new HashSet<Usuario>();

    @ManyToMany(mappedBy="amigos")
    private Set<Usuario> listaAmigos = new HashSet<Usuario>();

    
// Getters and Setters **********************************************
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDinero_promocion() {
		return dinero_promocion;
	}

	public void setDinero_promocion(int dinero_promocion) {
		this.dinero_promocion = dinero_promocion;
	}

	public Set<Usuario> getListaAmigos() {
		return listaAmigos;
	}

	public void setListaAmigos(Set<Usuario> listaAmigos) {
		this.listaAmigos = listaAmigos;
	}

	public Set<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(Set<Usuario> amigos) {
		this.amigos = amigos;
	}

	public Set<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<Promocion> promociones) {
		this.promociones = promociones;
	}
}