package br.edu.fatecourinhos.exitus.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecourinhos.exitus.domain.Egresso;
import br.edu.fatecourinhos.exitus.domain.Endereco;
import br.edu.fatecourinhos.exitus.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	// BUSCAR
	public Endereco find(Integer id) {
		Optional<Endereco> endereco = repository.findById(id);
		return endereco.orElseThrow(() -> new ObjectNotFoundException("Egresso não encontrado! ID: " + id + ", Tipo: ",
				Egresso.class.getName()));
	}

	// INSERIR
	public Endereco insert(Endereco endereco) {
		endereco.setId(null);
		return repository.save(endereco);
	}

	// ATUALIZAR
	public Endereco update(Endereco endereco) {
		Endereco newEndereco = find(endereco.getId());
		updateData(newEndereco, endereco);
		return repository.save(newEndereco);
	}

	private void updateData(Endereco newEndereco, Endereco endereco) {
		newEndereco.setLogradouro(endereco.getLogradouro());
		newEndereco.setNumero(endereco.getNumero());
		newEndereco.setCep(endereco.getCep());
		newEndereco.setBairro(endereco.getBairro());
		newEndereco.setComplemento(endereco.getComplemento());
	}

}
