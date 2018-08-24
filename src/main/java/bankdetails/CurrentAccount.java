package bankdetails;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CurrentAccount")
public class CurrentAccount extends BankAccount{

	@Column(name="odlimit")
	double odlimit;
	
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(String accName, double accBal,double odLimit) {
		super(accName, accBal);
		this.odlimit=odLimit;
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the odlimit
	 */
	public double getOdlimit() {
		return odlimit;
	}

	/**
	 * @param odlimit the odlimit to set
	 */
	public void setOdlimit(double odlimit) {
		this.odlimit = odlimit;
	}

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
	
	public void deposit(double amount) {
		accBal+=amount;
		System.out.println("Account balance: "+accBal);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrentAccount [odlimit=" + odlimit + ", accNo=" + accNo + ", accName=" + accName + ", accBal=" + accBal
				+ "]";
	}
	
	

}
