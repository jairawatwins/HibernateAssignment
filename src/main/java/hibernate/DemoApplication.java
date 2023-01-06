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
		System.out.println("good morning ");


//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();

		SessionFactory factory = new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml")).buildSessionFactory();

		System.out.println(factory);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Department department = new Department();
		department.setDepName("Science");

		Student student1 = new Student();
		student1.setFirstName("Abhimanyu");
		student1.setLastName("Verma");
		student1.setDepartment(department);

		Student student2 = new Student();
		student2.setFirstName("Rohit");
		student2.setLastName("Sharma");
		student2.setDepartment(department);

		Set<Student> studSet = new HashSet<Student>();
		studSet.add(student1);
		studSet.add(student2);
		department.setStudents(studSet);
//		session.save(department);

		session.getTransaction().commit();
		session.close();
	}
}

