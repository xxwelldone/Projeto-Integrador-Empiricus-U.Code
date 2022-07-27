package Entities;

import java.util.Scanner;

// JULIO BATISTA BRAGA

public class ContaCorrente extends Conta {

	public ContaCorrente(int numero, String cpf) {
		super(numero, cpf);
	}

	private int contadorTalao = 0;
	private int resposta;
	
	
	public int getContadorTalao() {
		return contadorTalao;
	}
	public void setContadorTalao(int contadorTalao) {
		this.contadorTalao = contadorTalao;
	}
	public int getResposta() {
		return resposta;
	}
	public void setResposta(int resposta) {
		this.resposta = resposta;
	}
	
	void pedirTalao() {
		Scanner imput1 = new Scanner(System.in);
		System.out.println("É possivel solicitar até três cheques, cada um no valor de 30,00");
		
		do {
			System.out.println("Deseja solicitar cheque?");
			System.out.println("Digite uma das duas opcoes abaixo:");
			System.out.print("1- Sim");
			System.out.println("2- Nao");
			resposta = imput1.nextInt();
			
			if (resposta == 1) {
				if (getSaldo() >= 30) {
					debito(30);
					contadorTalao += 1;
					System.out.println("Voce solicitou cheque...");
					System.out.println("30,00 debitados de sua conta corrente");
					System.out.println("Saldo atual: " + getSaldo());
					} else {
						System.out.println("Saldo insuficiente!");
					}
				
			} else if (resposta != 1 || resposta != 2) {
				System.out.println("Resposta inválida, tente novamente!");
			}
			
		} while (resposta != 2 || contadorTalao < 3);
		
		imput1.close();
		
	}
	}
