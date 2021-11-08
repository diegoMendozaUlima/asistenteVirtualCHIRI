package com.example.demo;

import java.sql.Connection;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Quote;
import com.example.demo.Value;

import baseDatosConexion.ConexionBD;



@SpringBootApplication
public class AsistenteVirtualChiriApplication {

	//private static final Logger log = LoggerFactory.getLogger(AsistenteVirtualChiriApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AsistenteVirtualChiriApplication.class, args);
	}
	
	/*
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote;
			 quote = restTemplate.getForObject(
					"https://quoters.apps.pcfone.io/api/random", Quote.class);
			log.info(quote.toString());
			ConexionBD conectar = new ConexionBD();
		    Connection conectarDeveloper = conectar.conexionSQLDeveloper();
		    Value valores = quote.getValue();
		    String consulta = "INSERT INTO QUOTE (ID, QUOTE) values (" + valores.getId() + ",'" +  valores.getQuote() + "')";
		    System.out.println(consulta);
		    Statement statement = conectarDeveloper.prepareStatement(consulta);
		    statement.executeUpdate(consulta);
		    statement.close();
		    conectarDeveloper.close();
			
		};


}*/
}
