package entities;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	// calcula o saque da conta corrente e conta poupança

	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}
	
	// calcula o depósito da conta corrente e conta poupança
	
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
	
	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
	
	
	//valida o saque da conta corrente e poupança
	
	public void getChekingWithdrawInput() {
		System.out.println("Saldo em conta corrente: " + moneyFormat.format(checkingBalance));
		System.out.println("Valor que você deseja sacar da conta corrente: ");
		double amount = input.nextDouble();
		
		//valida se possui saldo
		if ((checkingBalance - amount) >= 0 ) {
			calcCheckingWithdraw(amount);
			System.out.println("Novo saldo da conta corrente: " + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Saldo não pode ser negativo!" + "\n");
		}
	}
	
	public void getSavingWithdrawInput() {
		System.out.println("Saldo em conta poupança: " + moneyFormat.format(savingBalance));
		System.out.println("Valor que você deseja sacar da conta poupança: ");
		double amount = input.nextDouble();
		
		//valida se possui saldo
		
		if ((savingBalance - amount) >= 0 ) {
			calcSavingWithdraw(amount);
			System.out.println("Novo saldo da conta poupança: " + moneyFormat.format(savingBalance));
		} else {
			System.out.println("Saldo não pode ser negativo!" + "\n");
		}
	}
	
	//valida o depósito
	
	public void getCheckingDepositInput() {
		System.out.println("Novo saldo da conta corrente: " + moneyFormat.format(checkingBalance));
		System.out.println("Valor que você deseja depositar na conta corrente: ");
		double amount = input.nextDouble();
		
		if ((checkingBalance + amount) >= 0) {
			calcCheckingDeposit(amount);
			System.out.println("Novo saldo da conta corrente: " + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Saldo não pode ser negativo!" + "\n");
		}
	}
	
	public void getSavingDepositInput() {
		System.out.println("Novo saldo da conta corrente: " + moneyFormat.format(savingBalance));
		System.out.println("Valor que você deseja depositar na conta poupança: ");
		double amount = input.nextDouble();
		
		if ((savingBalance + amount) >= 0) {
			calcSavingDeposit(amount);
			System.out.println("Novo saldo da conta poupança: " + moneyFormat.format(savingBalance));
		} else {
			System.out.println("Saldo não pode ser negativo!" + "\n");
		}
	}
	

}
