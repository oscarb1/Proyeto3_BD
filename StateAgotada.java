
public class StateAgotada implements State {

	@Override
	public void doAction(Promocion promo) {
		int codigo = promo.getPromoCod();
		String descripcion = promo.getDescripcion();
		promo.setVisualizada(false); // Como está agotada, se quita la visualizacion
		boolean valida = promo.isValida();
		
		if (!valida) {
			promo.setEstado(new StateEliminada());
			promo.setVisualizada(false); // Como está agotada, se quita la visualizacion
		} 
		State estado = promo.getEstado();
		estado.print(descripcion, codigo);
	}

	public void print(String descripcion, int codigo) {
		System.out.println();
		System.out.println("************** Promocion: " + descripcion + " con código " + codigo
				+ " está agotada **************");
	}
}
