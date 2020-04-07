package com.sumanth.project;

import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {

		BankAccount first = new BankAccount("Dr Siddalinga Murthy", "SD1234");
		first.showmenu();
	}
}

class BankAccount {

	int balance;
	int previoustransaction;
	String customername;
	String customerID;

	BankAccount(String cusN, String cusID) {
		customername = cusN;
		customerID = cusID;
	}

	void deposit(int amount) {
		balance = balance + amount;
		previoustransaction = amount;
	}

	void withdrawn(int amount) {
		balance = balance - amount;
		previoustransaction = -amount;
	}

	void getprevioustransaction() {
		if (previoustransaction > 0) {
			System.out.println("Credited :" + previoustransaction);
		} else if (previoustransaction < 0) {
			System.out.println("Debited :" + Math.abs(previoustransaction));
		} else {
			System.out.println("No Transactions");
		}
	}

	void showmenu() {

		char option = '\0';
		Scanner scn = new Scanner(System.in);

		System.out.println("welcome " + customername);
		System.out.println("Your ID is :" + customerID);
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
			case 'A':

				System.out.println("======================================================");
				System.out.println("Balance:  " + balance);
				System.out.println("======================================================");
				System.out.println("\n");
				break;

			case 'B':

				System.out.println("======================================================");
				System.out.println("Enter the amount to withdraw:");
				int amount = scn.nextInt();
				withdrawn(amount);
				System.out.println("\n");
				break;

			case 'C':

				System.out.println("======================================================");
				System.out.println("Enter the amount to Deposit :");
				int amount1 = scn.nextInt();
				deposit(amount1);
				System.out.println("\n");
				break;

			case 'D':
				System.out.println("======================================================");
				System.out.println("Your previous transaction is :");
				getprevioustransaction();
				break;

			case 'E':
				System.out.println("******************************************************");
				break;

			default:
				System.out.println("Invalid option.... Please try again");
				break;

			}

		} while (option != 'E');
		System.out.println("Thank you have a great day");

	}
}
