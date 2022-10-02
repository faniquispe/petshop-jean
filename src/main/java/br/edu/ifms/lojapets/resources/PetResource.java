package br.edu.ifms.lojapets.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.edu.ifms.lojapets.Dto.PetDto;
import br.edu.ifms.lojapets.model.Pet;
import br.edu.ifms.lojapets.service.PetService;

@RestController
@RequestMapping(value = "/pet")
public class PetResource {

	@Autowired
	private PetService pet;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pet> find(@PathVariable Integer id) {		
		Pet obj = pet.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetDto objDto) {
		Pet obj = pet.fromDto(objDto);
		obj = pet.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetDto objDto, @PathVariable Integer id) {
		Pet obj = pet.fromDto(objDto);
		obj.setId(id);
		obj = pet.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Carro obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		pet.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Pet obj,@PathVariable Integer id){
		pet.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetDto>> findAll() {		
		List<Pet> list = pet.findAll();
		List<PetDto> listDto = list.stream().map(obj -> new PetDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
