package crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pojo.FormDetails;


public class CRUDImplementations {
	
	SessionFactory sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void create(String name, String pw,String mail,long num,int ag ,String gen) {
		
		Session sess;
		sess = sessFact.openSession();
		FormDetails ob = new FormDetails();
		
		ob.setUname(name);
		ob.setEmail(mail);
		ob.setPword(pw);
		ob.setAge(ag);
		ob.setNum(num);
		ob.setGender(gen);
		
		sess.beginTransaction();
		sess.persist(ob);
		sess.getTransaction().commit();
		System.out.println("Object Persisted");
	}
	
	public List<FormDetails> retrieve() {
		
		Session sess = sessFact.openSession();
		
		List<FormDetails> data = sess.createQuery("from FormDetails").list();
		
		for(FormDetails fd: data) {
			System.out.println("Username: "+fd.getUname()+", Email: "+fd.getEmail()+", Password: "+fd.getPword()+", Contact Number: "+fd.getNum()+", Age: "+fd.getAge()+", Gender: "+fd.getGender());
		}
		
		return data;
		
	}
	
	public void update(int id,String name, String pword,String email,long num,int age ,String gender) {
		
		Session sess;
		sess = sessFact.openSession();
	    Query qob = sess.createQuery("Update FormDetails set NAME = :name, EMAIL = :email, PASSWORD = :pword, AGE = :age, GENDER = :gender, NUMBER = :num where id = :x");
		sess.beginTransaction();
		qob.setParameter("name", name);
		qob.setParameter("email", email);
		qob.setParameter("pword", pword);
		qob.setParameter("num", num);
		qob.setParameter("age", age);
		qob.setParameter("gender", gender);
		qob.setParameter("x", id);
		qob.executeUpdate();
		sess.getTransaction().commit();
    }
	
	public void delete(int id) {
		
		Session sess;
		sess = sessFact.openSession();
	    Query qob = sess.createQuery("delete from FormDetails where id = :x");
		sess.beginTransaction();
		qob.setParameter("x",id);
		
		qob.executeUpdate();
		sess.getTransaction().commit();
		
	}
	
	
}
