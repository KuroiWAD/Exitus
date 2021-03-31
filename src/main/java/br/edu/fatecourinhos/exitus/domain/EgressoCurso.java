package br.edu.fatecourinhos.exitus.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EgressoCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private EgressoCursoPK id = new EgressoCursoPK();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFormacao;

	public EgressoCurso() {

	}

	public EgressoCurso(Egresso egresso, Curso curso, LocalDate dataFormacao) {
		super();
		id.setEgresso(egresso);
		id.setCurso(curso);
		this.dataFormacao = dataFormacao;
	}

	@JsonIgnore
	public Egresso getEgresso() {
		return id.getEgresso();
	}

	public void setEgresso(Egresso egresso) {
		id.setEgresso(egresso);
	}

	public Curso getCurso() {
		return id.getCurso();
	}

	public void setCurso(Curso curso) {
		id.setCurso(curso);
	}

	public EgressoCursoPK getId() {
		return id;
	}

	public void setId(EgressoCursoPK id) {
		this.id = id;
	}

	public LocalDate getDataFormacao() {
		return dataFormacao;
	}

	public void setDataFormacao(LocalDate dataFormacao) {
		this.dataFormacao = dataFormacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EgressoCurso other = (EgressoCurso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
