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


import br.edu.ifms.lojapets.Dto.PetshopDto;
import br.edu.ifms.lojapets.model.Petshop;
import br.edu.ifms.lojapets.service.PetshopService;


@RestController
@RequestMapping(value = "/petshop")
public class PetshopResource {

	@Autowired
	private PetshopService petshop;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Petshop> find(@PathVariable Integer id) {		
		Petshop obj = petshop.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetshopDto objDto) {
		Petshop obj = petshop.fromDto(objDto);
		obj = petshop.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetshopDto objDto, @PathVariable Integer id) {
		Petshop obj = petshop.fromDto(objDto);
		obj.setId(id);
		obj = petshop.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Carro obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		petshop.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Petshop obj,@PathVariable Integer id){
		petshop.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetshopDto>> findAll() {		
		List<Petshop> list = petshop.findAll();
		List<PetshopDto> listDto = list.stream().map(obj -> new PetshopDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
