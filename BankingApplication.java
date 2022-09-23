import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		Scanner scn1 = new Scanner(System.in);
		System.out.println("Enter your Username : ");
		String names = scn1.next();
		System.out.println("Enter your customer ID : ");
		String identity = scn1.next();

		BankAccount first = new BankAccount(names, identity);
		first.showmenu();
	}
}

//create aclass for bankAccount with initializing the variables
class BankAccount {
	Scanner scn = new Scanner(System.in);
	int balance;
	int previoustransaction;
	String customername;
	String customerID;

	//Constructor is created 
	BankAccount(String cusN, String cusID) {
		customername = cusN;
		customerID = cusID;
	}

	// Creating a Method for Deposit
	void deposit(int amount) {
		balance = balance + amount;
		previoustransaction = amount;
	}

	// Creating a Method for WithDraw
	void withdrawn(int amount) {
		balance = balance - amount;
		previoustransaction = -amount;
	}
		
	// Creating a Method to get a previous transactions
	void getprevioustransaction() {
		if (previoustransaction > 0) {
			System.out.println("Credited :" + previoustransaction);
		} else if (previoustransaction < 0) {
			System.out.println("Debited :" + Math.abs(previoustransaction));
		} else {
			System.out.println("No Transactions");
		}
	}

	//This method is doing all operations to get a final result
	void showmenu() {

		char option = '\0';

		System.out.println("Welcome " + customername + " !");
		System.out.println("Your customer ID is :" + customerID);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Withdraw");
		System.out.println("C. Deposit");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");

		do {
			System.out.println("=====================================================");
			System.out.println("Enter the option (A-Balance,B-withdraw,C-Deposit,D-Transactions,E-Exit:");
			System.out.println("=====================================================");
			option = scn.next().charAt(0);
			System.out.println("\n");

			switch (option) {
				case 'A' -> {
					System.out.println("======================================================");
					System.out.println("Balance:  " + balance);
					System.out.println("======================================================");
					System.out.println("\n");
				}
				case 'B' -> {
					System.out.println("======================================================");
					System.out.println("Enter the amount to withdraw:");
					int amount = scn.nextInt();
					withdrawn(amount);
					System.out.println("\n");
				}
				case 'C' -> {
					System.out.println("======================================================");
					System.out.println("Enter the amount to Deposit :");
					int amount1 = scn.nextInt();
					deposit(amount1);
					System.out.println("\n");
				}
				case 'D' -> {
					System.out.println("======================================================");
					System.out.println("Your previous transaction is :");
					getprevioustransaction();
				}
				case 'E' -> System.out.println("======================================================");
				default -> System.out.println("Invalid option.... Please try again");
			}

		} while (option != 'E');
		System.out.println("Thank you have a great day :)");

	}
}
