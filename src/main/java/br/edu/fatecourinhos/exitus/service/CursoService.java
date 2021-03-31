package br.edu.fatecourinhos.exitus.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecourinhos.exitus.domain.Curso;
import br.edu.fatecourinhos.exitus.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	// BUSCAR
	public Curso find(Integer id) {
		Optional<Curso> curso = repository.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException("Egresso não encontrado! ID: " + id + ", Tipo: ",
				Curso.class.getName()));
	}

	// INSERIR
	public Curso insert(Curso curso) {
		return repository.save(curso);
	}

	// ATUALIZAR
	public Curso update(Curso endereco) {
		Curso newEndereco = find(endereco.getId());
		updateData(newEndereco, endereco);
		return repository.save(newEndereco);
	}

	private void updateData(Curso newCurso, Curso curso) {
		newCurso.setNome(curso.getNome());

	}

}
