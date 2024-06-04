package com.qintess.classes;

public class Operacoes {
	
	private String nm_subproduto; //9
	private double quantidade; //12
	private int id_preco; //13
	private String dt_inicio; //1
	private String dt_fim; //2
	private long prazo; //1 e 2

	public Operacoes() {
	}
	
	public Operacoes(String nm_subproduto, double quantidade, int id_preco, String dt_inicio, String dt_fim, long prazo) {
		this.nm_subproduto = nm_subproduto;
		this.quantidade = quantidade;
		this.id_preco = id_preco;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.prazo = prazo;		

	}

	public String getNm_subproduto() {
		return nm_subproduto;
	}

	public void setNm_subproduto(String nm_subproduto) {
		this.nm_subproduto = nm_subproduto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public int getId_preco() {
		return id_preco;
	}

	public void setId_preco(int id_preco) {
		this.id_preco = id_preco;
	}

	public String getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public String getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(String dt_fim) {
		this.dt_fim = dt_fim;
	}

	public long getPrazo() {
		return prazo;
	}

	public void setPrazo(long prazo) {
		this.prazo = prazo;
	}

	@Override
	public String toString() {
		return "Operacoes [nm_subproduto=" + nm_subproduto + ", quantidade=" + quantidade + ", id_preco=" + id_preco
				+ ", dt_inicio=" + dt_inicio + ", dt_fim=" + dt_fim + ", prazo=" + prazo + "]";
	}
}
