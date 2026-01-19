package es.ilerna.M0486.ra3.pt22.pt3.anotacions.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.ilerna.M0486.ra3.pt22.pt3.anotacions.Person;
import es.ilerna.M0486.ra3.pt22.pt3.anotacions.Student;

public class Main {

	public static void main(String[] args) {
	
		Session session = null;
		Transaction transaction = null;
		Scanner sc = new Scanner(System.in);
	
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			
			HibernateSession.getSessionFactory().close();
			sc.close();
		}
	}
}
