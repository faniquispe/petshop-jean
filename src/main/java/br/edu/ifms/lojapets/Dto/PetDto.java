package br.edu.ifms.lojapets.Dto;

import java.io.Serializable;

import br.edu.ifms.lojapets.model.Cliente;
import br.edu.ifms.lojapets.model.Pet;

public class PetDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String raca;
	private String dataNascimento;
	private String tipo;
	private String sexo;
	private Cliente cliente;
	
	public PetDto() {
		// TODO Auto-generated constructor stub
	}

	public PetDto(Pet obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.raca = obj.getRaca();
		this.dataNascimento = obj.getDataNascimento();
		this.tipo = obj.getTipo();
		this.sexo = obj.getSexo();
		this.cliente = obj.getCliente();
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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
}
