package com.iva.process;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iva.model.Ventas;
import com.iva.repository.VentasRepository;

@Service
public class VentasProcessor {

	private static Logger LOG = LoggerFactory.getLogger(VentasProcessor.class);
	
	@Autowired
	private VentasRepository ventasRepo;
	
	public void process(Integer anomes, String filePath) {
		
		String txt = generarReporteVentas(this.getVentasByMesano(anomes));
		saveReportToFile(txt,filePath + anomes.toString());
	}

	private List<Ventas> getVentasByMesano(Integer mesano){
		LOG.info("---OBTENIENDO DATOS VENTAS---");
		List<Ventas> ventas = new ArrayList<>();
		ventasRepo.findByMesano(mesano).forEach(x -> ventas.add(x));
		return ventas;
	}

	private String generarReporteVentas(List<Ventas> ventas) {
		LOG.info("-- GENERO REPORTE VENTAS---");
		StringBuilder file = new StringBuilder("FECHA;COMPROBANTE;RAZON SOCIAL;TIPO IVA;CUIT;GRAVADOS;EXENTO;GRAVADOS;IVA;INTERNOS;TOTAL;\n");

		Float totalGravados = 0f;
		Float totalExentos = 0f;
		Float totalIVA = 0f;
		Float totalInternos = 0f;
		Float totalPercepciones = 0f;
		Float totalTotal = 0f;

		for (Ventas venta : ventas) {
			file.append(venta.getFecha() + ";");
			file.append(venta.getComprobante() + ";");
			file.append(venta.getRazsoc() + ";");
			file.append(venta.getTipiva() + ";");
			file.append(venta.getNrcuit() + ";");
			file.append(venta.getTotalImpGravados() + ";");
			file.append(venta.getImpexe() + ";");
			file.append(venta.getTotalImpIVA() + ";");
			file.append(venta.getImpiin() + ";");
			file.append(venta.getImpper() + ";");
			file.append(venta.getImptot() + ";");
			file.append("\n");

			totalGravados += (venta.getTotalImpGravados());
			totalExentos  += (venta.getImpexe());
			totalIVA  += (venta.getTotalImpIVA());
			totalInternos += (venta.getImpiin());
			totalPercepciones += (venta.getImpper());
			totalTotal += (venta.getImptot());
		}
		
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
		LOG.info("---GENERO ARCHIVO SALIDA VENTAS---");
		try {
			FileUtils.writeStringToFile(new File( filename + ".csv"), txt,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
