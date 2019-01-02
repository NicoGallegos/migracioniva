package com.iva.process;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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
		List<Ventas> ventas = this.getVentasByMesano(anomes);
		
		List<Ventas> ventasSinAnuladas = ventas.stream().filter(v -> !v.getRazsoc().toUpperCase().contains("ANULADA")).collect(Collectors.toList());
		
		this.generarReporteVentas(ventasSinAnuladas, filePath +"REPORTES\\"+ anomes.toString());
		this.generarArchivosSIAP(ventasSinAnuladas,filePath +"IMPORTACION\\"+ anomes.toString());
	}

	private List<Ventas> getVentasByMesano(Integer mesano){
		LOG.info("---OBTENIENDO DATOS VENTAS---");
		List<Ventas> ventas = new ArrayList<>();
		ventasRepo.findByMesano(mesano).forEach(x -> ventas.add(x));
		return ventas;
	}

	private void generarReporteVentas(List<Ventas> ventas, String filename) {
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

		LOG.info("---GUARDANDO ARCHIVO EN DISCO---");
			try {
				FileUtils.writeStringToFile(new File( filename + ".csv"), file.toString(),"UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		LOG.info("---FIN PROCESO REPORTE CSV---");
	}

	private void generarArchivosSIAP(List<Ventas> ventas, String filename) {
		LOG.info("---GENERO ARCHIVOS PARA MIGRACION SIAP VENTAS---");

		StringBuilder file = new StringBuilder();

		int i = 0;
		for (Ventas venta : ventas) {
			file.append(StringUtils.leftPad(venta.getFechaArchivo(),8,"0"));//fecha
			file.append(StringUtils.leftPad(venta.getTipoComprobante(),3,"0"));//tipo comprobante
			file.append(StringUtils.leftPad(venta.getNroloc().toString(),5,"0"));//punto de venta
			file.append(StringUtils.leftPad(venta.getNrocom().toString(),20,"0"));//nro comprobante
			file.append(StringUtils.leftPad(venta.getNrocom().toString(),20,"0"));//nrocomprobantehasta
			file.append(StringUtils.leftPad(venta.getTipoComprador(),2,"0"));//cod de comprobante comprador

			file.append(StringUtils.leftPad(venta.getNrcuit().replace("-", ""),20,"0"));//cuit
			file.append(StringUtils.leftPad(venta.getRazsoc(),30,""));//apellido y nombre	
			file.append(StringUtils.leftPad(this.getParteEnteraImporte(venta.getImptot()),13,"0") + StringUtils.leftPad(this.getParteDecimalImporte(venta.getImptot()),2,"0"));//importe total
			file.append(StringUtils.leftPad("0",15,"0"));//importe conceptos no precio neto gravado
			file.append(StringUtils.leftPad("0",15,"0"));//percepcion a no categorizados
			file.append(StringUtils.leftPad("0",15,"0"));//operaciones exentas
			file.append(StringUtils.leftPad("0",15,"0"));//importe percepciones o pagos a cuenta imp nacionales
			file.append(StringUtils.leftPad("0",15,"0"));//importe ing brutos
			file.append(StringUtils.leftPad("0",15,"0"));//importe imp municipales
			file.append(StringUtils.leftPad("0",15,"0"));//importe imp internos
			file.append(StringUtils.leftPad("PES",3,""));//cod moneda
			file.append(StringUtils.leftPad("1",4,"0") + StringUtils.leftPad("",6,"0"));//tipo cambio , 4 enteros, 6 decimales

			if (venta.getTipcom().toLowerCase().equals("z")) //cant alicuotas	
				file.append(StringUtils.leftPad("2",1,"0"));	
			else
				file.append(StringUtils.leftPad("1",1,"0"));

			file.append(StringUtils.leftPad("0",1,"")); //cod operacion
			file.append(StringUtils.leftPad("1",15,"0")); //otros tributos
			if (venta.getTipoComprobante() == "082")
				file.append(StringUtils.leftPad("0",8,"0"));
			else
				file.append(StringUtils.leftPad(venta.getFechaArchivo(),8,"0"));//fecha vto pago
			
			file.append("\r");
		}

		try {
			LOG.info("---GUARDANDO ARCHIVOS EN DISCO---");
			FileUtils.writeStringToFile(new File( filename + ".txt"), file.toString(),"Cp1252");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		LOG.info("---FIN PROCESO ARCHIVOS TXT---");
	}


	
	private String getParteEnteraImporte(Float importe) {
		return Long.toString(importe.longValue());
	}
	
	private String getParteDecimalImporte(Float importe) {
		Float decimales = importe - importe.longValue();
		String decimalString = decimales.toString().substring(decimales.toString().indexOf(".")+1);
		if(decimalString.length() > 2) {
			return decimalString.substring(0,2);
		}
		return decimalString;
	}

}
