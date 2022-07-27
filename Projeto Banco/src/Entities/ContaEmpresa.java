package Entities;

import java.util.Scanner;

//Victor Hugo Pereira

public class ContaEmpresa extends Conta {
	
	public ContaEmpresa(int numero, String cpf) {
		super(numero, cpf);
	}

	private float emprestimoEmpresa = 10000f;
	public float pedido;
	public int resposta;
	
	public float getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}
	
	public void subtrairEmprestimoEmpresa(float pedido) {
		this.emprestimoEmpresa -= pedido;
	}
	
	void pedirEmprestimo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("É possivel pedir emprestado até R$10.000,00");
		
		do {
			System.out.println("Deseja solicitar um empréstimo? (1- Sim / 2- Não)");
			resposta = scanner.nextInt();
			
			if (resposta == 1) {
				float limiteDisponivel = getEmprestimoEmpresa();
				System.out.println("Digite o valor que deseja receber emprestado (Limite disponível :"+ limiteDisponivel+ ")");
				
				pedido = scanner.nextFloat();
				
				if (pedido <= limiteDisponivel) {
					credito(pedido);
					subtrairEmprestimoEmpresa(pedido);
					System.out.println("Empréstimo realizado com sucesso.");
					System.out.println("Saldo atual: " + getSaldo());
					} else {
						System.out.println("Valor indisponível.");
					}
				
			} else if (resposta != 1 || resposta != 2) {
				System.out.println("Resposta inválida, tente novamente!");
			}
			
		} while (resposta != 2 || emprestimoEmpresa < 10000f);
		
		scanner.close();
		
	}
	}
