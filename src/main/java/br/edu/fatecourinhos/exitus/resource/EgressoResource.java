package br.edu.fatecourinhos.exitus.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.fatecourinhos.exitus.domain.Egresso;
import br.edu.fatecourinhos.exitus.service.EgressoService;

@RestController
@RequestMapping("/egresso")
public class EgressoResource {
	
	@Autowired
	private EgressoService service;

	@GetMapping("/{id}")
	public Egresso find(@PathVariable Integer id) {
		Egresso egresso = service.find(id);
		return egresso;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Egresso> insert(@Valid @RequestBody Egresso egresso) {
		
		egresso = service.insert(egresso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(egresso.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Egresso> update (@PathVariable Integer id, @RequestBody Egresso egresso){
		Egresso egressoAtualizado = service.find(id);
		
		BeanUtils.copyProperties(egresso, egressoAtualizado, "id");
		service.update(egressoAtualizado);
		
		return ResponseEntity.ok(egressoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Egresso> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
