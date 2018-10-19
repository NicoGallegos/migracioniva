package com.iva.process;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iva.model.Ventas;
import com.iva.repository.VentasRepository;

@Service
public class Processor {

	
	@Autowired
	private VentasRepository ventasRepo;
	
	public void process() {
		generarVentas();
		
	}

	private List<Ventas> getVentasByMesano(Integer mesano){
		List<Ventas> ventas = new ArrayList<>();
		ventasRepo.findByMesano(mesano).forEach(x -> ventas.add(x));
		return ventas;
	}
	
	private void generarVentas() {
		List<Ventas> ventas = new ArrayList<>();
		ventas = this.getVentasByMesano(0116);
		Ventas v = ventas.get(0);
		System.out.println(v.getDomcom());
	}
	
}
