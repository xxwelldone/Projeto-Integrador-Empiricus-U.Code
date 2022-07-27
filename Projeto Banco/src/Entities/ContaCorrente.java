package Entities;

import java.util.Scanner;

// JULIO BATISTA BRAGA

public class ContaCorrente extends Conta {

	public ContaCorrente(int numero, String cpf) {
		super(numero, cpf);
	}

	private int contadorTalao = 0;
	
	public int getContadorTalao() {
		return contadorTalao;
	}
	public void setContadorTalao(int contadorTalao) {
		this.contadorTalao = contadorTalao;
	}
	
	public void pedirTalao(int resposta) {
		Scanner imput1 = new Scanner(System.in);
		System.out.println("É possivel solicitar até três cheques, cada um no valor de 30,00");
		
		do {
			System.out.println("Deseja solicitar cheque?");
			System.out.println("Digite uma das duas opcoes abaixo:");
			System.out.println("1- Sim");
			System.out.println("2- Nao");
			resposta = imput1.nextInt();
			
			if (resposta == 1) {
				if (getSaldo() >= 30) {
					debito(30);
					contadorTalao += 1;
					System.out.println("Voce solicitou cheque...");
					System.out.println("Saldo atual: " + getSaldo());
					} else {
						System.out.println("Saldo insuficiente!");
					}
			if (resposta == 2) {
				System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
				System.out.println("Saindo...");	
				System.exit(0);
				
			}
				
			} else if (resposta != 1 || resposta != 2) {
				System.out.println("Resposta inválida, tente novamente!");
			}
			
		} while (resposta != 2 && contadorTalao < 3);
		
		imput1.close();
		
	}
	}
