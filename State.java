import javax.persistence.*;


public interface State {
	public void doAction(Promocion promo);
	
	public void print(String descripcion, int codigo);
}
