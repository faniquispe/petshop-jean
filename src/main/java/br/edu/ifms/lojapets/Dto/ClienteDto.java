package br.edu.ifms.lojapets.Dto;

import java.io.Serializable;

import br.edu.ifms.lojapets.model.Cliente;
import br.edu.ifms.lojapets.model.Petshop;

public class ClienteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String cpf;
	private String nome;
	private Petshop petshop;
	
	public ClienteDto() {
		// TODO Auto-generated constructor stub
	}

	public ClienteDto(Cliente obj) {
		super();
		this.id = obj.getId();
		this.cpf = obj.getCpf();
		this.nome = obj.getNome();
		this.petshop = obj.getPetshop();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Petshop getPetshop() {
		return petshop;
	}

	public void setPetshop(Petshop petshop) {
		this.petshop = petshop;
	}	
	
}
