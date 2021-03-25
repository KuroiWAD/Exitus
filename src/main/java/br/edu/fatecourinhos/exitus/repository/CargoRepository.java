package br.edu.fatecourinhos.exitus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecourinhos.exitus.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
