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


import br.edu.ifms.lojapets.Dto.ServicoDto;
import br.edu.ifms.lojapets.model.Servico;
import br.edu.ifms.lojapets.service.ServicoService;

@RestController
@RequestMapping(value = "/servico")
public class ServicoResource {

	@Autowired
	private ServicoService servico;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servico> find(@PathVariable Integer id) {		
		Servico obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ServicoDto objDto) {
		Servico obj = servico.fromDto(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ServicoDto objDto, @PathVariable Integer id) {
		Servico obj = servico.fromDto(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Carro obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Servico obj,@PathVariable Integer id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ServicoDto>> findAll() {		
		List<Servico> list = servico.findAll();
		List<ServicoDto> listDto = list.stream().map(obj -> new ServicoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
