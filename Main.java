// Librerías a utilizar **********************************

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;


public class Main {
	 
	public static void main(String[] args) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
		   //Fechas
			Date date = new Date();
			
			
			// Creamos una fecha posterior a la actual para poder asignarla a una tarjeta de crédito
			String fecha = "25/02/2017";
			Date date2 = new Date();
	        try {
	            SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
	            date2 = df2.parse(fecha);
	        } catch (java.text.ParseException e) {
	            e.printStackTrace();
	        }
		    
			// Tarjetas de Credito
			TarjetaDeCredito tdc1 = new TarjetaDeCredito("4541375325020471", "Reinaldo Verdugo", date2, 332, "MasterCard");
			
		
			
			//Etiquetas
			Set<String> etiquetas1 = new HashSet<String>();
			Set<String> etiquetas2 = new HashSet<String>();
			Set<String> etiquetas3 = new HashSet<String>();
			etiquetas1.add("margarita");
			etiquetas1.add("viajes");
			etiquetas2.add("comida");
			etiquetas2.add("japonesa");	
			etiquetas3.add("andes");
			
			//Promociones
			Promocion promo1 = new Promocion("Viaje a Margarita", 20000,15000, date,date2, "Mayores de 15 años", 300, 3, "/imagen/margara","http://www.viajaMarga.com",etiquetas1);
			Promocion promo2 = new Promocion("Sushi 2x1", 4000,2000, date,date2, "De lunes a jueves", 100, 2, "/imagen/sushi","http://www.compraSushi.com",etiquetas2);
			Promocion promo3 = new Promocion("Viaje Merida Todo incluido", 10000,7000, date,date2, "Mayores de 18 años", 100, 2, "/imagen/merida","http://www.venAMerida.com",etiquetas3);

			
			//Empresas
			Empresa empresa1 = new Empresa(20613827,"info@vendemosalgo.com","Vendemos Algo",2127628321,"C.A",10);
			
		    //Anuncio
		    Anuncio anuncio = new Anuncio(Nivel.Bronce, 300, "Anuncio básico");
			
			//Publicacion
		    Publicacion publi1 = new Publicacion();
		    //elenentos de la publicacion
		    publi1.setAnuncio(anuncio);
		    publi1.setEmpresa(empresa1);
		    publi1.setPromocion(promo1);
			
		    //Usuarios
		    Usuario Usuario1 = new Usuario("pedroA", "pedroAndrade@gmail.com", "Pedro", "Andrade");
		    Usuario Usuario2 = new Usuario("jose32", "josemail@hotmail.com", "Jose", "Perez");
		    Usuario Usuario3 = new Usuario("mariag23", "gonza.maria@gmail.com", "Maria", "Gonzalez");
		    Usuario Usuario4 = new Usuario("sayonaNeto1", "sayoneto@gmail.com", "Sayona", "Neto");
		    
		    //Recomendaciones
		    Recomendacion recom1 = new Recomendacion();
		    Recomendacion recom2 = new Recomendacion();
		    //Usuario1 recomienda promo1 al Usuario2
		    recom1.setRecomienda(Usuario1);
		    recom1.setRecomendado(Usuario2);
		    recom1.setPromocion(promo1);
		    
		    //Usuario1 recomienda promo1 al Usuario3
		    recom2.setRecomienda(Usuario1);
		    recom2.setRecomendado(Usuario3);
		    recom2.setPromocion(promo1);
		    
		    //Categorias y subcategorías 
		    Categoria categoria1 = new Categoria("viajes");
		    Categoria categoria2 = new Categoria("comida");
		    Categoria categoria3 = new Categoria("ropa");
		    
		    Categoria subcategoria1 = new Categoria("nacionales");
		    Categoria subcategoria2 = new Categoria("internacionales");
		    
		    // Usuario tiene tarjeta de crédito
		    Usuario1.getTarjetas().add(tdc1);
		 
