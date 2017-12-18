package br.com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.morenalinks.msg.util.MenssagemUtil;
import br.com.vendas.entity.Cliente;
import br.com.vendas.enuns.Situacao;
import br.com.vendas.enuns.Tipo;
import br.com.vendas.service.ClienteService;

@Named
@SessionScoped
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1793995911926386510L;

	@Inject
	private ClienteService clienteService;
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Tipo> tiposClinte;
	private List<Situacao> situacaoCliente;

	@PostConstruct
	private void init() {

		System.out.println("Init....");
		this.cliente = new Cliente();

		clientes = new ArrayList<Cliente>();
		clientes = clienteService.listarTudo();
		// this.setProdutos(new ArrayList<Produto>());

		tiposClinte = new ArrayList<Tipo>();
		tiposClinte = clienteService.criaListaTipoCliente();
		
		setSituacaoCliente(new ArrayList<Situacao>());
		setSituacaoCliente(clienteService.criaListaSituacaoCliente());
	}

	public void salvar() {

		try {
			System.out.println("Salvar Cliente....");

			cliente.setDataCadastro(Calendar.getInstance());
			clienteService.salvar(cliente);
			MenssagemUtil.mensagemInfo("Cliente Cadastrado!!");
			limpaForm();
		} catch (Exception e) {
			MenssagemUtil.mensagemErro("Erro ao Salvar Cliente!");
			e.printStackTrace();
		}
	}


	public void limpaForm() {

		this.cliente = new Cliente();
	}

	/* =============GETES e SETES============== */

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Tipo> getTiposClinte() {
		return tiposClinte;
	}

	public void setTiposClinte(List<Tipo> tiposClinte) {
		this.tiposClinte = tiposClinte;
	}

	public List<Situacao> getSituacaoCliente() {
		return situacaoCliente;
	}

	public void setSituacaoCliente(List<Situacao> situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}
}
