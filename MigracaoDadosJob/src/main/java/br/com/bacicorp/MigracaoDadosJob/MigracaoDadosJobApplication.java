package br.com.bacicorp.MigracaoDadosJob;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class MigracaoDadosJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(MigracaoDadosJobApplication.class, args);
	}

}


// TODO - Tentar usar a mesma versão do Spring Batch do trampo
