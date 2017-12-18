package br.com.vendas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.vendas.enuns.Classificacao;

@Entity
public class CurvaABC implements Serializable {

	private static final long serialVersionUID = 6315015175860857433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@OneToOne
	private Produto produto;
	
	private int quantidadeVendida;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	
	private BigDecimal valorTotalPorProduto = new BigDecimal(0);

	private BigDecimal porcentagem = new BigDecimal(0);

	private BigDecimal porcAcumulada = new BigDecimal(0);

	private Classificacao classificacao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public BigDecimal getValorTotalPorProduto() {
		return valorTotalPorProduto;
	}

	public void setValorTotalPorProduto(BigDecimal valorTotalPorProduto) {
		this.valorTotalPorProduto = valorTotalPorProduto;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}

	public BigDecimal getPorcAcumulada() {
		return porcAcumulada;
	}

	public void setPorcAcumulada(BigDecimal porcAcumulada) {
		this.porcAcumulada = porcAcumulada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CurvaABC [codigo=" + codigo + ", produto=" + produto + ", quantidadeVendida=" + quantidadeVendida
				+ ", valorTotalPorProduto=" + valorTotalPorProduto + ", porcentagem=" + porcentagem + ", porcAcumulada="
				+ porcAcumulada + ", classificacao=" + classificacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((porcAcumulada == null) ? 0 : porcAcumulada.hashCode());
		result = prime * result + ((porcentagem == null) ? 0 : porcentagem.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantidadeVendida;
		result = prime * result + ((valorTotalPorProduto == null) ? 0 : valorTotalPorProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurvaABC other = (CurvaABC) obj;
		if (classificacao != other.classificacao)
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (porcAcumulada == null) {
			if (other.porcAcumulada != null)
				return false;
		} else if (!porcAcumulada.equals(other.porcAcumulada))
			return false;
		if (porcentagem == null) {
			if (other.porcentagem != null)
				return false;
		} else if (!porcentagem.equals(other.porcentagem))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidadeVendida != other.quantidadeVendida)
			return false;
		if (valorTotalPorProduto == null) {
			if (other.valorTotalPorProduto != null)
				return false;
		} else if (!valorTotalPorProduto.equals(other.valorTotalPorProduto))
			return false;
		return true;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
