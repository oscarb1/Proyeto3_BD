import java.util.Date;


public class StatePublicada implements State {

	@Override
	public void doAction(Promocion promo) {
		int codigo = promo.getPromoCod();
		String descripcion = promo.getDescripcion();
		boolean valida = promo.isValida();
		int cantidadDisponible = promo.getCantidad_total();
		Date date = new Date(); //Obtiene por defecto la fecha actual
		Date dateFinal = promo.getFecha_fin(); // La fecha de culminación de la promoción
		
		if (!valida) {
				promo.setEstado(new StateEliminada());
				promo.setVisualizada(false); // Como está agotada, se quita la visualizacion
		} 
		else if ((cantidadDisponible == 0) || (date.after(dateFinal))) { // Si se acabó el bien o culminó la fecha
			promo.setEstado(new StateAgotada());
			promo.setVisualizada(false); // Como está agotada, se quita la visualizacion
		} 
		State estado = promo.getEstado();
		estado.print(descripcion, codigo);
	}
	
	public void print(String descripcion, int codigo) {
		System.out.println();
		System.out.println("************** Promocion: " + descripcion + " con código " + codigo
				+ " ya está publicada **************");
	}

}
