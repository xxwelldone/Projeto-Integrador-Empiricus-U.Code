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
		
		setAtivo(true);
		
		System.out.println("===============================");
		System.out.println("       Banco Nirvana G6");
		System.out.println("  Seu paraiso financeiro");
		System.out.println("===============================");
		System.out.println("Olá você está na sua Conta Especial.");
		Scanner scanner = new Scanner(System.in);
		int resposta;
		do {
			System.out.println("Informe a opção desejada: (1- Creditar / 2- Debitar / 3- Sair / 4-Encerrar)");
			resposta = scanner.nextInt();
			if(resposta == 1) {
				System.out.println("===============================");
				System.out.println("Digite o valor: ");
				double credito = scanner.nextDouble();
				creditarLimite(credito);
				
			}else if(resposta == 2){
				
				System.out.println("===============================");
				System.out.println("Digite o valor: ");
				double debito = scanner.nextDouble();
				if(debito>getSaldo()) {
					System.out.println("Saldo insuficiente, você tem R$ " + limite + " de limite. Deseja utilizar? (1- Sim / 2- Não)");	
					resposta = scanner.nextInt();
					if(resposta == 1) {
						usarLimite(debito);
					}else if(resposta == 2) {
						System.out.println("Débito não permitido.");
					}else {
						System.out.println("Resposta inválida, tente novamente!");
						System.out.println("===============================");
					}
				}else {
					super.debito(debito);
				}
				
				System.out.println("Operação realizada com sucesso!");
				
			}else if(resposta == 3){
				System.out.println("===============================");
				System.out.println("Obrigado por utilizar o Banco Nirvana G6!");
				System.out.println("Saindo...");
			
			}else if(resposta == 4){
				encerrar();
				
			}else {
				System.out.println("Resposta inválida, tente novamente!");
			}
		}while(resposta != 3 && isAtivo());
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
		Scanner scanner = new Scanner(System.in);
		if(limite<1000) {
			System.out.println("===============================");
			System.out.println("No momento não é possível encerrar sua conta, você precisa liquidar seu débito R$ " + limite);
		}else {
			if(getSaldo() == 0) {
								
				System.out.println(("Deseja encerrar sua conta? (1- Sim / 2- Não)"));
				int resposta = scanner.nextInt();
				if (resposta == 1) {
					System.out.println("===============================");
					System.out.println("Sua conta foi encerrada. Obrigado por utilizar o Banco Nirvana G6!");
					setAtivo(false);
				}else if(resposta == 2){
					System.out.println("Até breve!"); 			
				}else {
					System.out.println("Resposta inválida, tente novamente!");
				}
			}else {
				System.out.println("No momento não é possível encerrar sua conta, você precisa zerar seu saldo R$ " + getSaldo());
			}
		}
	}
}
