package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name ="taxa_frete", nullable = false) // nullable = false informa que a coluna não pode receber valores nulos
	private BigDecimal taxaFrete;
	
	@ManyToOne
	@JoinColumn(name = "cozinha_id", nullable = false) //pode ficar implicito quando se deseja nomear a coluna com "nomeVariavel_id"
	private Cozinha cozinha;


}
