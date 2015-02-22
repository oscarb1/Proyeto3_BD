// Librerías a utilizar **********************************

import java.util.Date;
import java.util.List;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
		   
			//Promociones
			
			//Una fecha para probar
			Date date = new Date();
			Promocion promo1 = new Promocion("Viaje a Margarita", 20000,15000, date,date, "estas son las condi", 300, 3, "/imagen/margara","http://www.viajaMarga.com","etiq");
			Promocion promo2 = new Promocion("Sushi 2x1", 4000,2000, date,date, "estas son las condi sushi", 100, 2, "/imagen/sushi","http://www.compraSushi.com","etiq2");
		    
		    
		    //Usuarios
		    Usuario Usuario1 = new Usuario("pedroA", "pedroAndrade@gmail.com", "Pedro", "Andrade");
		    Usuario Usuario2 = new Usuario("jose32", "josemail@hotmail.com", "Jose", "Perez");
		    Usuario Usuario3 = new Usuario("mariag23", "gonza.maria@gmail.com", "Maria", "Gonzalez");
		    
		    //Categorias y subcategorías 
		    Categoria categoria1 = new Categoria("viajes");
		    
		    Categoria subcategoria1 = new Categoria("nacionales");
		    Categoria subcategoria2 = new Categoria("internacionales");
		 
		    //Usuario1 tiene dos promociones adquiridas
		    Usuario1.getPromociones().add(promo1);
		    Usuario1.getPromociones().add(promo2);
		    
		    //usuario2 tiene una promocion adquirida
		    Usuario2.getPromociones().add(promo2);
		    
		    //Usuario3 tiene dos amigos
		    Usuario1.getAmigos().add(Usuario3);
		    Usuario2.getAmigos().add(Usuario3);
		    //Usuario3.getAmigos().add(Usuario2);
		    //Usuario3.getAmigos().add(Usuario1);
		    
		    //categoria1 con dos subcategorias
		    subcategoria2.setSuperCategoria(categoria1);
		    subcategoria1.setSuperCategoria(categoria1);
		    
		    //Anuncio
		    Anuncio anuncio = new Anuncio(Nivel.Bronce, 300, "Anuncio básico");
		    session.save(anuncio);
		    session.save(Usuario1);
		    session.save(Usuario2);
		    session.save(subcategoria1);
		    session.save(subcategoria2);
		    
		    transaction.commit();
		}  catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
			
		}  
		promocionesAdquiridasPor("pedroA");

		sessionFactory.close();
	}
	
	public static void promocionesAdquiridasPor(String name){
		SessionFactory sessionFac = HibernateUtil.getSessionFactory();
		Session session = sessionFac.openSession();
		Transaction transaction = null;
	    try {
	    	transaction = session.beginTransaction();
	    	List<Promocion> listaResultados =  session.createQuery(
		    		"select u.promociones " +
		    		"from Usuario u " +
		    		"where u.username = '" + name + "'").list();
	    	
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

	}
}

