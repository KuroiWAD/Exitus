package br.edu.fatecourinhos.exitus.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VagaEmprego implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String vaga;
	private String descricacao;
	private Date dataCadastro;
	private Date dataInicio;
	private Date dataFim;
	
	//private Empresa empresa;

}
