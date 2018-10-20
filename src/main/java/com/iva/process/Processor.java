package com.iva.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Processor {


	@Autowired
	private ComprasProcessor comprasProcessor;

	@Autowired
	private VentasProcessor ventasProcessor;

	public void process(Integer anomes, String filePath) {
		//comprasProcessor.process(anomes, filePath+"\\COMPRAS\\");
		ventasProcessor.process(anomes, filePath+"\\VENTAS\\");
	}
}
