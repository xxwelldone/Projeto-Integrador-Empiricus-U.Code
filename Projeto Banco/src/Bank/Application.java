package Bank;

import java.util.Scanner;

import Entities.ContaEstudantil;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o número da conta: ");
		int conta = sc.nextInt();
		
		System.out.println("Digite o CPF: ");
		String cpf = sc.nextLine();
		sc.nextLine();
		ContaEstudantil student = new ContaEstudantil (conta, cpf);
		
	}

}
