package br.edu.fatecourinhos.exitus.resource;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecourinhos.exitus.domain.Endereco;
import br.edu.fatecourinhos.exitus.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;

	@GetMapping("/{id}")
	public Endereco find(@PathVariable Integer id) {
		Endereco endereco = service.find(id);
		return endereco;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco insert(@Valid @RequestBody Endereco endereco) {
		return service.insert(endereco);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> update (@PathVariable Integer id, @RequestBody Endereco endereco){
		Endereco enderecoAtualizado = service.find(id);
		
		BeanUtils.copyProperties(endereco, enderecoAtualizado, "id");
		service.update(enderecoAtualizado);
		
		return ResponseEntity.ok(enderecoAtualizado);
	}
	
}
