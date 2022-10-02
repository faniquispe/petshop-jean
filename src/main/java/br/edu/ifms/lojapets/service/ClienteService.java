package br.edu.ifms.lojapets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.lojapets.Dto.ClienteDto;
import br.edu.ifms.lojapets.model.Cliente;
import br.edu.ifms.lojapets.repository.ClienteRepository;
import br.edu.ifms.lojapets.service.exception.DataIntegrityException;
import br.edu.ifms.lojapets.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));		
	}
	
	public Cliente insert (Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		buscarPorId(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}
	
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Cliente fromDto(ClienteDto objDto) {
		return new Cliente(objDto.getId(),objDto.getCpf(), objDto.getNome(), objDto.getPetshop());
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setCpf(obj.getCpf());
		newObj.setNome(obj.getNome());
		newObj.setPetshop(obj.getPetshop());
	}
}
