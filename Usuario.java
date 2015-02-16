import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
    
    @Id
    @Column(name="USERNAME")
    private String username;
     
	@Column(name="CORREO")
    private String correo;
     
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="APELLIDO")
    private String apellido;
    
    @Column(name="DINERO_PROMOCION")
    private int dinero_promocion;
    
    public Usuario(String username, String correo, String nombre, String apellido) {
        this.username = username;
        this.correo = correo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dinero_promocion =0;
    }

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
    
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="AMIGOS",
        joinColumns={@JoinColumn(name="USERNAME")},
        inverseJoinColumns={@JoinColumn(name="USERNAME_AMIGO")})
    private Set<Usuario> amigos = new HashSet<Usuario>();

    @ManyToMany(mappedBy="amigos")
    private Set<Usuario> listaAmigos = new HashSet<Usuario>();

    
    
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