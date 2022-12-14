package Entities;

import java.util.Scanner;

//Wesley Menezes

public class ContaEstudantil extends Conta {

// This variable is only accessible via method, for that reason it does not have a "set" method.	
	private double emprestimoLimite = 5000;

	public double getEmprestimoLimite() {
		return emprestimoLimite;
	}

// This method is only going to be invoked once the user agrees with the loan and inform the value.

	public void pedirEmprestimo(double valor) {

		if (valor <= emprestimoLimite) {
			super.credito(valor);
			emprestimoLimite -= valor;
			System.out.println("===============================");
			System.out.println("Seu limite atual de emprestimo é de: " + emprestimoLimite);
			System.out.println("===============================");
		} else
			System.out.println(
					"Infelizmente não é possível solicitar emprestimo neste valor. Seu limite de emprestimo é de: "
							+ emprestimoLimite);
	}

/* Method that checks and let user pay for loan acquired .
	It is only possible to delete account and have boolean as false once debt is paid.*/ 
	public void pagarEmprestimo(double valor) {

		if (valor <= super.getSaldo()) {
			super.debito(valor);
			emprestimoLimite += valor;
			System.out.println("===============================");
			System.out.println();
			System.out.println("Seu pagamento foi de " + valor + ". Seu limite subiu para " + emprestimoLimite
					+ ". Agora você pode encerrar a conta.");

		} else {
			System.out.println("===============================");
			System.out.println();
			System.out.println(
					"Valor inserido maior que saldo em conta. Você precisa ter saldo em conta maior que pagamento da divida.");
			System.out.println();
			System.out.println("===============================");
		}
	}

// Method for navigation inside Student Account
	public void nav() {
		int question;
		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja realizar alguma nova operação?");
		System.out.println("1 - Sim || 2 - Não");
		System.out.println();
		question = sc.nextInt();

		/* Start of a loop where, while the user still wants to make a new operation, it
		 still offers the possibilities to them.*/

		while (question == 1) {
			System.out.println("=================================");
			System.out.println("|| 1 - Débito                  ||");
			System.out.println("|| 2 - Crédito                 ||");
			System.out.println("|| 3 - Emprestimo              ||");
			System.out.println("|| 4 - Pagar divida em aberto  ||");
			System.out.println("|| 5 - Sair/Encerrar           ||");
			System.out.println("===============================");

			int operacoes = sc.nextInt();

			// Switch separating the operations

			switch (operacoes) {
			case 1:
				System.out.println("===============================");
				System.out.println("Informe o valor a ser debitado: ");
				double debito = sc.nextDouble();
				super.debito(debito);
				System.out.println("===============================");
				break;
			case 2:
				System.out.println("===============================");
				System.out.println("Informe o valor a ser creditado: ");
				double credito = sc.nextDouble();
				super.credito(credito);
				System.out.println("===============================");
				break;
			case 3:
				System.out.println("===============================");
				System.out.print("Informe o valor que irá solicitar:");
				double valor = sc.nextDouble();
				pedirEmprestimo(valor);
				System.out.println("Seu saldo atual é de :" + super.getSaldo() + "\n"
						+ "Seu limite de empréstimo atual é de:" + emprestimoLimite);
				System.out.println("===============================");
				break;
			case 4:
				if (emprestimoLimite - 5000 == 0) {
					System.out.println("Você não tem dívidas em aberto.");
				} else {
					System.out.println("===============================");
					System.out.println("Você tem " + (5000 - emprestimoLimite) + " em aberto");
					System.out.print("Insira o valor de pagamento para confirmar operação: ");
					double pagamento = sc.nextDouble();
					if (pagamento > 5000 - emprestimoLimite) {
						System.out.println("===============================");
						System.out.println();
						System.out.println(
								"Você digitou um valor maior do que o esperado para o limite atribuído a sua conta. "
										+ "O pagamento deve cobrir apenas o valor obtido de empréstimo.");
						System.out.println();
						System.out.println("===============================");
					} else {
						System.out.println("===============================");
						System.out.println();
						System.out.println("Pagamento realizado");
						System.out.println();
						pagarEmprestimo(pagamento);
						System.out.println("===============================");

					}
				}
				break;
/* Since buffer still had the number "1" in it, it wouldn't stop while loop even once account was cancelled, 
	a workaround was to set 'question' to zero so once cancelled it would automatic return to main menu.*/
			case 5:
				cancelar();
				question = 0;
				break;

			default:
				System.out.println("===============================");
				System.out.println("A opção digitada não está correta.");
				System.out.println("===============================");
				break;
			}
		
			
		}
		
/* To solve a problem of continuation in a menu I decided to use If Structure, jump user to cancel method and then, 
		if the intention isn't cancelling, bring it back to the while loop.*/

		if (question==2) {
			cancelar();
			}
	}

// Method for deleting account and checking whether it has debts or not before allowing and setting boolean attribute as false.
	public void cancelar() {
		int cancelQuest;
		Scanner sc = new Scanner(System.in);
		System.out.println("===============================");
		System.out.println();
		System.out.println("Deseja continuar usando nossa conta ou pretende encerrar?");
		System.out.println("1 - Encerrar | 2 - Continuar");
		System.out.println();
		cancelQuest = sc.nextInt();

		switch (cancelQuest) {
		case 1:
			if (emprestimoLimite < 5000) {
				System.out.println("============== Atenção ==================");
				System.out.println();
				System.out.println(
						"Você ainda não liquidou seu valor de empréstimo. Para encerrar sua conta é preciso liquidar o empréstimo.");
				System.out.println("Seu valor de limite de empréstimo atual é de: " + emprestimoLimite);
				System.out.println();
				System.out.println("===============================");
				nav();
			} else {
				super.setAtivo(false);
				System.out.println("===============================");
				System.out.println();
				System.out.println("Conta encerrada T.T ");
				System.out.println();
				System.out.println("===============================");

			}
			break;

		case 2:
			nav();
			break;
		}
	}

// To make the main class shorter all the necessary steps are included inside the constructor.

	public ContaEstudantil(int numero, String cpf) {
		super(numero, cpf);
		Scanner sc = new Scanner(System.in);
		System.out.println("===============================");
		System.out.println("       Banco Nirvana G6");
		System.out.println("  Seu paraiso financeiro");
		System.out.println("===============================");
		System.out.println("Olá,");
		System.out.println("Seu saldo atual: R$ " + super.getSaldo());
		System.out.println("===============================");
		super.setAtivo(true);
		// From this point on starts the logic of asking for banking operations and
		// whether to have a loan or not.

		// First try on asking for loan
		System.out.println(
				"Seu tipo de conta é estudantil e isso te da direito à um emprestimo de até 5 mil. Deseja solicitar?");
		System.out.println("1- Sim | 2 - Não");
		System.out.println();
		int resp = sc.nextInt();

		switch (resp) {
		case 1:
			System.out.print("Informe o valor que irá solicitar:");
			double valor = sc.nextDouble();
			pedirEmprestimo(valor);
			break;
		case 2:
			System.out.println("Tudo bem :)");
			break;
		default:
			System.out.println("Não estava esperando essa resposta. Tente novamente, por favor.");
			break;

		}
		// Method for navegation in the account
		nav();
		

	}

}