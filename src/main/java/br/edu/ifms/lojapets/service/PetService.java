package br.edu.ifms.lojapets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import br.edu.ifms.lojapets.Dto.PetDto;
import br.edu.ifms.lojapets.model.Pet;
import br.edu.ifms.lojapets.repository.PetRepository;
import br.edu.ifms.lojapets.service.exception.DataIntegrityException;
import br.edu.ifms.lojapets.service.exception.ObjectNotFoundException;

@Service
public class PetService {
	
	@Autowired
	private PetRepository repo;

	public Pet buscarPorId(Integer id) {
		Optional<Pet> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pet.class.getName()));		
	}
	
	public Pet insert (Pet obj) {
		obj.setId(null);
		return repo.save(obj);		
	}
	
	public Pet update(Pet obj) {
		Pet newObj = buscarPorId(obj.getId());
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
	
	public List<Pet> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Pet fromDto(PetDto objDto) {
		return new Pet(objDto.getId(),objDto.getNome(), objDto.getRaca(), objDto.getDataNascimento(), 
				objDto.getTipo(), objDto.getSexo(), objDto.getCliente());
	}
	
	private void updateData(Pet newObj, Pet obj) {
		newObj.setNome(obj.getNome());
		newObj.setRaca(obj.getRaca());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setTipo(obj.getTipo());
		newObj.setSexo(obj.getSexo());
		newObj.setCliente(obj.getCliente());
	}
}
