package br.edu.fatecourinhos.exitus.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class VagaEmprego implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String vaga;
	private String descricacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFim;
	
	//private Empresa empresa;

}
