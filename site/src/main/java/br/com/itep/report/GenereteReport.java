package br.com.itep.report;
/**
 * @author allyson.manoel
 */
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import br.com.itep.entity.Person;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

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
	
	public void writeMutipageReport(List<String> filesName, Connection connection, OutputStream saida) throws JRException
	{
		List jpList = new ArrayList();
		for (String file : filesName)
		{
			Map<String, Object> parameters = new HashMap<>();
			
			// compila jrxml em memoria
			JasperReport jasper = JasperCompileManager.compileReport(file);

			// preenche relatorio
			JasperPrint print = JasperFillManager.fillReport(jasper, parameters, connection);

			jpList.add(print);
		}
		
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, jpList); 
		exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, saida); 
		exporter.exportReport();
	}
	
	public void geraRelatorio(DadosRelatorio dadosRelatorio) {
		try 
		{
			List<JasperPrint> jpList = new ArrayList<JasperPrint>();
			for (DadosJrxml file : dadosRelatorio.getDados())
			{
				// compila jrxml em memoria
				JasperReport jasper = JasperCompileManager.compileReport(file.getFileName());
	
				// preenche relatorio
				JasperPrint print = JasperFillManager.fillReport (jasper, file.getParametros());
	
				jpList.add(print);
			}
			
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, jpList); 
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, dadosRelatorio.getArquivoSaida()); 
			exporter.exportReport();
		}
		catch (JRException e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * Gerar relatotio sem conexao com banco de dados
	 * @param dadosRelatorio
	 * @param people
	 */
	public void geraRelatorio(DadosRelatorio dadosRelatorio, Vector<Person> people) {
		try {
            JRBeanCollectionDataSource jRBeanArrayDataSource = new JRBeanCollectionDataSource(PersonFactory.generateColection(people));
            
            //InputStream input = new FileInputStream(template);
            JasperDesign design = JRXmlLoader.load(dadosRelatorio.getDados().get(0).getFileName());
            JasperReport report = JasperCompileManager.compileReport(design);

            JasperPrint print = JasperFillManager.fillReport(report, dadosRelatorio.getDados().get(0).getParametros(),
            		jRBeanArrayDataSource);
            
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, dadosRelatorio.getArquivoSaida());
			exporter.exportReport();
			
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}