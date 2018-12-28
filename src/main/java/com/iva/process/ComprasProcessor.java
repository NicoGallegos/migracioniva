package com.iva.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iva.model.Compras;
import com.iva.repository.ComprasRepository;

@Service
public class ComprasProcessor {

	private static Logger LOG = LoggerFactory.getLogger(ComprasProcessor.class);

	@Autowired
	private ComprasRepository comprasRepo;

	public void process(Integer anomes, String filePath) {

		String txt = generarReporte(this.getComprasByMesano(anomes));
		saveReportToFile(txt,filePath + anomes.toString());
	}

	private List<Compras> getComprasByMesano(Integer mesano){
		LOG.info("---OBTENIENDO DATOS COMPRAS---");
		List<Compras> compras = new ArrayList<>();
		comprasRepo.findByMesano(mesano).forEach(x -> compras.add(x));
		return compras;
	}

	private String generarReporte(List<Compras> compras) {
		LOG.info("---GENERO REPORTE COMPRAS---");
		//TODO terminarlo.
		StringBuilder file = new StringBuilder("FECHA;COMPROBANTE;RAZON SOCIAL;TIPO IVA;CUIT;GRAVADOS;EXENTO;GRAVADOS;IVA;INTERNOS;TOTAL;\n");

		Float totalGravados = 0f;
		Float totalExentos = 0f;
		Float totalIVA = 0f;
		Float totalInternos = 0f;
		Float totalPercepciones = 0f;
		Float totalTotal = 0f;
/*
		for (Compras compra : compras) {
			
			 * 
			 * file.append(compra.getFecha() + ";");
			file.append(compra.getComprobante() + ";");
			file.append(compra.getRazsoc() + ";");
			file.append(compra.getTipiva() + ";");
			file.append(compra.getNrcuit() + ";");
			file.append(compra.getTotalImpGravados() + ";");
			file.append(compra.getImpexe() + ";");
			file.append(compra.getTotalImpIVA() + ";");
			file.append(compra.getImpiin() + ";");
			file.append(compra.getImpper() + ";");
			file.append(compra.getImptot() + ";");
			file.append("\n");

			totalGravados += (compra.getTotalImpGravados());
			totalExentos  += (compra.getImpexe());
			totalIVA  += (compra.getTotalImpIVA());
			totalInternos += (compra.getImpiin());
			totalPercepciones += (compra.getImpper());
			totalTotal += (compra.getImptot());
			 *
			 
		}
*/
		file.append(";");
		file.append(";");
		file.append(";");
		file.append(";");
		file.append(";");
		file.append(totalGravados.toString() + ";");
		file.append(totalExentos.toString() + ";");
		file.append(totalIVA.toString() + ";");
		file.append(totalInternos.toString() + ";");
		file.append(totalPercepciones + ";");
		file.append(totalTotal.toString() + ";");

		return file.toString();

	}

	private void saveReportToFile(String txt, String filename) {
		LOG.info("---GENERO ARCHIVO SALIDA COMPRAS---");
		try {
			FileUtils.writeStringToFile(new File( filename + ".csv"), txt,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
