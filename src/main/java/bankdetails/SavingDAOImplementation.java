package bankdetails;



import java.util.ArrayList;
import java.util.List;






import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SavingDAOImplementation implements SavingAccountDAO
{
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public void create(String name,double blnc,boolean sal)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SavingAccount acc=new SavingAccount(name,blnc,sal);
		session.persist(acc);
		tx.commit();
		session.close();
	}
	public ArrayList<SavingAccount> retrieve(){
		Session session = this.sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Query query= session.createQuery("from SavingAccount");
		ArrayList<SavingAccount> empList= (ArrayList<SavingAccount>) query.list();
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
	         
	         SavingAccount account= (SavingAccount)session.get(SavingAccount.class, accNo);
	         account.setAccName(newName);
			 session.update(account); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
		finally {
	         session.close(); 
	      }
		
	}
	public void delete(int accNo)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx=null;
		try {
	         tx = session.beginTransaction();
	         SavingAccount account= (SavingAccount)session.get(SavingAccount.class, accNo); 
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
	         SavingAccount account= (SavingAccount)session.get(SavingAccount.class, id); 
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
	         SavingAccount account= (SavingAccount)session.get(SavingAccount.class, id); 
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
