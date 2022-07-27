package Entities;
// Wesley Menezes

public abstract class Conta {
	private int numero;
	private String cpf;
	private double saldo;
	private boolean ativo;
	
	// Getters and Setters 
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSaldo() {
		return saldo;
	}
	/*Saldo does not have a setter for security reasons*/
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	// Constructor 
	public Conta(int numero, String cpf) {
		this.numero = numero;
		this.cpf = cpf;
	}
	// Methods Withdraw and Credit 
	
	public void debito (double valor) {
		if (valor<saldo) {
			saldo -= valor;
			System.out.println("O valor de " + valor + " foi debitado de sua conta");		//SUGESTAO DE MODIFICACAO
		} else {System.out.println("O valor informado é maior que saldo disponível");
		}
	}
	
	//Método criado para realizar o débito na conta especial.
	public void debito (double valor, double limite) {
		double valorDisponivel = getSaldo() + limite;
		if(valorDisponivel>=valor) {
			if(valor>saldo) {
				saldo= 0;
			} else {
				saldo -= valor;
			}
			
		} else {System.out.println("O valor informado é maior que Saldo + Limite disponível. Você tem R$ " + valorDisponivel);
		}
	}
	
	public void credito (double valor) {
		saldo = saldo + valor;
		System.out.println("O valor de " + valor + " foi creditado na sua conta");			//SUGESTAO DE MODIFICACAO
	}
	
}
