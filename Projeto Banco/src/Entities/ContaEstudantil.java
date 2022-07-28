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
	
	if (valor<= emprestimoLimite) {
		super.credito(valor);
		emprestimoLimite-=valor;
		System.out.println("===============================");
		System.out.println("Seu limite atual de emprestimo é de: "+ emprestimoLimite);
		System.out.println("===============================");
	} else System.out.println("Infelizmente não é possível solicitar emprestimo neste valor. Seu limite de emprestimo é de: "+ emprestimoLimite);
}

// Method that checks and let user pay for loan acquired .
//It is only possible to delete account and have boolean as false once debt is paid. 
public void pagarEmprestimo(double valor) {
	
	if (valor <= super.getSaldo()) {
		super.debito(valor);
		emprestimoLimite+= valor;
		System.out.println("===============================");
		System.out.println();
		System.out.println("Seu pagamento foi de "+ valor+". Seu limite subiu para "+ emprestimoLimite+". Agora você pode encerrar a conta.");


	} else {
		System.out.println("===============================");
		System.out.println();
		System.out.println("Valor inserido maior que saldo em conta. Você precisa ter saldo em conta maior que pagamento da divida.");
		System.out.println();
		System.out.println("===============================");
	}
}


// Method for navigation inside Student Account
public void nav() {
	int question;
	Scanner sc = new Scanner (System.in);
	System.out.println("Deseja realizar alguma nova operação? 1 - Sim || 2 - Não");
	question = sc.nextInt();
	
	// Start of a loop where, while the user still wants to make a new operation, it still offers the possibilities to them. 
	
	while (question==1) {
	
	System.out.println("Informe o tipo de operação que deseja realizar: 1 - Débito | 2 - Crédito | 3 - Emprestimo | 4 - Pagar divida em aberto");
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
			System.out.println("Seu saldo atual é de :" + super.getSaldo()+"\n"+ "Seu limite de empréstimo atual é de:"+ emprestimoLimite);
			System.out.println("===============================");
			break;
		case 4:
			System.out.println("===============================");
			System.out.println("Você tem "+ (emprestimoLimite-5000) + "em aberto");
			System.out.print("Insira o valor de pagamento para confirmar operação: ");
			double pagamento = sc.nextDouble();
			System.out.println("===============================");
			pagarEmprestimo(pagamento);
			break;
			
		default:
			System.out.println("===============================");
			System.out.println("A opção digitada não está correta.");
			System.out.println("===============================");
			break;
	}
	// Finishing the Switch, we are still in the While loop making sure the user are still interested on making new baking operations 
	
	System.out.println("Fim da operação. Deseja realizar uma nova operação? 1 - Sim | 2 - Não");
	question = sc.nextInt();
	} 
	// Checking if there are debts and whether to delete account or not.
	cancelar();
//	
//	System.out.println("Até mais ;)");

}

// Method for deleting account and checking whether it has debts or not before allowing and setting boolean attribute as false.
public void cancelar() {
	int cancelQuest;
	Scanner sc = new Scanner(System.in);
	System.out.println("===============================");
	System.out.println();
	System.out.println("Deseja continuar usando nossa conta ou pretende encerrar? 1 - Encerrar | 2 - Continuar");
	cancelQuest = sc.nextInt();
	
	switch (cancelQuest) {
	case 1:
			if (emprestimoLimite<5000) {
			System.out.println("============== Atenção ==================");
			System.out.println();
			System.out.println("Você ainda não liquidou seu valor de empréstimo. Para encerrar sua conta precisa é preciso liquidar o empréstimo.");
			System.out.println("Seu valor de limite de empréstimo atual é de: "+ emprestimoLimite);
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
			sc.close();
			}
			break;
			
	case 2 :  nav();
		break;
	}
	}
	 
		
	

// To make the main class shorter all the necessary steps are included inside the constructor.

public ContaEstudantil(int numero, String cpf) {
	super(numero, cpf);
	Scanner sc = new Scanner (System.in);
	System.out.println("===============================");
	System.out.println("       Banco Nirvana G6");
	System.out.println("  Seu paraiso financeiro");
	System.out.println("===============================");
	System.out.println("Olá,");
	System.out.println("Seu saldo atual: R$ "+ super.getSaldo());
	System.out.println("===============================");
	
	// From this point on starts the logic of asking for banking operations and whether to have a loan or not. 
	
	//First try on asking for loan
	System.out.println("Seu tipo de conta é estudantil e isso te da direito à um emprestimo de até 5 mil. Deseja solicitar? 1- Sim | 2 - Não");
	int resp = sc.nextInt();
	
	if (resp ==1) {
		System.out.print("Informe o valor que irá solicitar:");
		double valor = sc.nextDouble();
		pedirEmprestimo(valor);
	} else {
		System.out.println("Tudo bem :)" );
		}
	
	// Method for navegation in the account
	nav();

	sc.close();
	
	
		
}
	
}
