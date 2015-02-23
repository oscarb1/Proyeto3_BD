// Librerías a utilizar **********************************

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "TARJETA_DE_CREDITO")
public class TarjetaDeCredito {
	
	@Id
	@Column(name = "NUMERO", nullable = false)
	@CreditCardNumber(
			message = "Debe colocar un número de tarjeta válido")
	private String Numero; 
	
	@Column(name = "NOMBRE_TITULAR", nullable = false)
	@Size(
			max = 25,
			message = "El nombre del titular de la tarjeta de crédito debe tener máximo {max} caracteres")
	private String Nombre_Titular;
	
	@Column(name = "FECHA_VENCIMIENTO")
	@Future( // Chequea que la tarjeta de crédito no esté vencida, las fechas deben ser del futuro
			message = "La tarjeta de crédito no puede estar vencida")
	private Date Fecha_Vencimiento;
	
	@Column(name = "CODIGO")
	private int Codigo;
	
	@Column(name = "TIPO")
	@Pattern(regexp = "MasterCard|Visa") // Chequea que la tarjeta sea de tipo MasterCard o Visa
	private String Tipo;
	
	public TarjetaDeCredito(String numero, String titular, Date fecha_venc, int codigo, String tipo) {
		this.Numero = numero;
		this.Nombre_Titular = titular;
		this.Fecha_Vencimiento = fecha_venc;
		this.Codigo = codigo;
		this.Tipo = tipo;
		
	}
	
// Getters and Setters ****************************************************************//

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String number) {
		Numero = number;
	}

	public String getNombre_Titular() {
		return Nombre_Titular;
	}

	public void setNombre_Titular(String nombre_Titular) {
		Nombre_Titular = nombre_Titular;
	}

	public Date getFecha_Vencimiento() {
		return Fecha_Vencimiento;
	}

	public void setFecha_Vencimiento(Date fecha_Vencimiento) {
		Fecha_Vencimiento = fecha_Vencimiento;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	
}
