package Entities;

import java.util.Scanner;

// JULIO BATISTA BRAGA

public class ContaCorrente extends Conta {

//===============================================================================================================
//INITIATION ATRIBUTES
	private int contadorTalao = 0;
	private int resposta = 1;
	private int movimentoEsco = 1;
	private int contaMov = 0;
	private int valorDeb = 0;
	private int valorCre = 0;
	private int respSair = 1;
//END ATRIBUTES
//===============================================================================================================
//INITIATION SCANNER
Scanner imput1 = new Scanner(System.in);
//===============================================================================================================
//INITIATION METHOD PEDIR TALAO
	void pedirTalao() {
		System.out.println("É possivel solicitar até três cheques, cada um no valor de 30,00");
		
		do {
			System.out.println("Deseja solicitar cheque?");
			System.out.println("Digite uma das duas opcoes abaixo:");
			System.out.println("1- Sim");
			System.out.println("2- Nao");
			resposta = imput1.nextInt();
			
			if (resposta == 1) {
				if (getSaldo() >= 30) {
					contadorTalao += 1;
					System.out.println("Voce solicitou cheque...");
					debito(30);
					System.out.println("Quantidades de cheques solicitados: " + contadorTalao);
					System.out.println("Saldo atual: " + getSaldo());
					} else {
						System.out.println("Saldo insuficiente!");
					}
			}
			if (resposta == 2) {
				do {
					if (respSair != 1 && respSair != 2) {
						System.out.println("Erro, tente novamente");
					}
				System.out.println("");
				System.out.println("1 - Sair da Conta");
				System.out.println("2 - Encerrar Conta");
				System.out.print("Informe a opção desejada: ");
				respSair = imput1.nextInt();
				
				if (respSair == 1) {
					System.out.println("Obrigado por utilizar o banco Nirvana G6");
					System.out.println("Saindo da conta..");
				} else if (respSair == 2) {
					if (getSaldo() > 0) {
						System.out.println("No momento não é possivel encerrar sua conta, você precisa zerar seu saldo de R$ " + getSaldo());
						System.out.println("Saindo...");
						
					}else if (getSaldo() == 0) {
						System.out.println("Obrigado por utilizar o banco Nirvana G6");
						System.out.println("Encerrando conta..");
						super.setAtivo(false);
						System.out.println("Conta encerrada");
						System.out.println("Saindo...");
					}
					
				}
				
				} while (respSair != 1 && respSair != 2);
				
			}
				
			if (resposta != 1 && resposta != 2) {
				System.out.println("Resposta inválida, tente novamente!");
			}
			
			if (contadorTalao == 3) {
				do {
					if (respSair != 1 && respSair != 2) {
						System.out.println("Erro, tente novamente");
					}
				System.out.println("");
				System.out.println("1 - Sair da Conta");
				System.out.println("2 - Encerrar Conta");
				System.out.print("Informe a opção desejada: ");
				respSair = imput1.nextInt();
				
				if (respSair == 1) {
					System.out.println("Obrigado por utilizar o banco Nirvana G6");
					System.out.println("Saindo da conta..");
				} else if (respSair == 2) {
					if (getSaldo() > 0) {
						System.out.println("No momento não é possivel encerrar sua conta, você precisa zerar seu saldo de R$ " + getSaldo());
						System.out.println("Saindo...");
						
					}else if (getSaldo() == 0) {
						System.out.println("Obrigado por utilizar o banco Nirvana G6");
						System.out.println("Encerrando conta..");
						super.setAtivo(false);
						System.out.println("Conta encerrada");
						System.out.println("Saindo...");
					}
				}
				
				} while (respSair != 1 && respSair != 2);
			}
			
		} while (resposta != 2 && contadorTalao < 3);
	}
//END METHOD PEDIR TALAO
//===============================================================================================================
//INITIATION METHOD APRESENTACAO CONTA
	void apresentacao() {
		System.out.println("Voce escolheu: Conta Corrente");
		System.out.println();
		System.out.println("Nirvana G6");
		System.out.println("Seu paraíso financeiro");
		System.out.println();
		System.out.println("Conta Corrente");
		System.out.println();
		System.out.println("Saldo atual: R$ " + getSaldo());
	}
//END METHOD APRESENTACAO CONTA
//===============================================================================================================
//INITIATION METHOD ESCOLHER MOVIMENTO
	void escolherMov() {
		do {
			if (movimentoEsco != 1 && movimentoEsco != 2) {
				System.out.println("Erro, código inválido!");
				System.out.println("Tente novamente");
				System.out.println();
			}
				System.out.println("1 - Débito");
				System.out.println("2 - Crédito");
				System.out.println("3 - Cancelar/Sair");
				System.out.print("Escolha o movimento que deseja realizar:");
				movimentoEsco = imput1.nextInt();
				
			} while (movimentoEsco != 1 && movimentoEsco != 2 && movimentoEsco != 3);
	}
//END METHOD ESCOLHER MOVIMENTO
//===============================================================================================================
//INITIATION METHOD DEBITO
	void movDebito() {
		contaMov += 1;
		System.out.println("Voce escolheu: Débito");
		System.out.print("Digite o valor a ser debitado: ");
		valorDeb = imput1.nextInt();
	}
//END METHOD DEBITO
//===============================================================================================================
//INITIATION METHOD CREDITO
	void movCredito() {
		contaMov += 1;
		System.out.println("Voce escolheu: Crédito");
		System.out.print("Digite a valor a ser creditado: ");
		valorCre = imput1.nextInt();
	}
//END METHOD CREDITO
//===============================================================================================================
//INITIATION METHOD SAIR
	void movSair() {
		System.out.println();
		System.out.println("Voce escolheu: Sair");
		pedirTalao();
	}
//END METHOD SAIR
//===============================================================================================================
//INITIATION CONSTRUCTOR
	public ContaCorrente(int numero, String cpf) {
		super(numero, cpf);
		super.setAtivo(true);
		apresentacao();
		do {
			escolherMov();
			
		if (movimentoEsco == 1) {
				movDebito();
				debito(valorDeb);
			}
			
		if (movimentoEsco == 2) {
				movCredito();
				credito(valorCre);
			}
		
		if (movimentoEsco == 3) {
			movSair();
		}
			
		} while (contaMov < 1000 && movimentoEsco != 3);
	}
//END CONSTRUCTOR
//===============================================================================================================
	}
