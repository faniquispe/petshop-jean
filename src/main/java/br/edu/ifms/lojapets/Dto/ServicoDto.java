package br.edu.ifms.lojapets.Dto;

import java.io.Serializable;

import br.edu.ifms.lojapets.model.Servico;

public class ServicoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private String dataServico;
	private float valor;

	
	public ServicoDto() {
		// TODO Auto-generated constructor stub
	}

	public ServicoDto(Servico obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.dataServico = obj.getDataServico();
		this.valor = obj.getValor();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataServico() {
		return dataServico;
	}

	public void setDataServico(String dataServico) {
		this.dataServico = dataServico;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	
	
}
