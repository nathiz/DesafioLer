package com.qintess.executar;
public class Resultado {
	public Resultado() {

	}

	protected String subProduto;
	protected double resulta; 

	public Resultado(String nm_subproduto, double soma) {
		this.subProduto = nm_subproduto;
		this.resulta = soma;
	}

	public Resultado(String subProduto) {
		this.subProduto = subProduto;
	}

	public String getSubProduto() {
		return subProduto;
	}

	public void setSubProduto(String nm_subproduto) {
		this.subProduto = nm_subproduto;
	}

	public double getResulta() {
		return resulta;
	}

	public void setResulta(double soma) {
		this.resulta = soma;
	}

	@Override
	public String toString() {
		return "Resultado [subProduto=" + subProduto + ", resulta=" + resulta + "]";
	}

}
