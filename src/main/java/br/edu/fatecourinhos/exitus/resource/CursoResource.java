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

import br.edu.fatecourinhos.exitus.domain.Curso;
import br.edu.fatecourinhos.exitus.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoResource {
	
	@Autowired
	private CursoService service;

	@GetMapping("/{id}")
	public Curso find(@PathVariable Integer id) {
		Curso curso = service.find(id);
		return curso;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Curso insert(@Valid @RequestBody Curso curso) {
		return service.insert(curso);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> update (@PathVariable Integer id, @RequestBody Curso curso){
		Curso cursoAtualizado = service.find(id);
		
		BeanUtils.copyProperties(curso, cursoAtualizado, "id");
		service.update(cursoAtualizado);
		
		return ResponseEntity.ok(cursoAtualizado);
	}
	
}
