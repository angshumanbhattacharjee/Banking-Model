package bankdetails;

import java.util.ArrayList;
import java.util.List;

public interface CurrentAccountDAO {
	public void create(String name,double sal,double odlimit);
	public ArrayList<CurrentAccount> retrieve();
	public void update(int accNo,String newName);
	public void delete(int accNo);
	public void depositAmt(int id,double amt);
	public void withdrawAmt(int id,double amt);
}
