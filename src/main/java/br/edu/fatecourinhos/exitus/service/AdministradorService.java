package br.edu.fatecourinhos.exitus.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecourinhos.exitus.domain.Administrador;
import br.edu.fatecourinhos.exitus.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repository;

	// BUSCAR
	public Administrador find(Integer id) {
		Optional<Administrador> administrador = repository.findById(id);
		return administrador.orElseThrow(() -> new ObjectNotFoundException("Egresso não encontrado! ID: " + id + ", Tipo: ",
				Administrador.class.getName()));
	}

	// INSERIR
	public Administrador insert(Administrador administrador) {
		administrador.setId(null);
		return repository.save(administrador);
	}

	// ATUALIZAR
	public Administrador update(Administrador endereco) {
		Administrador newEndereco = find(endereco.getId());
		updateData(newEndereco, endereco);
		return repository.save(newEndereco);
	}

	private void updateData(Administrador newAdministrador, Administrador administrador) {
		newAdministrador.setNome(administrador.getNome());

	}

}
