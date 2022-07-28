package Entities;

import java.util.Scanner;

// Geisiele Luzia Deda

public class ContaEspecial extends Conta {
	
	private Double limite = 1000d;

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	// Construtor
	public ContaEspecial(int numero, String cpf) {
		super(numero, cpf);
		
		System.out.println("Você tem R$ " + limite + " de limite."); //temos que verificar se há limite disponível.
		System.out.println("Deseja utilizar? (1- Sim / 2- Não)");
		
		Scanner scanner = new Scanner(System.in);
		int resposta = scanner.nextInt();
		
		if(resposta == 1) {
			boolean finalizar = false;
			do {
				
				System.out.println("Digite o valor desejado: ");
				double valorSolicitado = scanner.nextDouble();
				
				if(valorSolicitado>limite) {
					System.out.println("O valor excede o seu limite");
				}else {
					usarLimite(valorSolicitado);
					finalizar = true;
					//TODO Chamar o método do menu inicial			

				}
				
			} while(finalizar == false);
		}else if(resposta == 2){
			//TODO Chamar o método do menu inicial			
		}else {
			System.out.println("Resposta inválida, tente novamente!");
		}
		scanner.close();
	}
	
	public void usarLimite (double valor) {
		if(valor<=limite) {
			super.credito(valor);
			limite-=valor;
		}else
			System.out.println("Valor indisponível, seu saldo atual é R$ " + limite);
				
	}
		
//	public void usarLimite(double valor) {
//		double valorDisponivel = getSaldo() + limite;
//		if(valorDisponivel>=valor) {
//			super.debito(valor, limite);
//			setLimite(valorDisponivel-valor);
//		}
//	}
//	
//	@Override
//	public void credito(double valor) {
//		double valorUtilizadoLimite = 1000 - limite;
//		if(valorUtilizadoLimite>0) {
//			if(valor>valorUtilizadoLimite) {
//				limite += valorUtilizadoLimite;	
//				super.credito(valor-valorUtilizadoLimite);
//			}else {
//				limite += valor;
//			}
//		}else {
//			super.credito(valor);
//		}
//	}
}
