package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSession {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();// carga hibernate.cfg.xml

//Entidades anotadas
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Person.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Student.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Teacher.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Vehicle.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Car.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Plane.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Motorcycle.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {
			System.err.println("Error creando SessionFactory:" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
