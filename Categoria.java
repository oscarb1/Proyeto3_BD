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
    
    // Getters and Setters ***********************************
    
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