
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="CATEGORIA")
public class Categoria {
     
    @Id
	@Column(name="NOMBRE")
    private String nombre;
     
    //El rol Super Categoria
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="superCategoria") //Owner de la relación es superCategoria
    private Categoria superCategoria;
 
    //El rol desubCategoria que depente de una supercategoria Uno a muchos
    @OneToMany(mappedBy="superCategoria") //Mapeado desde el superCategoria que es el owner de la relación
    private Set<Categoria> subcategorias = new HashSet<Categoria>();

    public Categoria (String nombre){
    	this.nombre = nombre;
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