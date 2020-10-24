package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter account data");
	System.out.print("Number:");
	Integer number = sc.nextInt();
	System.out.print("Holder:");
	sc.nextLine();
	String name = sc.nextLine();
	System.out.print("Initial balance: ");
	Double balance = sc.nextDouble();
	System.out.print("Withdraw limit:");
	Double limit = sc.nextDouble();
	
	Account acc = new Account(number, name, balance, limit);
	
	System.out.println();
	System.out.print("Enter amount for withdraw:");
	Double amount = sc.nextDouble();
	try {
		acc.withdraw(amount);
		System.out.print("New balance: "+String.format("%.2f",acc.getBalance()));
	}
	catch(DomainException e) {
		System.out.println("Withdraw error: "+e.getMessage());
	}
	
	

	
	sc.close();
	}

}
