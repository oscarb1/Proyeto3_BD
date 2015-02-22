// Librerías a utilizar **********************************

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;
import javax.persistence.*;

/**
* Clase Categoria
* Tabla CATEGORIA
* 
* Categoría en la que se clasifica una promoción.
*/
@Entity
@Table(name="CATEGORIA")
public class Categoria {
     
    @Id
	@Column(name="NOMBRE", nullable = false)
    @Size(
    		max = 20,
    		message = "El nombre de la categoría '${validatedValue}' no debe pasar de 20 caracteres")
    private String nombre;
     
    //El rol Super Categoria
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="superCategoria") //Owner de la relación es superCategoria
    private Categoria superCategoria;
 
    //El rol de subCategoria que depende de una supercategoria Uno a muchos
    @OneToMany(mappedBy="superCategoria") //Mapeado desde el superCategoria que es el owner de la relación
    private Set<Categoria> subcategorias = new HashSet<Categoria>();

    public Categoria (String nombre){
    	this.nombre = nombre;
    } // Cierre del constructor
    
 // Asociaciones ****************************************************
    
	//Mapeo de categorias desde usuario 
    @ManyToMany(mappedBy="categorias") 
    private Set<Usuario> usuarios = new HashSet<Usuario>();
    
	//Mapeo de categorias desde empresa
    @ManyToMany(mappedBy="categorias_brinda") 
    private Set<Empresa> empresas = new HashSet<Empresa>();
 
  // Getters and Setters ***********************************	
    
	public Set<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Set<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(Set<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public Categoria getSuperCategoria() {
		return superCategoria;
	}

	public Set<Categoria> getSubcategoria() {
		return subcategorias;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSuperCategoria(Categoria superCategoria) {
		this.superCategoria = superCategoria;
	}

	public void setSubcategoria(Set<Categoria> subcategoria) {
		this.subcategorias = subcategoria;
	}
 
}