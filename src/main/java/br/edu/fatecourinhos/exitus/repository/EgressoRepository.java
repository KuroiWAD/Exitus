package br.edu.fatecourinhos.exitus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecourinhos.exitus.domain.Egresso;

@Repository
public interface EgressoRepository extends JpaRepository<Egresso, Integer>{

}
