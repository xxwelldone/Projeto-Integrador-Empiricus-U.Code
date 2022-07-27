package Entities;

import java.time.LocalDate;

public class ContaPoupanca extends Conta { public ContaPoupanca(int numero, String cpf, int diaAniversarioPoupanca) {
		super(numero, cpf);
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}

	private int diaAniversarioPoupanca;

	public int getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}

	public void setDiaAniversarioPoupanca(int diaAniversarioPoupanca) {
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}

	public void correcao (int dia) {
		
		if(diaAniversarioPoupanca == dia) {
			double correcao = getSaldo()* 0.05;
			credito(correcao);
			
			System.out.println("Alteração de +0,05% no saldo!");		//SUGESTAO DE MUDANCA
			System.out.println("Saldo Atual: " + getSaldo());			//SUGESTAO DE MUDANCA
		}
		

	}

	}
	

