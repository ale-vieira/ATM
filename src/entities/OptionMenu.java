package entities;

import java.io.IOException;

//Classe principal

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {

	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	// Valida as informa��es de login - conta e senha

	public void getLogin() throws IOException {
		
		try {

			data.put(11111, 123);
			data.put(22222, 123);

			System.out.println("Bem vindo ao projeto ATM!");

			System.out.println("Enter com o n�mero da conta: ");
			setCustomerNumber(menuInput.nextInt());

			System.out.println("Entre com a senha: ");
			setPinNumber(menuInput.nextInt());

		} catch (Exception e) {
			System.out.println("\n" + "Caracterer inv�lidos! Digite apenas n�meros" + "\n");
			
		}
		for (Entry<Integer, Integer> entry : data.entrySet()) {
			if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
				getAccountType();
			} else {
				System.out.print("\n" + "Conta ou senha inv�lidos" + "\n");
				System.out.println();
				getLogin();
			}
		}

	}

	// Exibe o menu principal

	int selection;

	public void getAccountType() {
		System.out.println();
		System.out.println("Selecione o tipo de conta que deseja acessar: ");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Poupan�a");
		System.out.println("3 - Sair");
		System.out.print("Digite a op��o desejada: ");

		selection = menuInput.nextInt();

		switch (selection) {

		case 1:
			System.out.println();
			getChecking();
			break;

		case 2:
			System.out.println();
			getSaving();
			break;

		case 3:
			System.out.println();
			System.out.println("Obrigado por usar esse ATM, at� logo!");
			System.exit(0);
			
		default:
			System.out.println("\n" + "Op��o inv�lida!" + "\n");
			getAccountType();

		}
	}

	// Exibe as op��es de conta corrente

	public void getChecking() {
		System.out.println("Conta Corrente: ");
		System.out.println("1 - Exibir saldo");
		System.out.println("2 - Sacar");
		System.out.println("3 - Depositar");
		System.out.println("4 - Menu principal");
		System.out.print("Digite a op��o desejada: ");

		selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println();
			System.out.println("Saldo da conta corrente: " + moneyFormat.format(getCheckingBalance()));
			getChecking();
			break;
		case 2:
			System.out.println();
			getChekingWithdrawInput();
			getChecking();
			break;
		case 3:
			System.out.println();
			getCheckingDepositInput();
			getChecking();
			break;
		case 4:
			System.out.println();
			getAccountType();
		default:
			System.out.println();
			System.out.println("\n" + "Op��o inv�lida!" + "\n");
			getChecking();

		}
	}

	// Exibe as op��es de conta corrente

	public void getSaving() {
		System.out.println("Conta Poupan�a: ");
		System.out.println("1 - Exibir saldo");
		System.out.println("2 - Sacar");
		System.out.println("3 - Depositar");
		System.out.println("4 - Menu principal");
		System.out.print("Digite a op��o desejada: ");

		selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println();
			System.out.println("Saldo da conta corrente: " + moneyFormat.format(getSavingBalance()));
			getSaving();
			break;
		case 2:
			System.out.println();
			getSavingWithdrawInput();
			getSaving();
			break;
		case 3:
			System.out.println();
			getSavingDepositInput();
			getSaving();
			break;
		case 4:
			System.out.println();
			getAccountType();
		default:
			System.out.println();
			System.out.println("\n" + "Op��o inv�lida!" + "\n");
			getSaving();

		}
	}
}
