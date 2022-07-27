package app;

import java.util.Scanner;

import Entities.ContaCorrente;
import Entities.ContaPoupanca;

public class MainBanco {

	public static void main(String[] args) {
		
		// VARIAVEIS DA CLASSE:
		int resposta = 0; 				//USO NO SCANNER
		int contadorLoop = 0; 			//USO DE VERIFICACAO
		int numeroConta;				//USO NO CONSTRUTOR
		String cpf;						//USO NO CONSTRUTOR
		int diaAniversario = 0;
		int dataAtual;
		int movimentoEsco = 1;
		int valorDebito;
		int valorCredito;
		int contaMovimentos = 0;			//CONTADOR MOVIMENTOS
		int continuarPerg = 1;
		
		// ABERTURA DO SCANNER
		Scanner imput = new Scanner(System.in);
		
		System.out.println("Nome do banco");
		// Podemos adicionar thread.sleep para
		// as mensagens aparecerem pausadamente,
		// causando um efeito visual mais agradavel
		System.out.println("Slogan do banco");
		
		do {												//LOOP DE VERIFICACAO DE RESPOSTA
			contadorLoop += 1;
			if (contadorLoop != 1) {						//CONDICAO SERA APRESENTADA EM CASO DE ERRO
				System.out.println("Erro, código inválido!");
				System.out.println("Tente novamente");
			}
			System.out.println("1 - CONTA POUPANÇA");
			System.out.println("2 - CONTA CORRENTE");
			System.out.println("3 - CONTA ESPECIAL");
			System.out.println("4 - CONTA EMPRESA");
			System.out.println("5 - CONTA ESTUDANTIL");
			System.out.println("6 - SAIR");
			System.out.print("Por favor, digite o código da opcao selecionada: ");
			resposta = imput.nextInt();
			
		} while (resposta != 1 && resposta != 2 && resposta != 3 &&
				resposta != 4 && resposta != 5 && resposta != 6);
		
		if (resposta == 1) {
			System.out.println("Voce escolheu: Conta Poupança");		//APRESENTACAO
			System.out.println();
			System.out.println("Nome do banco");
			System.out.println("Slogan do banco");
			System.out.println("Conta Poupança");						//APRESENTACAO
			
			System.out.print("Insira o numero da conta: ");				//DADOS PARA O CONSTRUTOR
			numeroConta = imput.nextInt();
			System.out.print("Insira o CPF: ");
			cpf = imput.next();											//DADOS PARA O CONSTRUTOR
			
			ContaPoupanca pou = new ContaPoupanca(numeroConta, cpf, 	//CONSTRUTOR
					diaAniversario);
			
			System.out.println("Saldo Atual: R$ " + pou.getSaldo());
			
			do {											//LOOP DE VERIFICACAO DE RESPOSTA
				do {
					if (movimentoEsco != 1 && movimentoEsco != 2) {
						System.out.println("Erro, código inválido!");
						System.out.println("Tente novamente");
						System.out.println("1 - DÉBITO");
						System.out.println("2 - CRÉDITO");
						System.out.println("3 - CANCELAR/SAIR");
						System.out.print("Escolha o movimento que deseja realizar:");
						movimentoEsco = imput.nextInt();
					}
					else {
						System.out.println("1 - DÉBITO");
						System.out.println("2 - CRÉDITO");
						System.out.println("3 - CANCELAR/SAIR");
						System.out.print("Escolha o movimento que deseja realizar:");
						movimentoEsco = imput.nextInt();
					}
					
					
				} while (movimentoEsco != 1 && movimentoEsco != 2 && movimentoEsco != 3);
				
			
			if (movimentoEsco == 1) {
				contaMovimentos += 1;
				System.out.println("Voce escolheu: Débito");
				System.out.print("Digite o valor a ser debitado: ");
				valorDebito = imput.nextInt();
				pou.debito(valorDebito);
				System.out.println("Saldo Atual: R$ " + pou.getSaldo());
				
				do {
					if (continuarPerg != 1 && continuarPerg != 2) {
						System.out.println("Erro, resposta invalida");
						System.out.println("Tente novamente");
						System.out.println("Deseja continuar?");
						System.out.println("1 - SIM");
						System.out.println("2 - NAO");
						continuarPerg = imput.nextInt();
					} else {
					System.out.println("Deseja continuar?");
					System.out.println("1 - SIM");
					System.out.println("2 - NAO");
					continuarPerg = imput.nextInt();
					}
					
				} while (continuarPerg != 1 && continuarPerg != 2);
				
				if (continuarPerg == 1) {
					//bloco vazio
				} else if (continuarPerg == 2){
					System.out.println("Voce escolheu: Sair");					//APRESENTACAO
					System.out.print("Insira a data atual: ");
					dataAtual = imput.nextInt();
					System.out.print("Insira o dia de aniversário: ");
					pou.setDiaAniversarioPoupanca(imput.nextInt());							//DADOS PARA O CONSTRUTOR
					
					pou.correcao(dataAtual);								//METODO CORRECAO
					
					System.out.println();
					System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
					System.out.println("Saindo...");	
					System.exit(0);
				}
				
				
			} else if (movimentoEsco == 2) {
				contaMovimentos += 1;
				System.out.println("Voce escolheu: Crédito");
				System.out.print("Digite a valor a ser creditado: ");
				valorCredito = imput.nextInt();
				pou.credito(valorCredito);
				System.out.println("Saldo Atual: R$ " + pou.getSaldo());
				
				do {
					if (continuarPerg != 1 && continuarPerg != 2) {
						System.out.println("Erro, resposta invalida");
						System.out.println("Tente novamente");
						System.out.println("Deseja continuar?");
						System.out.println("1 - SIM");
						System.out.println("2 - NAO");
						continuarPerg = imput.nextInt();
					} else {
					System.out.println("Deseja continuar?");
					System.out.println("1 - SIM");
					System.out.println("2 - NAO");
					continuarPerg = imput.nextInt();
					}
					
				} while (continuarPerg != 1 && continuarPerg != 2);
				
				if (continuarPerg == 1) {
					//bloco vazio
				} else if (continuarPerg == 2){
					System.out.println("Voce escolheu: Sair");					//APRESENTACAO
					System.out.print("Insira a data atual: ");
					dataAtual = imput.nextInt();
					System.out.print("Insira o dia de aniversário: ");
					pou.setDiaAniversarioPoupanca(imput.nextInt());							//DADOS PARA O CONSTRUTOR
					
					pou.correcao(dataAtual);								//METODO CORRECAO
					
					System.out.println();
					System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
					System.out.println("Saindo...");	
					System.exit(0);
				}
				
			} else if (movimentoEsco == 3) {
				System.out.println("Voce escolheu: Sair");					//APRESENTACAO
				System.out.print("Insira a data atual: ");
				dataAtual = imput.nextInt();
				System.out.print("Insira o dia de aniversário: ");
				pou.setDiaAniversarioPoupanca(imput.nextInt());							//DADOS PARA O CONSTRUTOR
				
				pou.correcao(dataAtual);								//METODO CORRECAO
				
				System.out.println();
				System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
				System.out.println("Saindo...");	
				System.exit(0);
			}
			} while (contaMovimentos < 10);								//FIM DO LOOP DAS OPERACOES DE
																		//DEBITO OU CREDITO
			
			
			System.out.print("Insira a data atual: ");
			dataAtual = imput.nextInt();
			System.out.print("Insira o dia de aniversário: ");
			pou.setDiaAniversarioPoupanca(imput.nextInt());							//DADOS PARA O CONSTRUTOR
			
			pou.correcao(dataAtual);								//METODO CORRECAO
			
			
		} else if (resposta == 2) {	//CONTA CORRENTE
			System.out.println("Voce escolheu: Conta Corrente");		//APRESENTACAO
			System.out.println();
			System.out.println("Nome do banco");
			System.out.println("Slogan do banco");
			System.out.println("Conta Corrente");						//APRESENTACAO
			
			System.out.print("Insira o numero da conta: ");				//DADOS PARA O CONSTRUTOR
			numeroConta = imput.nextInt();
			System.out.print("Insira o CPF: ");
			cpf = imput.next();											//DADOS PARA O CONSTRUTOR
			
			ContaCorrente con = new ContaCorrente(numeroConta, cpf);
			
			System.out.println("Saldo Atual: R$ " + con.getSaldo());
			
			do {											//LOOP DE VERIFICACAO DE RESPOSTA
				do {
					if (movimentoEsco != 1 && movimentoEsco != 2) {
						System.out.println("Erro, código inválido!");
						System.out.println("Tente novamente");
						System.out.println("1 - DÉBITO");
						System.out.println("2 - CRÉDITO");
						System.out.println("3 - CANCELAR/SAIR");
						System.out.print("Escolha o movimento que deseja realizar:");
						movimentoEsco = imput.nextInt();
					}
					else {
						System.out.println("1 - DÉBITO");
						System.out.println("2 - CRÉDITO");
						System.out.println("3 - CANCELAR/SAIR");
						System.out.print("Escolha o movimento que deseja realizar:");
						movimentoEsco = imput.nextInt();
					}
					
					
				} while (movimentoEsco != 1 && movimentoEsco != 2 && movimentoEsco != 3);
				
			
			if (movimentoEsco == 1) {
				contaMovimentos += 1;
				System.out.println("Voce escolheu: Débito");
				System.out.print("Digite o valor a ser debitado: ");
				valorDebito = imput.nextInt();
				con.debito(valorDebito);
				System.out.println("Saldo Atual: R$ " + con.getSaldo());
				
				do {
					if (continuarPerg != 1 && continuarPerg != 2) {
						System.out.println("Erro, resposta invalida");
						System.out.println("Tente novamente");
						System.out.println("Deseja continuar?");
						System.out.println("1 - SIM");
						System.out.println("2 - NAO");
						continuarPerg = imput.nextInt();
					} else {
					System.out.println("Deseja continuar?");
					System.out.println("1 - SIM");
					System.out.println("2 - NAO");
					continuarPerg = imput.nextInt();
					}
					
				} while (continuarPerg != 1 && continuarPerg != 2);
				
				if (continuarPerg == 1) {
					//bloco vazio
				} else if (continuarPerg == 2){
					System.out.println("Voce escolheu: Sair");					//APRESENTACAO
					con.pedirTalao(resposta);
					
					System.out.println();
					System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
					System.out.println("Saindo...");	
					System.exit(0);
				}
				
				
			} else if (movimentoEsco == 2) {
				contaMovimentos += 1;
				System.out.println("Voce escolheu: Crédito");
				System.out.print("Digite a valor a ser creditado: ");
				valorCredito = imput.nextInt();
				con.credito(valorCredito);
				System.out.println("Saldo Atual: R$ " + con.getSaldo());
				
				do {
					if (continuarPerg != 1 && continuarPerg != 2) {
						System.out.println("Erro, resposta invalida");
						System.out.println("Tente novamente");
						System.out.println("Deseja continuar?");
						System.out.println("1 - SIM");
						System.out.println("2 - NAO");
						continuarPerg = imput.nextInt();
					} else {
					System.out.println("Deseja continuar?");
					System.out.println("1 - SIM");
					System.out.println("2 - NAO");
					continuarPerg = imput.nextInt();
					}
					
				} while (continuarPerg != 1 && continuarPerg != 2);
				
				if (continuarPerg == 1) {
					//bloco vazio
				} else if (continuarPerg == 2){
					System.out.println("Voce escolheu: Sair");					//APRESENTACAO
					con.pedirTalao(resposta);								//METODO CORRECAO
					
					System.out.println();
					System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
					System.out.println("Saindo...");	
					System.exit(0);
				}
				
			} else if (movimentoEsco == 3) {
				System.out.println("Voce escolheu: Sair");					//APRESENTACAO
				con.pedirTalao(resposta);
				
				System.out.println();
				System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
				System.out.println("Saindo...");	
				System.exit(0);
			}
			} while (contaMovimentos < 10);								//FIM DO LOOP DAS OPERACOES DE
																		//DEBITO OU CREDITO
			
			
			con.pedirTalao(resposta);
			
		} else if (resposta == 3) {
			System.out.println("Voce escolheu: Conta Especial");		//APRESENTACAO
			System.out.println();
			System.out.println("Nome do banco");
			System.out.println("Slogan do banco");
			System.out.println("Conta Especial");						//APRESENTACAO
			
		} else if (resposta == 4) {
			System.out.println("Voce escolheu: Conta Empresa");			//APRESENTACAO
			System.out.println();
			System.out.println("Nome do banco");
			System.out.println("Slogan do banco");
			System.out.println("Conta Empresa");						//APRESENTACAO
			
		} else if (resposta == 5) {
			System.out.println("Voce escolheu: Conta Estudantil");		//APRESENTACAO
			System.out.println();
			System.out.println("Nome do banco");
			System.out.println("Slogan do banco");
			System.out.println("Conta Estudantil");						//APRESENTACAO
			
		} else if (resposta == 6) {
			System.out.println("Voce escolheu: Sair");					//APRESENTACAO
			System.out.println();
			System.out.println("Obrigado por utilizar o banco 'nome do banco'!");
			System.out.println("Saindo...");							//APRESENTACAO
		}
		

	}

}
