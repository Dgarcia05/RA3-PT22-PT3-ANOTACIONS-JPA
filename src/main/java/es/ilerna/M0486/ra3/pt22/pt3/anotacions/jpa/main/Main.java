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
		
	}
	
	private static void fase2() {
		
	}
	
	private static void fase3() {
		
	}
}