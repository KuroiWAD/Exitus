package br.edu.fatecourinhos.exitus.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecourinhos.exitus.domain.Egresso;
import br.edu.fatecourinhos.exitus.domain.EgressoCurso;
import br.edu.fatecourinhos.exitus.repository.EgressoRepository;

@Service
public class EgressoService {

	@Autowired
	private EgressoRepository repository;

	// BUSCAR
	public Egresso find(Integer id) {
		Optional<Egresso> egresso = repository.findById(id);
		return egresso.orElseThrow(() -> new ObjectNotFoundException("Egresso não encontrado! ID: " + id + ", Tipo: ",
				Egresso.class.getName()));
	}

	// INSERIR
	@Transactional
	public Egresso insert(Egresso egresso) {
		egresso.setId(null);

		egresso = repository.save(egresso);

		for (EgressoCurso ec : egresso.getCursos()) {
			ec.setEgresso(egresso);
		}
		Egresso egressoSalvo = repository.save(egresso);
		return egressoSalvo;
	}

	// ATUALIZAR
	public Egresso update(Egresso egresso) {
		Egresso newEgresso = find(egresso.getId());
		updateData(newEgresso, egresso);
		return repository.save(newEgresso);
	}

	// REMOVER
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível deletar o id informado: " + id);
		}
	}

	private void updateData(Egresso newEgresso, Egresso egresso) {
		newEgresso.setNome(egresso.getNome());
		newEgresso.setEmail(egresso.getEmail());
		newEgresso.setCpf(egresso.getCpf());
		newEgresso.setRg(egresso.getRg());
		newEgresso.setSenha(egresso.getSenha());
		newEgresso.setUsuario(egresso.getUsuario());
		newEgresso.setTelefoneCelular(egresso.getTelefoneCelular());
		newEgresso.setTelefoneFixo(egresso.getTelefoneFixo());
		newEgresso.setCursos(egresso.getCursos());
	}

}
