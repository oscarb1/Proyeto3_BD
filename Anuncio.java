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
@Table(name="ANUNCIO")
public class Anuncio {
 
    @Id
    @Column(name="NIVEL")
    private String nivel;
    
    @Column(name="TARIFA")
    private int tarifa;
     
	@Column(name="DESCRIPCION")
    private String descripcion;
         



   
}