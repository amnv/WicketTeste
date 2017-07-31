package br.itep.report;

import java.io.OutputStream;
import java.util.List;

/**
 * Bean com os dados para gerar o relatorio
 * @author allyson.manoel
 */
public class DadosRelatorio {
	private List<DadosJrxml> dados;
	private OutputStream ArquivoSaida;

 /**
 * @param filesName lista de Strings com o nome dos path dos arquivos .jrxml
 * @param parametros parametros preenchidos para ser lancado no relatorio jasper
 * @param arquivoSaida String com o path do arquivo de saida (o arquivo nao precisa ja existir)
 */
	public DadosRelatorio(List<DadosJrxml> dados, OutputStream arquivoSaida) {
		this.dados = dados;
		this.ArquivoSaida = arquivoSaida;
	}

	public List<DadosJrxml> getDados() {
		return dados;
	}

	public void setDados(List<DadosJrxml> dados) {
		this.dados = dados;
	}
	
	public OutputStream getArquivoSaida() {
		return ArquivoSaida;
	}

	public void setArquivoSaida(OutputStream arquivoSaida) {
		ArquivoSaida = arquivoSaida;
	}
}
