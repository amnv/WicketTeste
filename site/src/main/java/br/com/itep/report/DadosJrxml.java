package br.com.itep.report;

import java.util.Map;

public class DadosJrxml {
	private String fileName;
	private Map<String, Object> parametros;
	
	public DadosJrxml(String fileName, Map<String, Object> parametros) {
		this.fileName = fileName;
		this.parametros = parametros;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Map<String, Object> getParametros() {
		return parametros;
	}

	public void setParametros(Map<String, Object> parametros) {
		this.parametros = parametros;
	}
}
