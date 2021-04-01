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

import br.edu.fatecourinhos.exitus.domain.Administrador;
import br.edu.fatecourinhos.exitus.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorResource {
	
	@Autowired
	private AdministradorService service;

	@GetMapping("/{id}")
	public Administrador find(@PathVariable Integer id) {
		Administrador administrador = service.find(id);
		return administrador;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Administrador insert(@Valid @RequestBody Administrador administrador) {
		return service.insert(administrador);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Administrador> update (@PathVariable Integer id, @RequestBody Administrador administrador){
		Administrador administradorAtualizado = service.find(id);
		
		BeanUtils.copyProperties(administrador, administradorAtualizado, "id");
		service.update(administradorAtualizado);
		
		return ResponseEntity.ok(administradorAtualizado);
	}
	
}
