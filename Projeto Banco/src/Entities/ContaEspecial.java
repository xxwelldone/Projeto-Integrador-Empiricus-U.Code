package Entities;

import java.util.Scanner;

// Geisiele Luzia Deda

public class ContaEspecial extends Conta {
	
	private double limite = 1000;

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	// Construtor
	public ContaEspecial(int numero, String cpf) {
		super(numero, cpf);
		
		if(limite>0) {
			System.out.println("Você tem R$ " + getSaldo() + " de saldo.");
			if(getSaldo()>0) {
				System.out.println("Sua conta está positiva, deseja realmente solicitar limite? (1- Sim / 2- Não)");
			}else {
				System.out.println("Deseja solicitar limite? (1- Sim / 2- Não)");
			}
			Scanner scanner = new Scanner(System.in);
			int resposta = scanner.nextInt();
			
			if(resposta == 1) {
				boolean finalizar = false;
				do {
					System.out.println("Você tem R$ " + limite + " de limite.");
					System.out.println("Digite o valor desejado: ");
					double valorSolicitado = scanner.nextDouble();
					
					if(valorSolicitado>limite) {
						System.out.println("O valor excede o seu limite");
					}else {
						usarLimite(valorSolicitado);
						finalizar = true;
					}
					
				} while(finalizar == false);
			}else if(resposta == 2){
				System.out.println("Obrigado.");
			}else {
				System.out.println("Resposta inválida, tente novamente!");
			}
			scanner.close();
		}else {
			System.out.println("Desculpe, você não tem limite disponível.");
		}
		//TODO Chamar o método do menu inicial			
	}
	
	public void usarLimite (double valor) {
		if(valor<=limite) {
			super.credito(valor);
			limite-=valor;
		}else {
			System.out.println("Valor indisponível, seu saldo atual é R$ " + limite);
		}		
	}
	public void encerrar () {
		if(limite<1000) {
			System.out.println("No momento não é possível encerrar sua conta, você precisa liquidar seu débito R$ " + limite);
			System.out.println("Deseja liquidar? (1- Sim / 2- Não)");
			Scanner scanner = new Scanner(System.in);
			int resposta = scanner.nextInt();
			
			if (resposta == 1) {
				//TODO chamar método do crédito
			}else if(resposta == 2){
				System.out.println("Sua conta permanecerá ativa até a liquidação, obrigado"); 			
			}else {
				System.out.println("Resposta inválida, tente novamente!");
			}
			//TODO Chamar o método do menu inicial
			scanner.close();
				
		}
	}
}
