// Librerías a utilizar **********************************

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@Embeddable
public class TarjetaDeCredito {
	
	@Column(name = "NUMBER")
	@CreditCardNumber( // Chequea que efectivamente sea un número de tarjeta de crédito
			message = "Debe introducir un número de tarjeta de cŕedito válida") 
	private String Number; 
	
	@Column(name = "NOMBRE_TITULAR")
	@Size(
			max = 25,
			message = "El nombre del titular de la tarjeta de crédito debe tener máximo {max} caracteres")
	private String Nombre_Titular;
	
	@Column(name = "FECHA_VENCIMIENTO")
	@Future( // Chequea que la tarjeta de crédito no esté vencida, las fechas deben ser del futuro
			message = "La tarjeta de crédito no puede estar vencida")
	private Date Fecha_Vencimiento;
	
	@Column(name = "CODIGO")
	@Range(
			min = 3, 
			max = 3,
			message = "El código secreto debe ser de tres dígitos")
	private int Codigo;
	
	@Column(name = "TIPO")
	@Pattern(regexp = "MasterCard|Visa") // Chequea que la tarjeta sea de tipo MasterCard o Visa
	private String Tipo;
	
// Getters and Setters ****************************************************************//

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
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
