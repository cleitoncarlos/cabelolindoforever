package br.com.vendas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.vendas.enuns.Situacao;
import br.com.vendas.enuns.StatusProduto;
import br.com.vendas.enuns.Unidade;

@Entity
public class AjusteEstoque implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6489403420086917402L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	private TipoMovimentacao tipoMovimentacao;
	
	private Produto produto;
	
	private int quantidade;
	
	private BigDecimal valorCompra;
	
	private String observacao;
	
	
}
