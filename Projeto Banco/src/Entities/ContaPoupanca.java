package Entities;

import java.util.Scanner;

// CARLA VITORIA F P SANTOS

public class ContaPoupanca extends Conta {
	public ContaPoupanca(int numero, String cpf) {
		super(numero, cpf);
	}

	private int diaAniversarioPoupanca;

	public int getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}

	public void setDiaAniversarioPoupanca(int diaAniversarioPoupanca) {
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}

	public void correcao(int dia) {

		if (diaAniversarioPoupanca == dia) {
			double correcao = getSaldo() * 0.05;
			credito(correcao);

		}

	}

	public static void exibirMenu() {
		
		int opcaoSelecionada = 1;
		int contaMovimentos = 0;
		int valorDebito;
		int continuarPergunta = 1;
		int dataAtual;
		int valorCredito;
		
		Scanner leitor = new Scanner(System.in);
		
			System.out.println("Voce escolheu: Conta Poupança");		
			System.out.println();
			System.out.println("Nirvana G6");
			System.out.println("Seu paraiso financeiro");
			System.out.println("Conta Poupança");						
			
			System.out.print("Insira o numero da conta: ");				
			int numeroConta = leitor.nextInt();
			System.out.print("Insira o CPF: ");
			String cpf = leitor.next();									
			
			ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, cpf);
			
			System.out.println("Saldo Atual: R$ " + contaPoupanca.getSaldo());
			
			do {											
				do {
					if (opcaoSelecionada != 1 && opcaoSelecionada != 2) {
						System.out.println("Erro, código inválido!");
						System.out.println("Tente novamente");
						System.out.println("1 - DÉBITO");
						System.out.println("2 - CRÉDITO");
						System.out.println("3 - CANCELAR/SAIR");
						System.out.print("Escolha o movimento que deseja realizar:");
						opcaoSelecionada = leitor.nextInt();
					}
					else {
						System.out.println("1 - DÉBITO");
						System.out.println("2 - CRÉDITO");
						System.out.println("3 - CANCELAR/SAIR");
						System.out.print("Escolha o movimento que deseja realizar:");
						opcaoSelecionada = leitor.nextInt();
					}
					
					
				} while (opcaoSelecionada != 1 && opcaoSelecionada != 2 && opcaoSelecionada != 3);
				
			
			if (opcaoSelecionada == 1) {
				contaMovimentos += 1;
				System.out.println("Voce escolheu: Débito");
				System.out.print("Digite o valor a ser debitado: ");
				valorDebito = leitor.nextInt();
				contaPoupanca.debito(valorDebito);
				System.out.println("Saldo Atual: R$ " + contaPoupanca.getSaldo());
				
				do {
					if (continuarPergunta != 1 && continuarPergunta != 2) {
						System.out.println("Erro, resposta invalida");
						System.out.println("Tente novamente");
						System.out.println("Deseja continuar?");
						System.out.println("1 - SIM");
						System.out.println("2 - NAO");
						continuarPergunta = leitor.nextInt();
					} else {
					System.out.println("Deseja continuar?");
					System.out.println("1 - SIM");
					System.out.println("2 - NAO");
					continuarPergunta = leitor.nextInt();
					}
					
				} while (continuarPergunta != 1 && continuarPergunta != 2);
				
				if (continuarPergunta == 1) {
					
				} else if (continuarPergunta == 2){
					System.out.println("Voce escolheu: Sair");					
					System.out.print("Insira a data atual: ");
					dataAtual = leitor.nextInt();
					System.out.print("Insira o dia de aniversário: ");
					contaPoupanca.setDiaAniversarioPoupanca(leitor.nextInt());						
					
					contaPoupanca.correcao(dataAtual);								
					
					System.out.println();
					System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
					System.out.println("Saindo...");	
					System.exit(0);
				}
				
				
			} else if (opcaoSelecionada == 2) {
				contaMovimentos += 1;
				System.out.println("Voce escolheu: Crédito");
				System.out.print("Digite a valor a ser creditado: ");
				valorCredito = leitor.nextInt();
				contaPoupanca.credito(valorCredito);
				System.out.println("Saldo Atual: R$ " + contaPoupanca.getSaldo());
				
				do {
					if (continuarPergunta != 1 && continuarPergunta != 2) {
						System.out.println("Erro, resposta invalida");
						System.out.println("Tente novamente");
						System.out.println("Deseja continuar?");
						System.out.println("1 - SIM");
						System.out.println("2 - NAO");
						continuarPergunta = leitor.nextInt();
					} else {
					System.out.println("Deseja continuar?");
					System.out.println("1 - SIM");
					System.out.println("2 - NAO");
					continuarPergunta = leitor.nextInt();
					}
					
				} while (continuarPergunta != 1 && continuarPergunta != 2);
				
				if (continuarPergunta == 1) {
					
				} else if (continuarPergunta == 2){
					System.out.println("Voce escolheu: Sair");					
					System.out.print("Insira a data atual: ");
					dataAtual = leitor.nextInt();
					System.out.print("Insira o dia de aniversário: ");
					contaPoupanca.setDiaAniversarioPoupanca(leitor.nextInt());					
					
					contaPoupanca.correcao(dataAtual);								
					
					System.out.println();
					System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
					System.out.println("Saindo...");	
					System.exit(0);
				}
				
			} else if (opcaoSelecionada == 3) {
				System.out.println("Voce escolheu: Sair");					
				System.out.print("Insira a data atual: ");
				dataAtual = leitor.nextInt();
				System.out.print("Insira o dia de aniversário: ");
				contaPoupanca.setDiaAniversarioPoupanca(leitor.nextInt());				
				
				contaPoupanca.correcao(dataAtual);								
				
				System.out.println();
				System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
				System.out.println("Saindo...");	
				System.exit(0);
			}
			} while (contaMovimentos < 10);								
																		
			
			
			System.out.print("Insira a data atual: ");
			dataAtual = leitor.nextInt();
			System.out.print("Insira o dia de aniversário: ");
			contaPoupanca.setDiaAniversarioPoupanca(leitor.nextInt());		
			
			contaPoupanca.correcao(dataAtual);								
			
			
		}
	}
