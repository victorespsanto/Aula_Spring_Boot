package com.algaworks.algafood.jpa;


import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Jacarta");	
		
		BigDecimal txFrete1 = new BigDecimal("12.0");		
		restaurante1.setTaxaFrete(txFrete1);
		
		
		
		//restaurante1.setTaxaFrete("12.00"); 
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Nissin");
		
		BigDecimal txFrete2 = new BigDecimal("15.0");		
		restaurante2.setTaxaFrete(txFrete2);
		
		restaurante1 = restauranteRepository.salvar(restaurante1);
		restaurante2 = restauranteRepository.salvar(restaurante2);
		
		System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());
	
	}

}
