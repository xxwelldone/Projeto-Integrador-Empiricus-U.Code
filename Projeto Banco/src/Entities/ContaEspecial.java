package Entities;

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
	}
		
	@Override
	public void debito(double valor) {
		double valorDisponivel = getSaldo() + limite;
		if(valorDisponivel>=valor) {
			super.debito(valor, limite);
			setLimite(valorDisponivel-valor);
		}
	}
	
	@Override
	public void credito(double valor) {
		double valorUtilizadoLimite = 1000 - limite;
		if(valorUtilizadoLimite>0) {
			if(valor>valorUtilizadoLimite) {
				limite += valorUtilizadoLimite;	
				super.credito(valor-valorUtilizadoLimite);
			}else {
				limite += valor;
			}
		}else {
			super.credito(valor);
		}
	}
}
