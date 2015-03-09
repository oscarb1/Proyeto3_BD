import java.util.Date;

public class StateCreada implements State {

	@Override
	public void doAction(Promocion promo) {
		int codigo = promo.getPromoCod();
		String descripcion = promo.getDescripcion();
		boolean visualizacion = promo.isVisualizada();
		boolean valida = promo.isValida();
		if (visualizacion) {
			promo.setEstado(new StatePublicada());
			
		} else if (!(valida)){
			promo.setEstado(new StateCancelada());
			promo.setVisualizada(false);
		}
		State estado = promo.getEstado();
		estado.print(descripcion, codigo);
	}
	
	public void print(String descripcion, int codigo) {
		System.out.println();
		System.out.println("************** Promocion: " + descripcion + " creada con código " + codigo
				+ " **************");
	}

}
