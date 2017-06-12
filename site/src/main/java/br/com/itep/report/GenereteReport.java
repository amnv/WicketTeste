package br.com.itep.report;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.query.JRJdbcQueryExecuterFactory;

public class GenereteReport {

	public GenereteReport() {
	}

	public void writeReport(String jrxml, Connection connection, OutputStream saida) {

		try {
			Map<String, Object> parameters = new HashMap<>();

			//parameters.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, connection);
			
			// compila jrxml em memoria
			JasperReport jasper = JasperCompileManager.compileReport(jrxml);

			// preenche relatorio
			JasperPrint print = JasperFillManager.fillReport(jasper, parameters, connection);

			// exporta para pdf
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);
			exporter.exportReport();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao gerar relatório", e);
		}
	}
}