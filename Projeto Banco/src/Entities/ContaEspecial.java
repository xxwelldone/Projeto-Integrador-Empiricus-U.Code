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
		System.out.println("===============================");
		System.out.println("       Banco Nirvana G6");
		System.out.println("  Seu paraiso financeiro");
		System.out.println("===============================");
		System.out.println("Olá você está na sua Conta Especial.");
		Scanner scanner = new Scanner(System.in);
		int resposta;
		do {
			System.out.println("===============================");
			System.out.println("Informe a opção desejada: (1- Creditar / 2- Debitar / 3- Sair)");
			resposta = scanner.nextInt();
			if(resposta == 1) {
				System.out.println("===============================");
				System.out.println("Digite o valor: ");
				double credito = scanner.nextDouble();
				creditarLimite(credito);
				System.out.println("===============================");
				
				System.out.println("Você tem R$ " + getSaldo() + " de saldo.");
			}else if(resposta == 2){
				
				System.out.println("===============================");
				System.out.println("Digite o valor: ");
				double debito = scanner.nextDouble();
				if(debito>getSaldo()) {
					System.out.println("Saldo insuficiente, deseja utilizar limite? (1- Sim / 2- Não)");	
					resposta = scanner.nextInt();
					if(resposta == 1) {
						usarLimite(debito);
						System.out.println("Você tem R$ " + limite + " de limite.");
					}else if(resposta == 2) {
						System.out.println("Débito não permitido.");
					}else {
						System.out.println("Resposta inválida, tente novamente!");
						System.out.println("===============================");
					}
				}else {
					super.debito(debito);
				}
				
				System.out.println("Você tem R$ " + getSaldo() + " de saldo.");
				
			}else if(resposta == 3){
				System.out.println("===============================");
				System.out.println("Obrigado por utilizar o Banco Nirvana G6!");
				System.out.println("Saindo...");
			}else {
				System.out.println("Resposta inválida, tente novamente!");
			}
		}while(resposta != 3);
	}
	
	public void usarLimite(double valor) {
		double valorDisponivel = getSaldo() + limite;
		if(valorDisponivel>=valor) {
			super.debito(valor, limite);
			setLimite(valorDisponivel-valor);
		}
	}

	public void creditarLimite(double valor) {
		double valorUtilizadoLimite = 1000 - limite;
		if(valorUtilizadoLimite>0) {
			if(valor>valorUtilizadoLimite) {
				limite += valorUtilizadoLimite;	
				super.credito(valor-valorUtilizadoLimite);
			}else {
				limite += valor;
			}
		}else {
			super.credito(valor);
		}
	}
	
	public void encerrar () {
		if(limite<1000) {
			System.out.println("===============================");
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
		}
	}
}