		    //Usuario1 tiene dos promociones adquiridas
		    Adquiere compra1 = new Adquiere();
		    compra1.setUsuario(Usuario1);
		    compra1.setPromocion(promo1);
		    compra1.setComentario("Genial!");
		    compra1.setCalificacion(4);
		
		    Adquiere compra2 = new Adquiere();
		    compra2.setUsuario(Usuario2);
		    compra2.setPromocion(promo2);
		    compra2.setComentario("Comi bastante xD");
		    compra2.setCalificacion(4);
		    
		    Adquiere compra3 = new Adquiere();
		    compra3.setUsuario(Usuario1);
		    compra3.setPromocion(promo3);
		    compra3.setComentario("Muy bonito Merida");
		    compra3.setCalificacion(3);
		    //Usuario1.getPromociones().add(promo1);
		    //Usuario1.getPromociones().add(promo2);
		    
		    //usuario2 tiene una promocion adquirida
		    //Usuario2.getPromociones().add(promo2);
		    
		    //Usuario 2 tiene dos categoria de preferencia
		    Usuario2.getCategorias().add(categoria1);
		    Usuario2.getCategorias().add(categoria2);
		    
		    //Usuario3 tiene dos amigos
		    Usuario1.getAmigos().add(Usuario3);
		    Usuario2.getAmigos().add(Usuario3);
		    Usuario3.getAmigos().add(Usuario2);
		    Usuario3.getAmigos().add(Usuario1);
		    
		    //categoria1 con dos subcategorias
		    subcategoria2.setSuperCategoria(categoria1);
		    subcategoria1.setSuperCategoria(categoria1);
		    
		    //Empresa brinda tres categorias
		    empresa1.getCategorias_brinda().add(categoria1);
		    empresa1.getCategorias_brinda().add(categoria2);
		    empresa1.getCategorias_brinda().add(categoria3);
		    
		    //Promo1 tiene 2 categorias
		    promo3.setCategoria(categoria1);
		    promo1.setCategoria(categoria1);
		    promo2.setCategoria(categoria2);
		    

		    session.save(tdc1);
		    session.save(anuncio);
		    session.save(Usuario1);
		    session.save(Usuario2);
		    session.save(subcategoria1);
		    session.save(subcategoria2);
		    session.save(empresa1);
		    session.save(publi1);
		    session.save(promo3);
		    session.save(promo2);
		    session.save(promo1);
		    session.save(compra1);
		    session.save(compra2);
		    session.save(compra3);
		    session.save(recom1);
		    session.save(recom2);
		    
