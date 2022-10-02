package br.edu.ifms.lojapets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import br.edu.ifms.lojapets.Dto.PetshopDto;
import br.edu.ifms.lojapets.model.Petshop;
import br.edu.ifms.lojapets.repository.PetshopRepository;
import br.edu.ifms.lojapets.service.exception.DataIntegrityException;
import br.edu.ifms.lojapets.service.exception.ObjectNotFoundException;

@Service
public class PetshopService {

	@Autowired
	private PetshopRepository repo;
	
	public Petshop buscarPorId(Integer id) {
		Optional<Petshop> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Petshop.class.getName()));		
	}
	
	public Petshop insert (Petshop obj) {
		obj.setId(null);
		return repo.save(obj);		
	}
	
	public Petshop update(Petshop obj) {
		Petshop newObj = buscarPorId(obj.getId());
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
	
	public List<Petshop> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Petshop fromDto(PetshopDto objDto) {
		return new Petshop(objDto.getId(), objDto.getNome(), objDto.getCnpj());
	}
	
	private void updateData(Petshop newObj, Petshop obj) {
		newObj.setNome(obj.getNome());
		newObj.setCnpj(obj.getCnpj());
	
	}
}
