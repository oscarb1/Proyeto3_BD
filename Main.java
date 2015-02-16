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
		Promocion promo1 = new Promocion("Promocion Margarita");
	    Promocion promo2 = new Promocion("Promocion almuerzo comidaRapida");
	    
	    //Usuarios
	    Usuario Usuario1 = new Usuario("pedroA", "pedroAndrade@gmail.com", "Pedro", "Andrade");
	    Usuario Usuario2 = new Usuario("jose32", "jose_perez@gmail.com", "Jose", "Perez");
	    Usuario Usuario3 = new Usuario("mariag23", "gonza.maria@gmail.com", "Maria", "Gonzalez");
	    
	    //Categoria
	    Categoria categoria1 = new Categoria("viajes");
	    
	    Categoria subcategoria1 = new Categoria("nacionales");
	    Categoria subcategoria2 = new Categoria("internacionales");
	 
	    //Usuario1 tiene dos promociones adquiridas
	    Usuario1.getPromocion().add(promo1);
	    Usuario1.getPromocion().add(promo2);
	    
	    //usuario2 tiene una promocion adquirida
	    Usuario2.getPromocion().add(promo2);
	    
	    //categoria1 con dos subcategorias
	    subcategoria2.setSuperCategoria(categoria1);
	    subcategoria1.setSuperCategoria(categoria1);
	         
	    session.save(Usuario1);
	    session.save(Usuario2);
	    session.save(subcategoria1);
	    session.save(subcategoria2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}