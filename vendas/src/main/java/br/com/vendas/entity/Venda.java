package br.com.vendas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.vendas.enuns.FormaPagamento;
import br.com.vendas.enuns.SituacaoVenda;
import br.com.vendas.enuns.StatusPagamento;
import br.com.vendas.enuns.Vendedor;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 6315015175860857433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@OneToOne
	private Cliente cliente;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;

	@Temporal(TemporalType.TIMESTAMP)
	private Date prazoEntrega;

	@Enumerated
	private Vendedor vendedor;

	@Enumerated
	private SituacaoVenda situacaoVenda;

	private String canalVenda;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ItensVenda> itens = new HashSet<>();

	private int quantidadeTotal;

	private BigDecimal descontoTotal;

	private BigDecimal valorTotal = new BigDecimal(0);

	@Enumerated
	private FormaPagamento formaPagamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrevisaoPagamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;

	private int quandidadeParcela;

	private StatusPagamento stausPagamento;
	
	private String observacao;

	
	public void adionaIntensVenda(Set<ItensVenda> itens2) {
		this.itens.addAll(itens2);
	}
	
	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", cliente=" + cliente + ", dataCadastro=" + dataCadastro + ", dataVenda="
				+ dataVenda + ", prazoEntrega=" + prazoEntrega + ", vendedor=" + vendedor + ", situacaoVenda="
				+ situacaoVenda + ", canalVenda=" + canalVenda + ", itens=" + itens + ", quantidadeTotal="
				+ quantidadeTotal + ", descontoTotal=" + descontoTotal + ", valorTotal=" + valorTotal
				+ ", formaPagamento=" + formaPagamento + ", dataPrevisaoPagamento=" + dataPrevisaoPagamento
				+ ", dataPagamento=" + dataPagamento + ", quandidadeParcela=" + quandidadeParcela + ", stausPagamento="
				+ stausPagamento + ", observacao=" + observacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canalVenda == null) ? 0 : canalVenda.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((dataPrevisaoPagamento == null) ? 0 : dataPrevisaoPagamento.hashCode());
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + ((descontoTotal == null) ? 0 : descontoTotal.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((prazoEntrega == null) ? 0 : prazoEntrega.hashCode());
		result = prime * result + quandidadeParcela;
		result = prime * result + quantidadeTotal;
		result = prime * result + ((situacaoVenda == null) ? 0 : situacaoVenda.hashCode());
		result = prime * result + ((stausPagamento == null) ? 0 : stausPagamento.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
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
		Venda other = (Venda) obj;
		if (canalVenda == null) {
			if (other.canalVenda != null)
				return false;
		} else if (!canalVenda.equals(other.canalVenda))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (dataPrevisaoPagamento == null) {
			if (other.dataPrevisaoPagamento != null)
				return false;
		} else if (!dataPrevisaoPagamento.equals(other.dataPrevisaoPagamento))
			return false;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (descontoTotal == null) {
			if (other.descontoTotal != null)
				return false;
		} else if (!descontoTotal.equals(other.descontoTotal))
			return false;
		if (formaPagamento != other.formaPagamento)
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (prazoEntrega == null) {
			if (other.prazoEntrega != null)
				return false;
		} else if (!prazoEntrega.equals(other.prazoEntrega))
			return false;
		if (quandidadeParcela != other.quandidadeParcela)
			return false;
		if (quantidadeTotal != other.quantidadeTotal)
			return false;
		if (situacaoVenda != other.situacaoVenda)
			return false;
		if (stausPagamento != other.stausPagamento)
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		if (vendedor != other.vendedor)
			return false;
		return true;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Date getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Date prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public SituacaoVenda getSituacaoVenda() {
		return situacaoVenda;
	}

	public void setSituacaoVenda(SituacaoVenda situacaoVenda) {
		this.situacaoVenda = situacaoVenda;
	}

	public String getCanalVenda() {
		return canalVenda;
	}

	public void setCanalVenda(String canalVenda) {
		this.canalVenda = canalVenda;
	}

	public Set<ItensVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItensVenda> itens) {
		this.itens = itens;
	}

	public int getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(int quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public BigDecimal getDescontoTotal() {
		return descontoTotal;
	}

	public void setDescontoTotal(BigDecimal descontoTotal) {
		this.descontoTotal = descontoTotal;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataPrevisaoPagamento() {
		return dataPrevisaoPagamento;
	}

	public void setDataPrevisaoPagamento(Date dataPrevisaoPagamento) {
		this.dataPrevisaoPagamento = dataPrevisaoPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public int getQuandidadeParcela() {
		return quandidadeParcela;
	}

	public void setQuandidadeParcela(int quandidadeParcela) {
		this.quandidadeParcela = quandidadeParcela;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public StatusPagamento getStausPagamento() {
		return stausPagamento;
	}

	public void setStausPagamento(StatusPagamento stausPagamento) {
		this.stausPagamento = stausPagamento;
	}

}
