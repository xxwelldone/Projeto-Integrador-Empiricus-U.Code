package Entities;

import java.util.Scanner;

//Victor Hugo Pereira

public class ContaEmpresa extends Conta {
	
	// variáveis globais 
	Scanner scanner = new Scanner(System.in);
	private float emprestimoEmpresa = 10000f;
	public float pedido;
	public float pagamento;
	public int resposta;
	
	//métodos get e set de emprestimoEmpresa
	public float getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}
	
	public void subtrairEmprestimoEmpresa(float pedido) {
		this.emprestimoEmpresa -= pedido;
	}
	
	public void pagarEmprestimoEmpresa(float pagamento) {
		this.emprestimoEmpresa += pagamento;
	}
	
	//construtor da conta
	public ContaEmpresa(int numero, String cpf) {
		super(numero, cpf);
		super.setAtivo(true);
		System.out.println("===============================");
		System.out.println("       Banco Nirvana G6");
		System.out.println("  Seu paraiso financeiro");
		System.out.println("===============================");
		System.out.println("Olá,");
		System.out.println("Seu saldo atual: R$" + super.getSaldo());
		System.out.println("===============================");
		
		while(isAtivo()){
			System.out.println("Informe a opção desejada: (1- Creditar / 2- Debitar / 3- Empréstimo / 4-Encerrar)");
			resposta = scanner.nextInt();
			if(resposta == 1) {
				System.out.println("===============================");
				System.out.println("Digite o valor a creditar: ");
				float valor = scanner.nextFloat();
				super.credito(valor);
				
			}else if(resposta == 2){	
				System.out.println("===============================");
				System.out.println("Digite o valor a debitar: ");
				float valor = scanner.nextFloat();
				if(valor >getSaldo()) {
					System.out.println("Saldo insuficiente. ");	
				}else {
					super.debito(valor);				
					System.out.println("Operação realizada com sucesso!");
				}
			}else if(resposta == 3){
				pedirEmprestimo();
				
			}else if(resposta == 4){
				encerrar();
				
			}else {
				System.out.println("Resposta inválida, tente novamente!");
			}
			
			System.out.println("Fim da operação.");					
		};
	}
	
	private void encerrar() {
		float limiteDisponivel = getEmprestimoEmpresa();

		System.out.println("Tem certeza que deseja encerrar sua conta? Se sim, responda '1'. Caso contrário, entre com qualquer outro valor.");
		resposta = scanner.nextInt();
		
		if(resposta == 1){
			if (limiteDisponivel < 10000f) {
				System.out.println("============== Atenção ==================");
				System.out.println("Para encerrar conta, precisas quitar o empréstimo.");
				System.out.println("Sua dívida: R$" + (10000f - getEmprestimoEmpresa()));
				System.out.println("===============================");
			} else {
				super.setAtivo(false);
				System.out.println("===============================");
				System.out.println("Conta encerrada.");
				System.out.println("===============================");

			}
	}
		
	}

	void pedirEmprestimo() {
		float limiteDisponivel = getEmprestimoEmpresa();

		System.out.println("É possivel pedir emprestimo de até "+ limiteDisponivel);
		
		do {
			System.out.println("Selecione uma opção: 1- Pedir empréstimo / 2- Pagar empréstimo / 3- Voltar");
			resposta = scanner.nextInt();
			
			if (resposta == 1) {
				System.out.println("Digite o valor que deseja receber emprestado (Limite disponível:  R$"+ limiteDisponivel+ ")");
				
				pedido = scanner.nextFloat();
				
				if (pedido <= limiteDisponivel) {
					credito(pedido);
					subtrairEmprestimoEmpresa(pedido);
					System.out.println("Empréstimo realizado com sucesso. Valor disponível:  R$" + getEmprestimoEmpresa());
					} else {
						System.out.println("Valor indisponível.");
					}
				
			} else if(resposta == 2){
				System.out.println("Digite o valor que deseja quitar da dívida do empréstimo: ");
				pagamento = scanner.nextFloat();
				pagarEmprestimoEmpresa(pagamento);
				System.out.println("Saldo atual: " + getSaldo());
				System.out.println("Dívida: R$" + (10000f - getEmprestimoEmpresa()));

			}else if(resposta == 3) {
				System.out.println("Saindo...");
			}
			else{
				System.out.println("Resposta inválida, tente novamente!");
			}
			
		} while (resposta != 3);		
	}
	}

