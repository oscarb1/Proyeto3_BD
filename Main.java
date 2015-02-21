// Librerías a utilizar **********************************

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	 
	public static void main(String[] args) 
	{
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	   
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
	    
	    //
	    // Se guardan los cambios y se cierra la sesión
	    // con la base de datos
	    session.save(Usuario1);
	    session.save(Usuario2);
	    session.save(subcategoria1);
	    session.save(subcategoria2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}

