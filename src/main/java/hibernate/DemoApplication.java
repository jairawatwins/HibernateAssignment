package hibernate;

import entity.Department;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import utility.HibernateUtil;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoApplication {


	public static void main(String[] args) {


		SessionFactory factory = new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml")).buildSessionFactory();

		System.out.println(factory);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.getTransaction().commit();
		session.close();
	}
}

