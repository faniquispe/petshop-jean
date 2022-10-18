package br.edu.ifms.lojapets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import br.edu.ifms.lojapets.Dto.ServicoDto;
import br.edu.ifms.lojapets.model.Servico;
import br.edu.ifms.lojapets.repository.ServicoRepository;
import br.edu.ifms.lojapets.service.exception.DataIntegrityException;
import br.edu.ifms.lojapets.service.exception.ObjectNotFoundException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repo;
	
	public Servico buscarPorId(Integer id) {
		Optional<Servico> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));		
	}
	
	public Servico insert (Servico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Servico update(Servico obj) {
		Servico newObj = buscarPorId(obj.getId());
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
	
	public List<Servico> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Servico fromDto(ServicoDto objDto) {
		return new Servico(objDto.getId(),objDto.getDescricao(), objDto.getDataServico(), objDto.getValor(), null);
	}
	
	private void updateData(Servico newObj, Servico obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setDataServico(obj.getDataServico());
		newObj.setValor(obj.getValor());
		newObj.setPet(obj.getPet());
		
		
	}
}
