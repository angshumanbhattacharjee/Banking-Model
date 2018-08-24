package bankdetails;

import javax.persistence.*;

import org.hibernate.annotations.DiscriminatorFormula;

@Entity
@Table(name="bankdetails")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING, length=20)
@DiscriminatorValue("bankaccount")
public abstract class BankAccount {
	
	@Id
	@Column(name="accNo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int accNo;
	
	@Column(name="accName")
	public String accName;
	@Column(name="accBal")
	public double accBal;
	
	public BankAccount() {
		
	}
	
	public BankAccount(String accName, double accBal) {
		//this.accNo = accNo;
		this.accName = accName;
		this.accBal = accBal;
	}
	
	public String getAccName() {
		return accName;
	}
	
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getAccNo() {
		return accNo;
	}
	/**
	 * @return the accBal
	 */
	public double getAccBal() {
		return accBal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accName=" + accName + ", accBal=" + accBal + "]";
	}

	public abstract void withdraw(double amount);
	
	public void deposit(double amount) {
		
	}
	
}
