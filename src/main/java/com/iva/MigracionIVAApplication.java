package com.iva;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iva.process.Processor;


@SpringBootApplication
public class MigracionIVAApplication implements CommandLineRunner {


	private static Logger LOG = LoggerFactory.getLogger(MigracionIVAApplication.class);

	@Autowired
	private Processor processor;

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(MigracionIVAApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		String filePath = "C:\\Users\\nicol\\Desktop\\GENERADOS\\";
		Integer year = 1600;
		for (int i = 1; i <= 12; i++) {
			LOG.info("------ PROCESANDO MES " + Integer.toString(i) + " ------");
			processor.process(year+i,filePath);
		}
	}

}