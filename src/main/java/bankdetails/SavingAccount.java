
package bankdetails;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("SavingAccount")
public class SavingAccount extends BankAccount {
	
	
	
	
	@Column(name="isSalary")
	boolean isSalary;


	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}



	public SavingAccount(String accName, double accBal, boolean isSalary) {
		super(accName, accBal);
		this.isSalary = isSalary;
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @return the isSalary
	 */
	public boolean isSalary() {
		return isSalary;
	}



	/**
	 * @param isSalary the isSalary to set
	 */
	public void setSalary(boolean isSalary) {
		this.isSalary = isSalary;
	}



	@Id
	@Column(name="accNo")
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
		if(amount>accBal) 
		{
			System.out.println("Insufficient funds...");
		}
		else
		{
			 accBal-=amount ;
			System.out.println("Account balance: "+accBal);
		}
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingAccount [isSalary=" + isSalary + ", accNo=" + accNo + ", accName=" + accName + ", accBal="
				+ accBal + "]";
	}



	@Id
	@Column(name="accNo")
	@Override
	public void deposit(double amount) {
		accBal+=amount;
		System.out.println("Account balance: "+accBal);
	}
	
}