		    transaction.commit();
		}  catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
			
		}  
		// Queries ****************************************************** //}
		// Promociones adquiridas por el usuario 'pedroA'
		promocionesAdquiridasPor("pedroA");
		
		// Amigos en común entre el usuario 'pedroA' y el usuario 'jose32'
		amigosEnComun("pedroA","jose32"); 

		// Usuarios que prefieren la categoría viajes
		usuariosQuePrefierenCategoria("viajes");
		
		// Promociones que ofrece la empresa con Rif 20613827
		promocionesOfrecidasPor(20613827);
		
		// Promociones que contienen la etiqueta comida
		buscarPromociones("comida");
		
		// Etiquetas de la promoción con código 2
		etiquetas(2);
		
		// Lista las promociones según el precio de menor a mayor
		listarPromocionesPrecio();
		
		// Lista las promociones de la categoría pasada como parámetro
		promocionesEnCategoria("viajes");
		
		// Lista las promociones entre un rango de precios definido
		listarPromocionesRangoPrecio(4000,20000);
		
		// Indida la calificación promedio de una promoción
		calificacionPromedio(2);
		sessionFactory.close();
	}
	
	/**
	* promocionesAdquiridasPor
	*
	* Procedimiento que dado el username de un usuario devuelve todas las promociones
	* que han sido adquiridad por él.
	* @param name : El username del usuario del que se desea conocer las promociones adquiridad
	*/
	public static void promocionesAdquiridasPor(String name){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Promocion> listaResultados =  session.createQuery(
		    		"select p " +
		    		"from Adquiere a " +
		    		"join a.promocion p " +
		    		"where a.usuario = '" + name + "'").list();
	    	
			System.out.println();
			System.out.println("Promociones adquiridas por el usuario: " + name);
			
	    	for (Promocion promocion : listaResultados) {
        		System.out.println("Codigo: " + promocion.getPromoCod()); 
        		System.out.println("  Descripción: " + promocion.getDescripcion()); 
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }

	} // fin de procedimiento promocionesAdquiridasPor
	
	/**
	* usuariosQuePrefierenCategoria
	*
	* Procedimiento que dada una categoría devuelve una lista de usuarios que la prefieren
	* @param nombreCat : Nombre de la categoría
	*/
	public static void usuariosQuePrefierenCategoria(String nombreCat){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Usuario> listaResultados =  session.createQuery(
	    			"select u " +
		    		"from Usuario u " +
		    		"JOIN u.categorias cat " +
		    		"WHERE cat = '" + nombreCat + "'"
	    			).list();
	    	
			System.out.println();
			System.out.println("Usuarios que prefieren la categoría " + nombreCat);
	    	for (Usuario usuario : listaResultados) {
        		System.out.println("username: " + usuario.getUsername()); 
        		System.out.println("  Nombre: " + usuario.getNombre()); 
        		System.out.println("  Apellido: " + usuario.getApellido());
        		System.out.println();
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }

	} // fin de procedimiento usuariosQuePrefierenCategoria
	
	/**
	* amigosEnComun
	*
	* Procedimiento que dado el username de dos usuarios imprime los amigos en común
	* entre ellos.
	* @param user : El username primer usuario
	* @param user2: El username del segundo usuario
	*/
	public static void amigosEnComun(String user, String user2){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Usuario> listaResultados =  session.createQuery(
	    			"select u " +
		    		"from Usuario u " +
		    		"WHERE '" + user + "' MEMBER OF u.listaAmigos " + 
		    		"and  '" + user2 + "' MEMBER OF u.listaAmigos"
	    			).list();
	    	
			System.out.println();
			System.out.println("Amigos en común entre usuario " + user + " y " + user2);
	    	for (Usuario usuario : listaResultados) {
        		System.out.println("username: " + usuario.getUsername()); 
        		System.out.println("  Nombre: " + usuario.getNombre()); 
        		System.out.println("  Apellido: " + usuario.getApellido());
        		System.out.println();
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }

	}// fin de procedimiento amigosEnComun
	
	/**
	* promocionesOfrecidasPor
	*
	* Procedimiento que dado el username de dos usuarios imprime los amigos en común
	* entre ellos.
	* @param user : El username primer usuario
	* @param user2: El username del segundo usuario
	*/
	public static void promocionesOfrecidasPor(int rif){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Promocion> listaResultados =  session.createQuery(
	    			"select p " +
		    		"from Promocion p, Publicacion pub " +
	    			"where pub.empresa = '" + rif +	"' " +
		    		"and pub.promocion = p"
		    		
	    			).list();
	    	
			System.out.println();
			System.out.println("Promociones ofrecidas por la empresa " + rif);
	    	for (Promocion promocion : listaResultados) {
        		System.out.println("Código de la promoción: " 	+ promocion.getPromoCod()); 
        		System.out.println("  Descripción: " 			+ promocion.getDescripcion()); 
        		System.out.println("  Monto Original: " 		+ promocion.getMonto_original());
        		System.out.println("  Monto Ofertado: " 		+ promocion.getMonto_ofertado());
        		System.out.println("  Fecha de Inicio: " 		+ promocion.getFecha_ini());
	    		System.out.println("  Fecha de Culminación: " 	+ promocion.getFecha_fin());
	    		System.out.println("  Categoria: " 				+ promocion.getCategoria().getNombre());
	    		System.out.println("  Condiciones: " 			+ promocion.getCondiciones());
	    		System.out.println("  + Info a través de : " 	+ promocion.getLink_informacion());
        		System.out.println();
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }

	}// fin de procedimiento promocionesOfrecidasPor
	
	/**
	* buscarPromociones
	*
	* Procedimiento que dada una etiqueta consigue todas las promociones que
	* coincidan con la misma
	* @param etiqueta : Etiqueta que se usará para realizar la búsqueda
	*/
	public static void buscarPromociones(String etiqueta){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Promocion> listaResultados =  session.createQuery(
	    			"select p " +
		    		"from Promocion p " +
		    		"inner join p.etiquetas etiq " +
	    			"where etiq = '" + etiqueta +	"'"
	    			).list();
	    	
			System.out.println();
			System.out.println("Promociones que coinciden con la etiqueta " + etiqueta);
	    	for (Promocion promocion : listaResultados) {
        		System.out.println("Código de la promoción: " 	+ promocion.getPromoCod()); 
        		System.out.println("  Descripción: " 			+ promocion.getDescripcion()); 
        		System.out.println("  Monto Original: " 		+ promocion.getMonto_original());
        		System.out.println("  Monto Ofertado: " 		+ promocion.getMonto_ofertado());
        		System.out.println("  Fecha de Inicio: " 		+ promocion.getFecha_ini());
	    		System.out.println("  Fecha de Culminación: " 	+ promocion.getFecha_fin());
	    		System.out.println("  Categoria: " 				+ promocion.getCategoria().getNombre());
	    		System.out.println("  Condiciones: " 			+ promocion.getCondiciones());
	    		System.out.println("  + Info a través de : " 	+ promocion.getLink_informacion());
        		System.out.println();
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }
	}// fin de procedimiento buscarPromociones
	    
	/**
	* etiquetas
	*
	* Procedimiento que dada una promoción lista todas sus etiquetas
	* @param etiqueta : Etiqueta que se usará para realizar la búsqueda
	*/
	public static void etiquetas(int promocod){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
		try {
		    transaction = session.beginTransaction();
		    List<Promocion> listaResultados =  session.createQuery(
		    		"select p " +
			    	"from Promocion p " +
		    		"where p.promoCod = '" + promocod +	"'"
		    		).list();
		    	
			System.out.println();
			System.out.print("Etiquetas de la promoción ");
		    for (Promocion promocion : listaResultados) {
		    	System.out.println(promocion.getDescripcion());
		    	for (String etiqueta : promocion.getEtiquetas()) {
		    		System.out.println("	Etiqueta: " 	+ etiqueta); 
		    	}
	        }
			    
		    transaction.commit();
		} catch (HibernateException e) {
	    	if (transaction!=null) transaction.rollback();
	    	e.printStackTrace(); 
	    		
		} finally {
			session.close();
		}
	}// fin de procedimiento etiquetas
	
	public static void listarPromocionesPrecio(){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Promocion> listaResultados =  session.createQuery(
	    			"select p " +
		    		"from Promocion p " +
		    		"order by (p.monto_ofertado)"
	    			).list();
	    	
			System.out.println();
			System.out.println("Promociones ordenadas por monto de precio ofertado ");
	    	for (Promocion promocion : listaResultados) {
        		System.out.println("Código de la promoción: " 	+ promocion.getPromoCod()); 
        		System.out.println("Descripción: " 				+ promocion.getDescripcion());
        		System.out.println("Monto Original: " 			+ promocion.getMonto_original());
        		System.out.println("Monto Ofertado: " 			+ promocion.getMonto_ofertado());;
        		System.out.println("  Categoria: " 				+ promocion.getCategoria().getNombre());
        		System.out.println("  Fecha de Inicio: " 		+ promocion.getFecha_ini());
	    		System.out.println("  Fecha de Culminación: " 	+ promocion.getFecha_fin());
	    		System.out.println("  Condiciones: " 			+ promocion.getCondiciones());
	    		System.out.println("  + Info a través de : " 	+ promocion.getLink_informacion());
        		System.out.println();
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }
	}// fin de procedimiento listarPromocionesPrecio
	
	public static void promocionesEnCategoria(String nombreCat){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Promocion> listaResultados =  session.createQuery(
	    			"select p " +
		    		"from Categoria c " +
		    		"join c.promociones p " +
		    		"where c = '" + nombreCat + "'"
	    			).list();
	    	
			System.out.println();
			System.out.println("Promociones que coinciden con categoría " + nombreCat);
	    	for (Promocion promocion : listaResultados) {
        		System.out.println("Código de la promoción: " 	+ promocion.getPromoCod()); 
        		System.out.println("  Descripción: " 			+ promocion.getDescripcion());
        		System.out.println("  Monto Original: " 		+ promocion.getMonto_original());
        		System.out.println("  Monto Ofertado: " 		+ promocion.getMonto_ofertado());
        		System.out.println("  Fecha de Inicio: " 		+ promocion.getFecha_ini());
	    		System.out.println("  Fecha de Culminación: " 	+ promocion.getFecha_fin());
	    		System.out.println("  Condiciones: " 			+ promocion.getCondiciones());
	    		System.out.println("  + Info a través de : " 	+ promocion.getLink_informacion());
        		System.out.println();
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }
	}// fin de procedimiento promocionesEnCategoria
	
	public static void listarPromocionesRangoPrecio(int min, int max){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Promocion> listaResultados =  session.createQuery(
	    			"select p " +
		    		"from Promocion p " +
		    		"where p.monto_ofertado <= '" + max + "' " +
		    		"and p.monto_ofertado >= '" + min + "' " +
		    		"order by (p.monto_ofertado)"
	    			).list();
	    	
			System.out.println();
			System.out.println("Promociones con monto ofertado entre " + min + " y " + max);
	    	for (Promocion promocion : listaResultados) {
        		System.out.println("Código de la promoción: " 	+ promocion.getPromoCod()); 
        		System.out.println("Descripción: " 				+ promocion.getDescripcion());
        		System.out.println("Monto Original: " 			+ promocion.getMonto_original());
        		System.out.println("Monto Ofertado: " 			+ promocion.getMonto_ofertado());
        		System.out.println("  Categoria: " 				+ promocion.getCategoria().getNombre());
        		System.out.println("  Fecha de Inicio: " 		+ promocion.getFecha_ini());
	    		System.out.println("  Fecha de Culminación: " 	+ promocion.getFecha_fin());
	    		System.out.println("  Condiciones: " 			+ promocion.getCondiciones());
	    		System.out.println("  + Info a través de : " 	+ promocion.getLink_informacion());
        		System.out.println();
        	}
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }
	}// fin de procedimiento listarPromocionesRangoPrecio
	
	public static void calificacionPromedio(int promoCod){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	Double calificacion = (Double) session.createQuery(
	    			"select avg(a.Calificacion) " +
		    		"from Adquiere a " +
	    			"where a.promocion = '" + promoCod + "'"		
	    			).uniqueResult();
	    	String nombre = (String) session.createQuery(
	    			"select p.descripcion " +
	    			"from Promocion p " +
	    			"where p.promoCod = '" + promoCod + "'"
	    			).uniqueResult();
			System.out.println();
			System.out.println("Calificación promedio de la promoción " + nombre + " : " + calificacion);
		    
	    	transaction.commit();
	    } catch (HibernateException e) {
    		if (transaction!=null) transaction.rollback();
    		e.printStackTrace(); 
    		
	    } finally {
		    session.close();
	    }
	}// fin de procedimiento calificacionPromedio
}