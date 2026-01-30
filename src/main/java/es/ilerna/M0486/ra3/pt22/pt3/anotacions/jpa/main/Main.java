package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Car;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Motorcycle;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Person;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Plane;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Student;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Teacher;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Vehicle;

public class Main {

	private static List<Person> people = new ArrayList<>();
	private static List<Vehicle> vehicles = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcio;

		do {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1) Fase 1: Crear dades de prova");
			System.out.println("2) Fase 2: Treure vehicles de persones");
			System.out.println("3) Fase 3: Actualitzar un vehicle");
			System.out.println("0) Sortir");
			System.out.print("Escull una opció: ");

			opcio = sc.nextInt();
			sc.nextLine();

			switch (opcio) {
			case 1:
				fase1();
				break;
			case 2:
				fase2();
				break;
			case 3:
				fase3();
				break;
			case 0:
				System.out.println("Fins aviat!");
				break;
			default:
				System.out.println("Opció incorrecta.");
			}

		} while (opcio != 0);

		sc.close();
		HibernateSession.getSessionFactory().close();
	}

	private static void fase1() {

		try (org.hibernate.Session session = HibernateSession.getSessionFactory().openSession()) {
			org.hibernate.Transaction tx = session.beginTransaction();

			// ===== PERSONAS =====
			Student p1 = new Student("Anna", "Lopez", 111111111, "STU001");
			Student p2 = new Student("Jordi", "Martinez", 222222222, "STU002");
			Student p3 = new Student("Clara", "Sanchez", 333333333, "STU003");

			Teacher p4 = new Teacher("Joan", "Perez", 444444444, "TEA001");
			Teacher p5 = new Teacher("Maria", "Gomez", 555555555, "TEA002");
			Teacher p6 = new Teacher("Pere", "Ruiz", 666666666, "TEA003");

			session.persist(p1);
			session.persist(p2);
			session.persist(p3);
			session.persist(p4);
			session.persist(p5);
			session.persist(p6);

			// ===== VEHÍCULOS =====
			Car v1 = new Car("Toyota", 2020, 18000f, 5, 5); // id 1
			Car v2 = new Car("Ford", 2019, 15000f, 3, 4); // id 2

			Plane v3 = new Plane("Cessna", 2015, 120000f, 11111, true); // id 3
			Plane v4 = new Plane("Boeing", 2010, 900000f, 22222, false); // id 4

			Motorcycle v5 = new Motorcycle("Yamaha", 2021, 9000f, false); // id 5
			Motorcycle v6 = new Motorcycle("Harley-Davidson", 2018, 20000f, true); // id 6

			// Asociaciones (lado correcto: Person.addVehicle -> setOwner)
			p1.addVehicle(v1);
			p5.addVehicle(v2);
			p4.addVehicle(v3);
			p3.addVehicle(v4);
			p2.addVehicle(v5);
			p6.addVehicle(v6);

			// Con cascade=ALL en Person.vehicles, NO sería obligatorio persistir vehículos,
			// pero lo dejamos explícito para que quede clarísimo.
			session.persist(v1);
			session.persist(v2);
			session.persist(v3);
			session.persist(v4);
			session.persist(v5);
			session.persist(v6);

			tx.commit();
			System.out.println("Fase 1 OK: dades creades.");
		}
	}

	private static void fase2() {

		try (org.hibernate.Session session = HibernateSession.getSessionFactory().openSession()) {
			org.hibernate.Transaction tx = session.beginTransaction();

			Vehicle v1 = session.get(Vehicle.class, 1);
			if (v1 == null) {
				tx.rollback();
				System.out.println("ERROR: No existe Vehicle id=1. Ejecuta primero fase1.");
				return;
			}

			Person owner = v1.getOwner();
			if (owner != null) {
				// Esto quita de la lista y además hace vehicle.setOwner(null)
				owner.removeVehicle(v1);
				session.merge(owner); // opcional, pero ayuda a sincronizar el lado Person
			} else {
				// ya estaba sin owner
				v1.setOwner(null);
				session.merge(v1);
			}

			tx.commit();
			System.out.println("Fase 2 OK: Vehicle id=1 ara no té owner (person_id NULL).");
		}
	}

	private static void fase3() {

		try (org.hibernate.Session session = HibernateSession.getSessionFactory().openSession()) {
			org.hibernate.Transaction tx = session.beginTransaction();

			Vehicle v1 = session.get(Vehicle.class, 1);
			if (v1 == null) {
				tx.rollback();
				System.out.println("ERROR: No existe Vehicle id=1. Ejecuta primero fase1.");
				return;
			}

			// Aseguramos que no tenga owner (por si alguien ejecuta fase3 sin fase2)
			Person owner = v1.getOwner();
			if (owner != null) {
				owner.removeVehicle(v1); // también hace setOwner(null)
				session.merge(owner);
			}

			v1.setBrand("Seat");
			v1.setPrice(19999f);
			v1.setYear(2022);
			v1.setOwner(null);

			session.merge(v1);

			tx.commit();
			System.out.println("Fase 3 OK: Vehicle id=1 actualitzat (Seat, 19999, 2022, NULL).");
		}
	}

}
