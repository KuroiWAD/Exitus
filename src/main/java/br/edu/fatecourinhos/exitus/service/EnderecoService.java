package br.edu.fatecourinhos.exitus.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecourinhos.exitus.domain.Egresso;
import br.edu.fatecourinhos.exitus.domain.Endereco;
import br.edu.fatecourinhos.exitus.repository.EnderecoRepository;
import br.edu.fatecourinhos.exitus.service.exception.EntidadeNaoEncontradaException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco buscarOuFalhar(Integer id) {
		return enderecoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException());
	}
	
	public Endereco find(Integer id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.orElseThrow(() -> new ObjectNotFoundException(
				"Egresso não encontrado! ID: " + id + ", Tipo: " , Egresso.class.getName()));
	}
}
