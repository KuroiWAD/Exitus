package br.edu.fatecourinhos.exitus.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
