package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student st = new Student();
		st.setId(104);
		st.setName("Tony");
		st.setCity("Mumbai");
		System.out.println(st);

//		creating object of Address class

		Address ad = new Address();
		ad.setStreetNo(10001);
		ad.setStreetName("XYZ");
		ad.setCity("Banglore");
		ad.setAddedDate(new Date());
		ad.setX(373294.4238);

//		reading image

		FileInputStream fis = new FileInputStream("src/main/java/Shashikant.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = factory.openSession();
		session.beginTransaction();
		session.save(st);
		session.save(ad);
		session.getTransaction().commit();
		session.close();
		System.out.println("Done...");

	}
}
