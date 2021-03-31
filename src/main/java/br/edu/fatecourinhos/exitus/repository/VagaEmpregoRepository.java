package br.edu.fatecourinhos.exitus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecourinhos.exitus.domain.VagaEmprego;

@Repository
public interface VagaEmpregoRepository extends JpaRepository<VagaEmprego, Integer>{

}
