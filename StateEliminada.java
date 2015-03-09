
public class StateEliminada implements State {

	@Override
	public void doAction(Promocion promo) {
		int codigo = promo.getPromoCod();
		String descripcion = promo.getDescripcion();
		
		State estado = promo.getEstado();
		estado.print(descripcion, codigo);
	}

	@Override
	public void print(String descripcion, int codigo) {
		System.out.println();
		System.out.println("************** La promocion: " + descripcion + " con código " + codigo
				+ " ha sido eliminada **************");

	}

}
