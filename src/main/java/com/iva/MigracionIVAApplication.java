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
        LOG.info("EXECUTING : command line runner");
        processor.process();
    }
    
}