package bankdetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
public class CurrentDAOImplementation implements CurrentAccountDAO
{
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void create(String name,double sal,double odlimit){
    	Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CurrentAccount acc=new CurrentAccount(name,sal,odlimit);
		session.persist(acc);
		tx.commit();
		session.close();
	
    }
	
	public ArrayList<CurrentAccount> retrieve(){
		Session session = this.sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Query query= session.createQuery("from CurrentAccount");
		ArrayList<CurrentAccount> empList= (ArrayList<CurrentAccount>) query.list();
		transaction.commit();
		session.close();
		return empList;
	}

	public void update(int accNo,String newName)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx=null;
		try {
	         tx = session.beginTransaction();
	         CurrentAccount account= (CurrentAccount)session.get(CurrentAccount.class, accNo); 
	         account.setAccName(newName);
			 session.update(account); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
	}
	public void delete(int accNo)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx=null;
		try {
	         tx = session.beginTransaction();
	         CurrentAccount account= (CurrentAccount)session.get(CurrentAccount.class, accNo); 
	         session.delete(account); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
	}
	public void depositAmt(int id,double amt)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx=null;
		try {
	         tx = session.beginTransaction();
	         CurrentAccount account= (CurrentAccount)session.get(CurrentAccount.class, id); 
	         account.deposit(amt);
			 session.update(account); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
	}
	public void withdrawAmt(int id,double amt)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx=null;
		try {
	         tx = session.beginTransaction();
	         CurrentAccount account= (CurrentAccount)session.get(CurrentAccount.class, id); 
	         account.withdraw(amt);
			 session.update(account); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
	}

}
