package br.itep.report;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author helaine.lins
 */
public class RelatorioRPITeste {

	private static final Logger LOG = LogManager.getLogger(RelatorioRPITeste.class);

	@Test
	public void gerarRelatorioTeste() {
		try {

			List<Object> listaObjetos = new ArrayList<Object>();
			//preencher a lista de objetos

			JRDataSource dataSource = new JRBeanCollectionDataSource(listaObjetos);

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("parametro1", "");
			parametros.put("parametro2", "");

			InputStream fis = RelatorioRPITeste.class.getResourceAsStream("/jasper/arquivo.jasper");

			OutputStream pdfStream = new ByteArrayOutputStream();

			JasperRunManager.runReportToPdfStream(fis, pdfStream, parametros, dataSource);

			pdfStream.flush();
			pdfStream.close();

			pdfStream = null;

		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao gerar o relatorio.", e);
		}
	}
}
