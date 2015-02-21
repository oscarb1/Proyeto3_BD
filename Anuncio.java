// Librerías a utilizar **********************************

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
 
@Entity
@Table(name="ANUNCIO")
public class Anuncio {
 
    public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Id
    @Column(name="NIVEL")
    private String nivel;
    
    @Column(name="TARIFA")
    private int tarifa;
     
	@Column(name="DESCRIPCION")
    private String descripcion;
         



   
}