package com.qintess.executar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.qintess.classes.Dados;
import com.qintess.classes.Operacoes;

public class Executar {
	public static void main(String[] args) throws  IOException {
		long inicio = System.currentTimeMillis();

		List<Dados> listaDados = new ArrayList<>();
		FileReader fileDados = new FileReader ("C:\\Users\\re042534\\Desktop\\Projetos\\DesafioLer\\arquivo\\DadosMercado.csv");
		BufferedReader buffDados = new BufferedReader (fileDados);
		buffDados.readLine();
		String coluna1;

		while((coluna1 = buffDados.readLine())!= null) {
			String itensDados [] = coluna1.split(";");
			Dados dados = new Dados ();
			double id_preco = Double.parseDouble(itensDados[0]);
			dados.setId_preco(id_preco);
			double nu_prazo = Double.parseDouble(itensDados[1]);
			dados.setNu_prazo(nu_prazo);
			double vl_preco = Double.parseDouble(itensDados[2].replace(",", "."));
			dados.setVl_preco(vl_preco);

			listaDados.add(dados);

		}

		buffDados.close();

		List<Operacoes> listaOperacoes = new ArrayList<>();
		FileReader fileOperacoes = new FileReader ("C:\\Users\\re042534\\Desktop\\Projetos\\DesafioLer\\arquivo\\Operacoes.csv");
		BufferedReader buffOperacoes = new BufferedReader(fileOperacoes);
		buffOperacoes.readLine();
		String coluna2;

		while((coluna2 = buffOperacoes.readLine())!= null) {
			String itensOperacoes [] = coluna2.split(";");
			Operacoes operacoes = new Operacoes ();
			String nm_subproduto= String.valueOf(itensOperacoes[9]);
			operacoes.setNm_subproduto(nm_subproduto);
			double quantidade = Double.parseDouble(itensOperacoes[12].replace(",", "."));
			operacoes.setQuantidade(quantidade);
			int id_preco = Integer.parseInt(itensOperacoes[13]);
			operacoes.setId_preco(id_preco);
			String dt_inicio = String.valueOf(itensOperacoes[1]);
			operacoes.setDt_inicio(dt_inicio);
			String dt_fim = String.valueOf(itensOperacoes[2]);
			operacoes.setDt_fim(dt_fim);
			long prazo = prazo(itensOperacoes[1], (itensOperacoes[2]));
			operacoes.setPrazo(prazo);

			listaOperacoes.add(operacoes);
		}
		buffOperacoes.close();

		List<Resultado> resultado = new ArrayList<>();
		List<Resultado> resultAgrup = new ArrayList<>();

		File respost = new File ("Respost_Agrupada.csv");
		FileWriter resposta = new FileWriter(respost);
		BufferedWriter buffResposta = new BufferedWriter (resposta);
		buffResposta.write("SubProduto;Resultado");


		for (Operacoes opera : listaOperacoes) {

			for (Dados dado : listaDados) {
				//System.out.println("Ola2");
				if(dado.getId_preco() == opera.getId_preco() && opera.getPrazo() == dado.getNu_prazo()) {

					double soma = (dado.getVl_preco() * opera.getQuantidade());
					Resultado answer = new Resultado ( opera.getNm_subproduto(), soma);

					resultado.add(answer);

					break;
				}
			}
		}
		resultAgrup.add(new Resultado (resultado.get(0).getSubProduto()));
		int i = 0;
		for(Resultado answer : resultado) {
			i = 0;
			for(Resultado resul : resultAgrup) {
				if (answer.getSubProduto().equals(resul.getSubProduto())) {
					resul.setResulta(answer.getResulta()+resul.getResulta());

				}else {
					i++;
					if (resultAgrup.size() == i) {
						resultAgrup.add(answer);

						break;
					}
				}
			}
		}

		for (Resultado resulta : resultAgrup) {
			buffResposta.newLine();
			buffResposta.write(resulta.getSubProduto() + ";" + resulta.getResulta());
		}

		buffResposta.flush();
		buffResposta.close();

		long fim = System.currentTimeMillis();
		System.out.println("Tempo:" + (fim - inicio) + "ms");
	}

	public static long prazo(String dataIn, String dataFim) {
		String dataInSplit[] = dataIn.split("/");
		String dataFimSplit[] = dataFim.split("/");

		LocalDate inicio = LocalDate.of(Integer.parseInt(dataInSplit[2])
				, Integer.parseInt(dataInSplit[1])
				, Integer.parseInt(dataInSplit[0]));

		LocalDate fim = LocalDate.of(Integer.parseInt(dataFimSplit[2])
				, Integer.parseInt(dataFimSplit[1])
				, Integer.parseInt(dataFimSplit[0]));

		return ChronoUnit.DAYS.between(inicio, fim);
	}
}