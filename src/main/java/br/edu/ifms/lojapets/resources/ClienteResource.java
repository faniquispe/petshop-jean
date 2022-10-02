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

import br.edu.ifms.lojapets.Dto.ClienteDto;
import br.edu.ifms.lojapets.model.Cliente;
import br.edu.ifms.lojapets.service.ClienteService;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService cliente;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {		
		Cliente obj = cliente.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDto objDto) {
		Cliente obj = cliente.fromDto(objDto);
		obj = cliente.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDto objDto, @PathVariable Integer id) {
		Cliente obj = cliente.fromDto(objDto);
		obj.setId(id);
		obj = cliente.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Carro obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		cliente.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Cliente obj,@PathVariable Integer id){
		cliente.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDto>> findAll() {		
		List<Cliente> list = cliente.findAll();
		List<ClienteDto> listDto = list.stream().map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
