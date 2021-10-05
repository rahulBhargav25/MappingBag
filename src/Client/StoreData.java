package Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class StoreData {
	public static void main(String[] args)
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory=meta.buildSessionFactory();
		Session session=factory.openSession();

		Transaction t=session.beginTransaction();


		ArrayList<String> list1=new ArrayList<String>();
		list1.add("Java is a programming language");
		list1.add("Java is a platform");

		ArrayList<String> list2=new ArrayList<String>();
		list2.add("Servlet is an Interface");
		list2.add("Servlet is an API");

		Ques q1=new Ques();
		q1.setQname("What is Java?");
		q1.setAnswers(list1);

		Ques q2=new Ques();
		q2.setQname("What is Servlet?");
		q2.setAnswers(list2);

		session.persist(q1);
		session.persist(q2);

		t.commit();
		session.close();

	}
}
