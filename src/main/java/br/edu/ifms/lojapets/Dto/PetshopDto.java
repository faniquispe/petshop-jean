package br.edu.ifms.lojapets.Dto;

import java.io.Serializable;

import br.edu.ifms.lojapets.model.Petshop;

public class PetshopDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String cnpj;
	
	public PetshopDto() {
		// TODO Auto-generated constructor stub
	}

	public PetshopDto(Petshop obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
