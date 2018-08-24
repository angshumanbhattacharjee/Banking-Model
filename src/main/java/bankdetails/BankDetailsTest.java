package bankdetails;
import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankDetailsTest {

public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	SavingAccountDAO SavingDAO = context.getBean(SavingAccountDAO.class);
	CurrentAccountDAO CurrentDAO = context.getBean(CurrentAccountDAO.class);
// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
String decision;

do {
System.out.println("Select Account Type,Press 1 for Savings Account , 2 for Current Account ");
int type=sc.nextInt();
int id;
String n;
double od=100000;
boolean is;
if(type==1) System.out.println("You have Selected Savings Account ");
if(type==2) System.out.println("You have Selected Current Account ");


System.out.println("Please Select ");

System.out.println("Press 1 :- Create Account ");
System.out.println("Press 2 :- Retrieve Account ");
System.out.println("Press 3 :- Update Account Details");
System.out.println("Press 4 :- Delete Account ");
System.out.println("Press 5 :- Deposit Amount ");
System.out.println("Press 6 :- Withdraw from account ");

// switch statement with choice Selection
int choice=sc.nextInt();
switch (choice) {
case 1:
	System.out.println("Enter your name:");
	n=sc.next();
	if(type==1) {
		System.out.println("Do you have a salary account? true/false");
		is=sc.nextBoolean();
		SavingDAO.create(n,0.0,is);
	}
	if(type==2) {
		CurrentDAO.create(n,0.0,od);
	}
	System.out.println("Account created successfully!!");
    break;
case 2:
	if(type==1) {
		ArrayList<SavingAccount> list=SavingDAO.retrieve();
		for(SavingAccount i: list) System.out.println(i);
	}
	if(type==2) {
		ArrayList<CurrentAccount> list= CurrentDAO.retrieve();
		for(CurrentAccount i: list) System.out.println(i);
	}	
    break;
case 3:
	System.out.println("Enter the account number:");
	id=sc.nextInt();
	System.out.println("Enter the new name:");
	n=sc.next();
	if(type==1) SavingDAO.update(id,n);
	if(type==2) CurrentDAO.update(id,n);
	System.out.println("Account updated successfully!!");
    break;
case 4:
	System.out.println("Enter the account number:");
	id=sc.nextInt();
	if (type==1) SavingDAO.delete(id);
	if (type==2) CurrentDAO.delete(id);
	System.out.println("Account deleted successfully!!");
    break;
case 5:
	System.out.println("Enter the account number:");
	id=sc.nextInt();
	System.out.println("Enter the amount to be deposited:");
	double amt=sc.nextDouble();
	if (type==1) SavingDAO.depositAmt(id,amt);
	if (type==2) CurrentDAO.depositAmt(id, amt);
	System.out.println("Amount deposited successfully!!");
    break;
case 6:
	System.out.println("Enter the account number:");
	id=sc.nextInt();
	System.out.println("Enter the amount to be withdrawn:");
	double amount=sc.nextDouble();
	if (type==1) {SavingDAO.withdrawAmt(id,amount); System.out.println("Amount withdrawn");}
	if (type==2) {CurrentDAO.withdrawAmt(id, amount); System.out.println("Amount withdrawn");}
	break;
default:
System.out.println("Press Correct Key");
    break;
}

System.out.println("Want to continue? Type --yes-- to continue.. or.. --no-- to exit..!! ");
decision=sc.next();

}while(decision.equalsIgnoreCase("yes"));

System.out.println("Thanks.. please visit again!!");
}


}


