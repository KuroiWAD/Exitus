package br.edu.fatecourinhos.exitus.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecourinhos.exitus.domain.Egresso;
import br.edu.fatecourinhos.exitus.repository.EgressoRepository;

@Service
public class EgressoService {

	@Autowired
	private EgressoRepository repo;
	
	public Egresso find(Integer id) {
		Optional<Egresso> egresso = repo.findById(id);
		return egresso.orElseThrow(() -> new ObjectNotFoundException(
				"Egresso não encontrado! ID: " + id + ", Tipo: " , Egresso.class.getName()));
	}
	
}
