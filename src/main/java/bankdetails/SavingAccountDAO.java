package bankdetails;

import java.util.ArrayList;
import java.util.List;

public interface SavingAccountDAO {
	public void create(String name,double blnc,boolean sal);
	public ArrayList<SavingAccount> retrieve();
	public void update(int accNo,String newName);
	public void delete(int accNo);
	public void depositAmt(int id,double amt);
	public void withdrawAmt(int id,double amt);
}
