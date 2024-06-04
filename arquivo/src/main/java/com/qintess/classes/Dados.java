package com.qintess.classes;

public class Dados {
	
	private double id_preco;
	private double nu_prazo;
	private double vl_preco;

	public Dados () {
		
	}

	public Dados (double id_preco, double nu_prazo, double vl_preco) {
		this.id_preco = id_preco;
		this.nu_prazo = nu_prazo;
		this.vl_preco = vl_preco;
	}

	public double getId_preco() {
		return id_preco;
	}

	public void setId_preco(double id_preco) {
		this.id_preco = id_preco;
	}

	public double getNu_prazo() {
		return nu_prazo;
	}

	public void setNu_prazo(double nu_prazo) {
		this.nu_prazo = nu_prazo;
	}

	public double getVl_preco() {
		return vl_preco;
	}

	public void setVl_preco(double vl_preco) {
		this.vl_preco = vl_preco;
	}

	@Override
	public String toString() {
		return "Dados [id_preco=" + id_preco + ", nu_prazo=" + nu_prazo
		+ ", vl_preco=" + vl_preco + "]";
	}
}