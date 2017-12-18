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
import br.com.vendas.enuns.StatusPagamento;
import br.com.vendas.enuns.StatusProduto;
import br.com.vendas.enuns.Unidade;

@Entity
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6489403420086917402L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String codigoInterno;
	private String nomeProduto;
	
	@OneToOne
	private Grupo grupo;
	
	@Enumerated
	private Unidade unidade;
	
	private double peso;
	private double largura;
	private double altura;
	private double comprimento;
	
	@OneToOne
	private Fornecedor fornecedor;
	
	private int estoqueInicial;
	private int estoqueAtual;
	private int estoqueMinimo;
	private int estoqueMaximo;
	
	private BigDecimal valorCompraInicial;
	private BigDecimal valorCompraAtual;
	private BigDecimal valorVenda;
	private BigDecimal porcVenda;
	private BigDecimal lucroEmReais;
	
	@Enumerated
	private StatusProduto statusProduto;
	
	@Enumerated
	private Situacao sistuacaoProduto;
	
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAlteraca;
	
	private StatusPagamento stausPagamento;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCodigoInterno() {
		return codigoInterno;
	}
	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public BigDecimal getValorCompraInicial() {
		return valorCompraInicial;
	}
	public void setValorCompraInicial(BigDecimal valorCompraInicial) {
		this.valorCompraInicial = valorCompraInicial;
	}
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	public BigDecimal getPorcVenda() {
		return porcVenda;
	}
	public void setPorcVenda(BigDecimal porcVenda) {
		this.porcVenda = porcVenda;
	}
	public BigDecimal getLucroEmReais() {
		return lucroEmReais;
	}
	public void setLucroEmReais(BigDecimal lucroEmReais) {
		this.lucroEmReais = lucroEmReais;
	}
	public StatusProduto getStatusProduto() {
		return statusProduto;
	}
	public void setStatusProduto(StatusProduto statusProduto) {
		this.statusProduto = statusProduto;
	}
	public Situacao getSistuacaoProduto() {
		return sistuacaoProduto;
	}
	public void setSistuacaoProduto(Situacao sistuacaoProduto) {
		this.sistuacaoProduto = sistuacaoProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Calendar getDataAlteraca() {
		return dataAlteraca;
	}
	public void setDataAlteraca(Calendar dataAlteraca) {
		this.dataAlteraca = dataAlteraca;
	}
	
	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}
	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}
	public int getEstoqueAtual() {
		return estoqueAtual;
	}
	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", codigoInterno=" + codigoInterno + ", nomeProduto=" + nomeProduto
				+ ", grupo=" + grupo + ", unidade=" + unidade + ", peso=" + peso + ", largura=" + largura + ", altura="
				+ altura + ", comprimento=" + comprimento + ", fornecedor=" + fornecedor + ", estoqueInicial="
				+ estoqueInicial + ", estoqueAtual=" + estoqueAtual + ", estoqueMinimo=" + estoqueMinimo
				+ ", estoqueMaximo=" + estoqueMaximo + ", valorCompraInicial=" + valorCompraInicial
				+ ", valorCompraAtual=" + valorCompraAtual + ", valorVenda=" + valorVenda + ", porcVenda=" + porcVenda
				+ ", lucroEmReais=" + lucroEmReais + ", statusProduto=" + statusProduto + ", sistuacaoProduto="
				+ sistuacaoProduto + ", descricao=" + descricao + ", dataCadastro=" + dataCadastro + ", dataAlteraca="
				+ dataAlteraca + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(altura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((codigoInterno == null) ? 0 : codigoInterno.hashCode());
		temp = Double.doubleToLongBits(comprimento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dataAlteraca == null) ? 0 : dataAlteraca.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + estoqueAtual;
		result = prime * result + estoqueInicial;
		result = prime * result + estoqueMaximo;
		result = prime * result + estoqueMinimo;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		temp = Double.doubleToLongBits(largura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lucroEmReais == null) ? 0 : lucroEmReais.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((porcVenda == null) ? 0 : porcVenda.hashCode());
		result = prime * result + ((sistuacaoProduto == null) ? 0 : sistuacaoProduto.hashCode());
		result = prime * result + ((statusProduto == null) ? 0 : statusProduto.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		result = prime * result + ((valorCompraAtual == null) ? 0 : valorCompraAtual.hashCode());
		result = prime * result + ((valorCompraInicial == null) ? 0 : valorCompraInicial.hashCode());
		result = prime * result + ((valorVenda == null) ? 0 : valorVenda.hashCode());
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
		Produto other = (Produto) obj;
		if (Double.doubleToLongBits(altura) != Double.doubleToLongBits(other.altura))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoInterno == null) {
			if (other.codigoInterno != null)
				return false;
		} else if (!codigoInterno.equals(other.codigoInterno))
			return false;
		if (Double.doubleToLongBits(comprimento) != Double.doubleToLongBits(other.comprimento))
			return false;
		if (dataAlteraca == null) {
			if (other.dataAlteraca != null)
				return false;
		} else if (!dataAlteraca.equals(other.dataAlteraca))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estoqueAtual != other.estoqueAtual)
			return false;
		if (estoqueInicial != other.estoqueInicial)
			return false;
		if (estoqueMaximo != other.estoqueMaximo)
			return false;
		if (estoqueMinimo != other.estoqueMinimo)
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (Double.doubleToLongBits(largura) != Double.doubleToLongBits(other.largura))
			return false;
		if (lucroEmReais == null) {
			if (other.lucroEmReais != null)
				return false;
		} else if (!lucroEmReais.equals(other.lucroEmReais))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (porcVenda == null) {
			if (other.porcVenda != null)
				return false;
		} else if (!porcVenda.equals(other.porcVenda))
			return false;
		if (sistuacaoProduto != other.sistuacaoProduto)
			return false;
		if (statusProduto != other.statusProduto)
			return false;
		if (unidade != other.unidade)
			return false;
		if (valorCompraAtual == null) {
			if (other.valorCompraAtual != null)
				return false;
		} else if (!valorCompraAtual.equals(other.valorCompraAtual))
			return false;
		if (valorCompraInicial == null) {
			if (other.valorCompraInicial != null)
				return false;
		} else if (!valorCompraInicial.equals(other.valorCompraInicial))
			return false;
		if (valorVenda == null) {
			if (other.valorVenda != null)
				return false;
		} else if (!valorVenda.equals(other.valorVenda))
			return false;
		return true;
	}
	public int getEstoqueInicial() {
		return estoqueInicial;
	}
	public void setEstoqueInicial(int estoqueInicial) {
		this.estoqueInicial = estoqueInicial;
	}
	public BigDecimal getValorCompraAtual() {
		return valorCompraAtual;
	}
	public void setValorCompraAtual(BigDecimal valorCompraAtual) {
		this.valorCompraAtual = valorCompraAtual;
	}
	public StatusPagamento getStausPagamento() {
		return stausPagamento;
	}
	public void setStausPagamento(StatusPagamento stausPagamento) {
		this.stausPagamento = stausPagamento;
	}
	
	
	
	
/*	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	//@SKU
	@NotBlank(message = "SKU é obrigatório")
	private String sku;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotBlank(message = "A descrição é obrigatória")
	@Size(max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
	private String descricao;

	@NotNull(message = "Valor é obrigatório")
	@DecimalMin(value = "0.50", message = "O valor da cerveja deve ser maior que R$0,50")
	@DecimalMax(value = "9999999.99", message = "O valor da cerveja deve ser menor que R$9.999.999,99")
	private BigDecimal valor;

	@NotNull(message = "A comissão é obrigatória")
	@DecimalMax(value = "100.0", message = "A comissão deve ser igual ou menor que 100")
	private BigDecimal comissao;

	@NotNull(message = "A quantidade em estoque é obrigatória")
	@Max(value = 9999, message = "A quantidade em estoque deve ser menor que 9.999")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;

	private String foto;

	@Column(name = "content_type")
	private String contentType;*/
}
